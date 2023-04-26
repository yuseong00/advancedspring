package hello.app.logtrace;

import hello.trace.TraceId;
import hello.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalLogTrace implements LogTrace {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private ThreadLocal<TraceId> traceIdHolder= new ThreadLocal<>(); //필드에 TraceId를 보관한다.

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();   //필드에 보관된 TraceId를 동기화한다.
        TraceId traceId = traceIdHolder.get(); //필드에 보관된 TraceId를 가져온다.
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX,
                traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    private void syncTraceId() {
        TraceId traceId = traceIdHolder.get();
        if (traceId == null) {
            traceIdHolder.set(new TraceId()); //최초 호출시에는 빈 TraceId를 생성한다.
        }
        else{
            traceIdHolder.set(traceId.createNextId()); //이후 호출시에는 이전 TraceId를 복사해서 다음 TraceId를 생성한다.
        }
    }


    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
                    resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
                    e.toString());
        }
        releaseTraceId(); //호출이 끝나면 TraceId를 해제한다.

    }

    private void releaseTraceId() {
        TraceId traceId = traceIdHolder.get(); //필드에 보관된 TraceId를 가져온다.
        if (traceId.isFirstLevel()) {
            traceIdHolder.remove(); //  파괴
        }else{
            traceIdHolder.set(traceId.createPreviousId()); //이전 TraceId로 복구
        }
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append( (i == level - 1) ? "|" + prefix : "| ");
        }
        return sb.toString();
    }
}


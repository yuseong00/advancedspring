package hello.advanced.trace;

public class TraceStatus { // 시작한 로그의 상태 정보를 담는 클래스

    private TraceId traceId;    // 트랜잭션 id
    private Long startTimeMs;   // 로그시작 시간
    private String message;    // 메시지
    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }
    public Long getStartTimeMs() {
        return startTimeMs;
    }
    public String getMessage() {
        return message;
    }
    public TraceId getTraceId() {
        return traceId;
    }


}

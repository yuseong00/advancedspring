package hello.app.logtrace;

import hello.trace.TraceStatus;

public interface LogTrace {

    //확작성을 생각하여 LogTrace 인터페이스에는 최소한의 기능인 메소드를 정의했다.

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}

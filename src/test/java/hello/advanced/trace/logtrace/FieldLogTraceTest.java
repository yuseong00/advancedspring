package hello.advanced.trace.logtrace;

import hello.advanced.app.logtrace.FieldLogTrace;
import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class FieldLogTraceTest {
    
    FieldLogTrace trace = new FieldLogTrace();
    
    @Test
    public void  level2   ()throws Exception{
    //given
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);

    }
    @Test
    public void  level2_exception   ()throws Exception{
        //given
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new Exception("예외발생"));
        trace.exception(status1, new Exception("예외발생"));

    }


}
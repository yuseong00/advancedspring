package hello.trace.hellotrace;

import hello.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTraceV2Test {

    @Test
    public void  로그추적기   ()throws Exception{
    //given
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status);
    }


    @Test
    public void  로그추적기2   ()throws Exception{
    //given
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status.getTraceId(),"hello2");
        trace.exception(status2, new Exception("예외발생"));
        trace.exception(status, new Exception("예외발생"));

    //when
     
    
    //then
     
    
    }

}
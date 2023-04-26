package hello.trace.hellotrace;

import hello.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTraceV1Test {

    @Test
    public void  로그추적기   ()throws Exception{
    //given
      HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }


    @Test
    public void  로그추적기2   ()throws Exception{
    //given
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new Exception("예외발생"));
    
    //when
     
    
    //then
     
    
    }

}
package hello.exam;

import hello.aop.order.aop.exam.ExamService;
import hello.aop.order.aop.exam.aop.RetryAspect;
import hello.aop.order.aop.exam.aop.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import({TraceAspect.class})
@SpringBootTest
public class ExamTest {

    @Autowired
    ExamService examService;
    
    @Test
    public void  test   ()throws Exception{
      for (int i = 0; i < 5; i++) {
          log.info("data"+i);
          examService.request("data"+i);
      }
    }
}

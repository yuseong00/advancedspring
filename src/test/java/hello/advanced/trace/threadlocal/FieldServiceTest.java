package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;



@Slf4j
public class FieldServiceTest {

    private final FieldService fieldService = new FieldService();

    @Test
    public void field() throws Exception {
        //given
        log.info("main thread start");
        Runnable userA = () -> {
            fieldService.logic("user-A");
        };

        Runnable userB = () -> {
            fieldService.logic("user-B");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); //동시성 문제가 발생하지 않는 로직 ( 2초가 지나야 threadB가 실행됨)
        sleep(100); //동시성 문제가 발생하는 로직 ( 0.1초가 지나야 threadB가 실행됨)
        threadB.start();
        sleep(3000); // 3초가 지나야 main thread가 종료됨
        log.info("main thread end");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


}

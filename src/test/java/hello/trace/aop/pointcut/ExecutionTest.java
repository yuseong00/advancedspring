package hello.trace.aop.pointcut;

import hello.aop.order.member.annotation.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ExecutionTest {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;
    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

//public java.lang.String hello.aop.order.member.annotation.MemberServiceImpl.hello(java.lang.String)
    @Test
    void printMethod(){
        log.info("method={}", helloMethod);
    }

    @Test
    void exactMatch(){
        pointcut.setExpression("execution(public String hello.aop.order.member.annotation.MemberServiceImpl.hello(String))");

        assertThat(pointcut.matches(helloMethod,MemberServiceImpl.class)).isTrue();
    }

    @Test
    public void  allMatch  ()throws Exception{

        pointcut.setExpression("execution(* *(..))");
        assertThat(pointcut.matches(helloMethod,MemberServiceImpl.class)).isTrue();

    }
    @Test
    public void  nameMatch  ()throws Exception{

        pointcut.setExpression("execution(* hello(..))");
        assertThat(pointcut.matches(helloMethod,MemberServiceImpl.class)).isTrue();

    }
}

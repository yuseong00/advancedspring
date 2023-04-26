package hello.aop.order.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  //메소드에만 적용
@Retention(RetentionPolicy.RUNTIME) //실행될때까지 이 어노테이션이 살아있음.
public @interface MethodAop {

    String value();
}

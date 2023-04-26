package hello.aop.order.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  //클래스에만 적용
@Retention(RetentionPolicy.CLASS) //컴파일러가 클래스를 참조할 때까지 유효
public @interface ClassAop {


}

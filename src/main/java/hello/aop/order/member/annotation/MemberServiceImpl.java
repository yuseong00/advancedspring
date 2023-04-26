package hello.aop.order.member.annotation;

import hello.aop.order.member.MemberService;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {
    @Override
    @MethodAop("test Value")
    public String hello(String param) {
        return "ok";
    }

    public String internal(String param) {
        return "ok";
    }

}

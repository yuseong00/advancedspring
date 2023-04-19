package hello.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

    private Subject target; //proxy가 호출하는 대상을 타겟이라 한다.
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }


    @Override
    public String operation() {

        log.info("프록시 객체호출");
        if (cacheValue == null) {
            cacheValue = target.operation();
        }
        return cacheValue;
    }
}

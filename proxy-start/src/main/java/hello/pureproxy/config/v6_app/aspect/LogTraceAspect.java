package hello.pureproxy.config.v6_app.aspect;

import hello.pureproxy.trace.TraceStatus;
import hello.pureproxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Method;

@Slf4j
@Aspect
public class LogTraceAspect {
    private final LogTrace logTrace;


    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    // 모든 메서드에 적용
    @Around("execution(* hello.pureproxy..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = null;
        try {
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);
            //target 호출

            Object result = joinPoint.proceed();
            logTrace.end(status);
            return result;
        }catch ( Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

}

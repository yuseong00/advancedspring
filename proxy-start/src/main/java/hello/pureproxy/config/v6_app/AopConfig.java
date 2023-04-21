package hello.pureproxy.config.v6_app;

import hello.pureproxy.config.AppV1Config;
import hello.pureproxy.config.AppV2Config;
import hello.pureproxy.config.v6_app.aspect.LogTraceAspect;
import hello.pureproxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }

}

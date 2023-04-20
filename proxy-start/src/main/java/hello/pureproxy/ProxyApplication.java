package hello.pureproxy;

import hello.pureproxy.app.config.AppV2Config;
import hello.pureproxy.config.v1_proxy.InterfaceProxyConfig;
import hello.pureproxy.trace.logtrace.LogTrace;
import hello.pureproxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
//@Import(AppV2Config.class)
//@Import(AppV1Config.class)
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.pureproxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}

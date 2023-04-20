package hello.proxy.pureproxy;

import hello.proxy.pureproxy.code.CacheProxy;
import hello.proxy.pureproxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {
    
    @Test
    public void  proxy   ()throws Exception{
    //given
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(realSubject);
        proxyPatternClient.execute();
        proxyPatternClient.execute();
        proxyPatternClient.execute();
    }
    
    @Test
    public void  cache   ()throws Exception{
     RealSubject realSubject = new RealSubject();
     CacheProxy cacheProxy = new CacheProxy(realSubject);
     ProxyPatternClient proxyPatternClient = new ProxyPatternClient(cacheProxy);
        proxyPatternClient.execute();
        proxyPatternClient.execute();
        proxyPatternClient.execute();

    }
}

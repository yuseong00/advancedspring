package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//스프링은 @Controller 또는 @RequestMapping이 붙은 클래스를 찾아서 Bean으로 등록한다.
@RequestMapping
@ResponseBody
public interface OrderControllerV1 {


    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String nolog(@RequestParam("itemId") String itemId);


}

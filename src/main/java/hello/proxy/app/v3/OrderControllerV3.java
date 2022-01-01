package hello.proxy.app.v3;

import hello.proxy.app.v2.OrderServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderControllerV3 {
    private final OrderServiceV2 orderService;
    public OrderControllerV3(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    // LogTrace를 적용할 대상
    @GetMapping("/v3/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    // LogTrace를 적용하지 않은 대상
    @GetMapping("/v3/no-log")
    public String noLog() {
        return "ok";
    }
}

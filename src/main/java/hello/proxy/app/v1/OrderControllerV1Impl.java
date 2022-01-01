package hello.proxy.app.v1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderControllerV1Impl implements OrderControllerV1{
    private final OrderServiceV1 orderService;
    public OrderControllerV1Impl(OrderServiceV1 orderService) {
        this.orderService = orderService;
    }

    // LogTrace를 적용할 대상
    @Override
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    // LogTrace를 적용하지 않은 대상
    @Override
    public String noLog() {
        return "ok";
    }
}

package com.dreamai.orderservice.controller;

import com.dreamai.orderservice.dto.OrderRequest;
import com.dreamai.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        log.info("Placing Order");
        return "Placing Order";
    }

}

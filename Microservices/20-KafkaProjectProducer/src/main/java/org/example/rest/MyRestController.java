package org.example.rest;

import org.example.bindings.Orders;
import org.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class MyRestController {

    private final OrderService orderService;

    MyRestController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyOrder(@RequestBody Orders orders){
        boolean buy = orderService.buyOrder(orders);
        if(buy){
            return new ResponseEntity<>("Order Completed Successfully you will recieve mail shortly !!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Order Failed", HttpStatus.BAD_REQUEST);
    }
}

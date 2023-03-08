package com.omada_mixali.orders;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    @GetMapping("/{id}")
    public  Order getOrderBuId(@PathVariable Integer id) {
        return orderRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public  Order createOrder(@RequestBody Order order) {
        return orderRepo.save(order);
    }
}

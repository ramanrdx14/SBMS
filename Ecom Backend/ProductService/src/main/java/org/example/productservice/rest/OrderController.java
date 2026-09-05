package org.example.productservice.rest;

import jakarta.transaction.Transactional;
import org.example.productservice.client.CustomerClient;
import org.example.productservice.entity.Orders;
import org.example.productservice.entity.ProdOrderDetails;
import org.example.productservice.entity.Products;
import org.example.productservice.repo.OrderRepo;
import org.example.productservice.repo.ProductOrderDetailsRepo;
import org.example.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    Map<Integer,Integer> cart = new HashMap<>();

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerClient customerClient;

    @Autowired
    ProductOrderDetailsRepo productOrderDetailsRepo;
    @GetMapping("/cart/{pid}")
    public ResponseEntity<Map<Integer,Integer>> addToCart(@PathVariable("pid") Integer pid){
        Optional<Products> byId = productRepo.findById(pid);
        if(byId.isPresent()){
            Products products = byId.get();
            if(cart.containsKey(products.getProductId()))cart.put(products.getProductId(),cart.getOrDefault(products.getProductId(),0)+1);
            cart.putIfAbsent(products.getProductId(),1);
        }
        return new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
    }

    @GetMapping("/cart/buy")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<String> buy(@RequestHeader("Current_User") String email){
        Integer totalCost = 0;
        Orders orders = new Orders();
        ResponseEntity<Integer> loggedInCustomer = customerClient.getLoggedInCustomer(email);
        orders.setCustomerId(loggedInCustomer.getBody());
        orderRepo.save(orders);

        for (Integer prodId:cart.keySet()){
            ProdOrderDetails prodOrderDetails = new ProdOrderDetails();
            Products product = productRepo.findById(prodId).get();
            prodOrderDetails.setOrders(orders);
            prodOrderDetails.setItemCount(Integer.valueOf(Integer.toString(cart.get(prodId))));
            prodOrderDetails.setProducts(product);
            prodOrderDetails.setTotalCost((int) (product.getProductPrice()*cart.get(prodId)));
            totalCost += prodOrderDetails.getTotalCost();
            productOrderDetailsRepo.save(prodOrderDetails);
        }
        return new ResponseEntity<>("Ordered Completed Successfully !! TotalCost :"+totalCost,HttpStatus.OK);
    }
}

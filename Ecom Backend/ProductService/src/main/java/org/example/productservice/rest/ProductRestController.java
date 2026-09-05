package org.example.productservice.rest;

import jakarta.ws.rs.PathParam;
import org.example.productservice.entity.Products;
import org.example.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    ProductRepo productRepo;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Products products){
        productRepo.save(products);
        return new ResponseEntity<>("Product Added Successfully",HttpStatus.ACCEPTED);
    }
    @GetMapping("/remove/{pid}")
    public ResponseEntity<String> removeProduct(@PathVariable("pid") Integer pid){
        Optional<Products> byId = productRepo.findById(pid);
        if(byId.isPresent()) {
            productRepo.delete(byId.get());
            return new ResponseEntity<>("Product Deleted Successfully  PID = "+pid, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Product Found by product id = "+pid, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Products products){
        productRepo.save(products);
        return new ResponseEntity<>("Product Information Updated",HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Products>> fetchProduct(){
        return new ResponseEntity<>(productRepo.findAll(),HttpStatus.OK);
    }
}

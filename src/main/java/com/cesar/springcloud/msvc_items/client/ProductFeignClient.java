package com.cesar.springcloud.msvc_items.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cesar.springcloud.msvc_items.model.Product;

@FeignClient(name = "msvc-products")
public interface ProductFeignClient {

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> list();

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> detail(@PathVariable Long id);

}

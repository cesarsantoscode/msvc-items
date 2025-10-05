package com.cesar.springcloud.msvc_items.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cesar.springcloud.msvc_items.model.Item;
import com.cesar.springcloud.msvc_items.model.Product;
import com.cesar.springcloud.msvc_items.service.ItemService;

//@Primary
@Service
public class ItemWCServiceImpl implements ItemService {

    @Autowired
    private WebClient.Builder webClient;

    @Override
    public List<Item> findAll() {
        return webClient.build()
            .get()
            .uri("/api/products")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(Product.class)
            .map(product -> new Item(product, new Random().nextInt(10)))
            .collectList()
            .block();
    }

    @Override
    public Optional<Item> findById(Long id) {
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);
        return Optional.ofNullable(webClient.build()
            .get()
            .uri("/api/products/{id}", params)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Product.class)
            .map(product -> new Item(product, new Random().nextInt(10)))
            .block()
        );
    }

}

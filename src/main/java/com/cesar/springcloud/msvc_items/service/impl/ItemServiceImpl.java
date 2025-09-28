package com.cesar.springcloud.msvc_items.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesar.springcloud.msvc_items.client.ProductFeignClient;
import com.cesar.springcloud.msvc_items.model.Item;
import com.cesar.springcloud.msvc_items.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public List<Item> findAll() {
        return productFeignClient.list().getBody().stream().map(product -> {
            return new Item(product, new Random().nextInt(10));
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.of(new Item(productFeignClient.detail(id).getBody(), new Random().nextInt(10)));
    }

}

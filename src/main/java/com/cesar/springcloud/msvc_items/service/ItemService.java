package com.cesar.springcloud.msvc_items.service;

import java.util.List;
import java.util.Optional;

import com.cesar.springcloud.msvc_items.model.Item;

public interface ItemService {

    List<Item> findAll();

    Optional<Item> findById(Long id);

}

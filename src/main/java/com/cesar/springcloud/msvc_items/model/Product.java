package com.cesar.springcloud.msvc_items.model;

import java.util.Date;

public record Product(Long id, String name, Double price, Date createAt, int port) {

}

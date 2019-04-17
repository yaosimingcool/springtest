package com.baizhi.service;

import com.baizhi.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> selectProduct(String context);
    public void add(Product product);
}

package com.baizhi.lucenedao;

import com.baizhi.entity.Product;

import java.util.List;

public interface LuceneDAO {
    public List<Product> selectProduct(String context);
    public void add(Product product);
}

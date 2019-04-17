package com.baizhi.serviceImpl;

import com.baizhi.dao.ProductDAO;
import com.baizhi.entity.Product;
import com.baizhi.lucenedao.LuceneDAO;
import com.baizhi.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    private LuceneDAO luceneDAO;
    @Resource
    private ProductDAO productDAO;

    @Override
    public List<Product> selectProduct(String context) {
        return luceneDAO.selectProduct(context);
    }

    @Override
    public void add(Product product) {
        System.out.println(product);
        luceneDAO.add(product);
    }
}

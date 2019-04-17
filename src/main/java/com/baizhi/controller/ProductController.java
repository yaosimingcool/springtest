package com.baizhi.controller;

import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping("show")
   public String showProduct(String context, HttpServletRequest request) throws Exception{

        List<Product> products = productService.selectProduct(context);
        request.setAttribute("products",products);
        return "forward:/view/search.jsp";
    }

    //添加
    @RequestMapping("add")
    public String addProduct(Product product) throws Exception{

        productService.add(product);
        return "redirect:/view/search.jsp";
    }
}

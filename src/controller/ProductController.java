package controller;

import entry.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-21-17:15
 */
public class ProductController {
    ProductService productService = new ProductServiceImpl();

    public List<Product> findProducts(){
        return productService.findProducts();
    }
}

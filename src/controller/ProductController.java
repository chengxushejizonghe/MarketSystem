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

    /**
     * 查找所有商品
     * @return
     */
    public List<Product> findProducts(){
        return productService.findProducts();
    }

    /**
     * 根据商品编号查找所有商品
     * @return
     */
    public Product findProductById(int id){
        Product product = productService.findProductById(id);
        if (product == null){
            System.out.println("找不到该商品");
        }
        return product;
    }

    /**
     * 修改商品信息
     * @param product
     * @return
     */
    public boolean updateProduct(Product product){
        //update product set productName = ?,price = ?,type = ?,productionDate = ?,
        // quantity = ?,salesVolume = ? where id = ?
        if(productService.updateProduct(product)){
            System.out.println("修改商品信息成功！");
            return true;
        }else{
            System.out.println("修改用户信息失败！");
            return false;
        }
    }


}

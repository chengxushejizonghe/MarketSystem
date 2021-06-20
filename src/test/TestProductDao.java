package test;

import dao.ProductDao;
import dao.ProductDaoImpl;
import entry.Product;
import org.junit.Test;
import utills.JDBCUtils;

import java.time.LocalDateTime;


/**
 * @author 林敬舒
 * @create 2021-06-20-11:10
 */
public class TestProductDao {

    @Test
    public void testAddProduct(){
        Product product = new Product();
        product.setProductName("可口可乐");
        product.setPrice(2.00);
        product.setType("饮料");
        product.setProductionDate(LocalDateTime.now());
        product.setQuantity(20);
        ProductDao productDao = new ProductDaoImpl();
        productDao.addProduct(product);
        JDBCUtils.releaseAll(productDao.getConnection(),null,null);
        System.out.println("添加成功");
    }

    @Test
    public void testFindProducts(){
        ProductDao productDao = new ProductDaoImpl();
        System.out.println(productDao.findProducts());
        JDBCUtils.releaseAll(productDao.getConnection(),null,null);
    }
}

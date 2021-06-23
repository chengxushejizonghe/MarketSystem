package dao;

import entry.Product;

import java.sql.Connection;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-02-21:07
 */
public interface ProductDao {
    public boolean addProduct(Product product);
    public List<Product> findProducts();
    public Product findProductById(int id);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(int id);
    public Product findProductByName(String productName);

    /**
     * 减少商品数量，或购买商品导致数量减少
     * @param id 商品编号
     * @param count 数量
     * @return
     */
    public boolean decreaseProductCount(int id,int count);

    /**
     * 补充库存
     * @param id 商品编号
     * @param count 数量
     * @return
     */
    public boolean increaseProductCount(int id,int count);
    public boolean increaseSalesVolume(int id,int count);
    public Connection getConnection();

}

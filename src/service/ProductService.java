package service;

import entry.Product;

import java.util.List;

/**
 * @author 林敬舒
 * @author
 * @create 2021-06-10-13:15
 */
public interface ProductService {
    public boolean addProduct(Product product);
    public List<Product> findProducts();
    public Product findProductById(int id);
    public boolean updateProduct(Product product);
    public Product findProductByName(String productName);
    public boolean deleteProduct(int id);
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
}

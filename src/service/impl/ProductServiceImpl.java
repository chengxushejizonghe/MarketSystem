package service.impl;

import dao.ProductDao;
import dao.ProductDaoImpl;
import entry.Product;
import service.ProductService;

import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-10-13:15
 */
public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDaoImpl();
    @Override
    public boolean addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public List<Product> findProducts() {
        return productDao.findProducts();
    }

    @Override
    public Product findProductById(int id) {
        return productDao.findProductById(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public Product findProductByName(String productName) {
        return productDao.findProductByName(productName);
    }

    /**
     * 减少商品数量，或购买商品导致数量减少
     *
     * @param id    商品编号
     * @param count 数量
     * @return
     */
    @Override
    public boolean decreaseProductCount(int id, int count) {
        return productDao.decreaseProductCount(id,count);
    }

    /**
     * 补充库存
     * @param id    商品编号
     * @param count 数量
     * @return
     */
    @Override
    public boolean increaseProductCount(int id, int count) {
        return productDao.increaseProductCount(id,count);
    }
}

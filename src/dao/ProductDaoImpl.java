package dao;

import entry.Product;

import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-17-20:59
 */
public class ProductDaoImpl extends BaseDao<ProductDao> implements ProductDao{
    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public List<Product> findProducts() {
        return null;
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
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
        return false;
    }

    /**
     * 补充库存
     *
     * @param id    商品编号
     * @param count 数量
     * @return
     */
    @Override
    public boolean increaseProductCount(int id, int count) {
        return false;
    }
}

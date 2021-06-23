package dao;

import entry.Product;
import utills.JDBCUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-17-20:59
 */
public class ProductDaoImpl extends BaseDao<Product> implements ProductDao{

    public Connection connection = JDBCUtils.getConnection();

    /**
     * 添加商品
     * @param product 商品
     * @return 是否添加成功
     */
    @Override
    public boolean addProduct(Product product) {
        String sql = "insert into product(productName,price,type,productionDate,quantity) values(?,?,?,?,?)";
        return update(connection,sql,product.getProductName(),product.getPrice(),product.getType(),product.getProductionDate(),product.getQuantity()) > 0;

    }

    /**
     * 查找所有的商品
     * @return 返回所有商品List
     */
    @Override
    public List<Product> findProducts() {
        String sql = "select * from product";
        return getForList(connection,sql);
    }

    @Override
    public Product findProductById(int id) {
        String sql = "select * from product where id = ?";

        return getInstance(connection,sql,id);
    }

    @Override
    public boolean updateProduct(Product product) {
        String sql = "update product set productName = ?,price = ?,type = ?,productionDate = ?,quantity = ?,salesVolume = ? where id = ?";
        return update(connection,sql,product.getProductName(),product.getPrice(),product.getType(),product.getProductionDate(),
                product.getQuantity(),product.getSalesVolume(),product.getId()) > 0;
    }

    @Override
    public boolean deleteProduct(int id) {
        String sql = "delete from product where id = ?";
        return update(connection,sql,id) > 0;
    }

    @Override
    public Product findProductByName(String productName) {
        String sql = "select * from product where productName = ?";
        return getInstance(connection,sql,productName);
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
        String sql = "update product set quantity = quantity - ? where id = ?";
        return update(connection,sql,count,id) > 0;
    }

    /**
     * 补充商品库存
     * @param id    商品编号
     * @param count 添加的数量
     * @return
     */
    @Override
    public boolean increaseProductCount(int id, int count) {
        String sql = "update product set quantity = quantity + ? where id = ?";
        return update(connection,sql,count,id) > 0;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}

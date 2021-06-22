package dao;

import entry.Customer;
import utills.JDBCUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author
 * 负责数据库的存储、读写，该类为临时创建，可在此包添加其他类或删除该类
 */
public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao{

    public Connection conn = JDBCUtils.getConnection();
    /**
     * 向Customer表插入数据
     * @param customer 从service层值传递获得
     */
    public boolean insertCustomer(Customer customer) {
        String sql = "insert into Customer(username,password,balance,realName,contactPhone,email) " +
                "values(?,?,?,?,?,?)";
        boolean flag = update(conn,sql,customer.getUsername(),customer.getPassword(),customer.getBalance(),customer.getRealName()
        ,customer.getContactPhone(),customer.getEmail()) > 0;
//        JDBCUtils.releaseAll(conn,null);
        return flag;
    }

    /**
     * 查询所有消费者
     * @return 将查询得到的结果集用List返回
     */
    public List<Customer> findCustomers() {
        String sql = "select * from customer";
        //        JDBCUtils.releaseAll(conn,null);
        return getForList(conn,sql);
    }

    /**
     * 删除用户
     */
    public boolean deleteCustomer(int id) {
        String sql = "delete from customer where id = ?";
        boolean flag = update(conn,sql,id) > 0;
//        JDBCUtils.releaseAll(conn,null);
        return flag;
    }

    /**
     * 更新用户
     */
    public boolean updateCustomer(Customer customer){
        String sql = "update customer "+
                "set username = ?,password = ?,realName = ?,contactPhone = ?,email = ?,level = ? "+
                "where id = ?";
        boolean flag = update(conn,sql,customer.getUsername(),customer.getPassword(),customer.getRealName(),
                customer.getContactPhone(),customer.getEmail(),customer.getLevel(),customer.getId()) > 0;
//        JDBCUtils.releaseAll(conn,null);
        return flag;
    }

    @Override
    public Customer findCustomerById(int id) {
        String sql = "select * from customer where id = ?";
        Customer customer = getInstance(conn,sql,id);
//        JDBCUtils.releaseAll(conn,null);
        return customer;
    }

    @Override
    public int getCustomersCount() {
        String sql = "select count(*) from customer";
        int count = getValue(conn,sql);
//        JDBCUtils.releaseAll(conn,null);
        return count;
    }

    @Override
    public boolean changeCustomerPwd(String username,String oldPassword,String newPassword) {
        String sql = "update customer set password = ? where username = ? and password = ?";
        boolean flag = update(conn,sql,newPassword,username,oldPassword) > 0;
        return flag;
    }

    @Override
    public Customer findCustomerByLogin(String username, String password) {
        String sql = "select * from customer where username = ? and password = ?";
        return getInstance(conn,sql,username,password);
    }

    @Override
    public Customer findCustomerByName(String name) {
        String sql = "select * from customer where username = ?";
        return getInstance(conn,sql,name);
    }

    /**
     * 增加或减少用户的余额
     *
     * @param username 用户名
     * @param password 密码
     * @param change   用户余额增加或减少的量，change>0为增加余额，反之减少余额
     * @return 是否修改成功
     */
    @Override
    public boolean increaseOrDecreaseCustomerBalance(String username, String password, double change) {
        String sql = "update customer set balance = balance + ? where username = ? and password = ?";
        return update(conn,sql,change,username,password) > 0;
    }

    /**
     * 提升用户等级
     *
     * @param username   用户名
     * @param change 等级变化量
     * @return
     */
    @Override
    public boolean upgradeCustomerLevel(String username, int change) {
        String sql = "update customer set level = level + 1 where username = ?";
        return update(conn,sql,username,change) > 0;
    }

    @Override
    public Connection getConnection() {
        return conn;
    }
}

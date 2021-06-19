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

    public static Connection conn = JDBCUtils.getConnection();
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
        List<Customer> customerList = getForList(conn,sql);
//        JDBCUtils.releaseAll(conn,null);
        return customerList;
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
    public boolean changeCustomerPwd(String password,int id) {
        String sql = "update customer set password = ? where id = ?";
        boolean flag = update(conn,sql,password,id) > 0;
        return flag;
    }

    @Override
    public Customer findCustomerByLogin(String username, String password) {
        String sql = "select * from customer where username = ? and password = ?";
        return getInstance(conn,sql,username,password);
    }
}

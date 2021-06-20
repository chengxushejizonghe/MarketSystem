package dao;

import entry.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-17-20:58
 */
public interface CustomerDao {

    /**
     * customer对象添加到数据库中
     * @param customer
     * @return
     */
    public boolean insertCustomer(Customer customer);

    /**
     * 查询所有用户
     * @return
     */
    public List<Customer> findCustomers();

    /**
     * 根据指定的id,删除Customer表中的一条记录
     * @param id
     * @return
     */
    public boolean deleteCustomer(int id);

    /**
     * 针对内存中的customer对象，去修改数据表中指定的记录
     * @param customer
     * @return
     */
    public boolean updateCustomer(Customer customer);

    /**
     * 根据id查询得到对应的Customer对象
     * @param id
     * @return
     */
    public Customer findCustomerById(int id);

    /**
     * 返回数据的条目数
     * @return
     */
    public int getCustomersCount();

    public boolean changeCustomerPwd(String password,int id);

    public Customer findCustomerByLogin(String username,String password);

    public Connection getConnection();
}

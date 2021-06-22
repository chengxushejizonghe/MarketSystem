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

    public boolean changeCustomerPwd(String username,String oldPassword,String newPassword);

    public Customer findCustomerByLogin(String username,String password);

    public Customer findCustomerByName(String name);

    /**
     * 增加或减少用户的余额
     * @param username 用户名
     * @param password 密码
     * @param change 用户余额增加或减少的量，change>0为增加余额，反之减少余额
     * @return 是否修改成功
     */
    public boolean increaseOrDecreaseCustomerBalance(String username,String password,double change);

    /**
     * 提升用户等级
     * @param name 用户名
     * @param change 等级变化量
     * @return
     */
    public boolean upgradeCustomerLevel(String username,int change);

    public Connection getConnection();
}

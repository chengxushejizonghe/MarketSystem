package test;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entry.Customer;
import org.junit.Test;
import utills.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 测试CustomerDao
 * @author 林敬舒
 * @create 2021-06-16-16:54
 */
public class TestCustomerDao {
    @Test
    public void testFindCustomer() throws SQLException {
        CustomerDao customerDao= new CustomerDaoImpl();
        List<Customer> customerList = customerDao.findCustomers();
        System.out.println(customerList);
        JDBCUtils.releaseAll(customerDao.getConnection(),null,null);
    }

    @Test
    public void testInsertCustomer() throws SQLException {
        Customer customer = new Customer();
        customer.setUsername("我是你爸");
        customer.setPassword("54321");
        customer.setRealName("Jerry Bob");
        customer.setContactPhone("13823878923");
        customer.setEmail("a7789546@gmail.com");
        CustomerDao customerDao = new CustomerDaoImpl();
        System.out.println(customerDao.insertCustomer(customer));
    }

    @Test
    public void testDeleteCustomer() throws SQLException {
        int id = 2;
        CustomerDao customerDao = new CustomerDaoImpl();
        System.out.println(customerDao.deleteCustomer(id));
    }

    @Test
    public void testUpdateCustomer(){
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = new Customer();
        //与dao层相对应
        customer.setId(3);
        customer.setUsername("wu");
        customer.setPassword("321654");
        customer.setRealName("无");
        customer.setContactPhone("5465168");
        customer.setEmail("a6s54c@a3s5c4.com");
        customer.setLevel(1);
        customerDao.updateCustomer(customer);
    }

    @Test
    public void testFindCustomerById(){
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.findCustomerById(10);
        System.out.println(customer);
    }

    @Test
    public void testChangeCustomerPwd(){
        int id = 4;
        CustomerDao customerDao = new CustomerDaoImpl();
        String changePassword = "3356";
        System.out.println(customerDao.changeCustomerPwd(changePassword,id));
    }

    @Test
    public void testCustomerLogin(){
        String username = "lbwnb";
        String password = "123456";
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.findCustomerByLogin(username,password);
        if (customer != null){
            System.out.println("登录成功");
            System.out.println(customer);
        }else {
            System.out.println("登录失败");
        }
    }
}

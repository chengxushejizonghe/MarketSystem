package test;

import java.sql.SQLException;
import java.util.List;

import dao.CustomerDaoImpl;
import org.junit.Test;

import dao.CustomerDao;
import entry.Customer;

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
    }

    @Test
    public void testInsertCustomer() throws SQLException {
        Customer customer = new Customer();
        customer.setUsername("我是你爸");
        customer.setPassword("54321");
        customer.setBalance(100);
        customer.setRealName("Jerry Bob");
        customer.setContactPhone("13823878923");
        customer.setEmail("acs546@gmail.com");
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
        Customer customer = new Customer();
        customer.setPassword("33589");
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.updateCustomer(customer);
    }

    @Test
    public void testFindCustomerById(){
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.findCustomerById(4);
        System.out.println(customer);
    }
}

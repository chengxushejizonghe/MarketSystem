package test;

import java.sql.SQLException;
import java.util.List;

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
        CustomerDao customerDao= new CustomerDao();
        List<Customer> customerList = customerDao.findCustomers();
        System.out.println(customerList);
    }

    @Test
    public void testInsertCustomer() throws SQLException {
        Customer customer = new Customer();
        customer.setUsername("yyds");
        customer.setPassword("123456");
        customer.setBalance(150);
        customer.setContactPhone("13823831820");
        customer.setEmail("sa654cs@gmail.com");
        CustomerDao customerDao = new CustomerDao();
        customerDao.insertCustomer(customer);
    }
}

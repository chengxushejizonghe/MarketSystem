package test;

import dao.CustomerDao;
import entry.Customer;
import org.junit.Test;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-11-17:09
 */
public class TestCustomerService {
    @Test
    public void testFindCustomer() throws SQLException {
//        CustomerDao customerDao = new CustomerDao();
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> customerList = customerService.findCustomers();
        System.out.println(customerList);
    }
}

package test;

import dao.CustomerDao;
import entry.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-11-17:09
 */
public class TestCustomerService {
    public static void main(String[] args) throws SQLException {
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> customers = customerService.findCustomers();
        System.out.println(customers);
    }
}

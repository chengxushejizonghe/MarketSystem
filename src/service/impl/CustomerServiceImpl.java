package service.impl;

import dao.CustomerDao;
import entry.Customer;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-09-19:13
 */

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerDao.insertCustomer(customer);
    }

    @Override
    public List<Customer> findCustomers() throws SQLException {
        return customerDao.findCustomers();
    }
}

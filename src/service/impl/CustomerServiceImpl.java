package service.impl;

import dao.CustomerDao;
import entry.Customer;
import service.CustomerService;

import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-09-19:13
 */

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;


    @Override
    public boolean insertCustomer(Customer customer) {
        return customerDao.insertCustomer(customer);

    }

    @Override
    public List<Customer> findCustomers() {
        return customerDao.findCustomers();
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerDao.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }
}

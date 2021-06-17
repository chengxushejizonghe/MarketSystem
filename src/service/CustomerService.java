package service;

import entry.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-09-19:13
 */
public interface CustomerService {
    public boolean insertCustomer(Customer customer) throws SQLException;
    public List<Customer> findCustomers() throws SQLException;
    public boolean deleteCustomer(int id) throws SQLException;
    public boolean updateCustomer(Customer customer) throws SQLException;
}

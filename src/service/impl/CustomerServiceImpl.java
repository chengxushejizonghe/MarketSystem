package service.impl;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entry.Customer;
import service.CustomerService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-09-19:13
 */

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();
    
    @Override
    public List<Customer> selectCustomer(){
    	return customerDao.selectCustomer();
    }


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

    @Override
    public boolean changeCustomerPwd(String username,String oldPassword,String newPassword){
        return customerDao.changeCustomerPwd(username,oldPassword,newPassword);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public Customer findCustomerByName(String name) {
        return customerDao.findCustomerByName(name);
    }

    @Override
    public Customer findCustomerByLogin(String username,String password) {
        return customerDao.findCustomerByLogin(username,password);
    }

    @Override
    public boolean increaseOrDecreaseCustomerBalance(String username, String password, double change) {
        return customerDao.increaseOrDecreaseCustomerBalance(username, password, change);
    }

    @Override
    public boolean upgradeCustomerLevel(String username, int change) {
        return customerDao.upgradeCustomerLevel(username, change);
    }


}

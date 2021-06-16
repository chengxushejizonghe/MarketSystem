package dao;

import entry.Customer;
import utills.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责数据库的存储、读写，该类为临时创建，可在此包添加其他类或删除该类
 */
public class CustomerDao {
    /**
     * 向Customer表插入数据
     * @param customer 从service层值传递获得
     */
    public void insertCustomer(Customer customer) throws SQLException{
        //获取connection
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into Customer(username,password,balance,realName,contactPhone,email) " +
                "values(?,?,?,?,?,?)";
        //预编译sql
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setString(1,customer.getUsername());
            preparedStatement.setString(2,customer.getPassword());
            preparedStatement.setDouble(3,customer.getBalance());
            preparedStatement.setString(4,customer.getRealName());
            preparedStatement.setString(5,customer.getContactPhone());
            preparedStatement.setString(6,customer.getEmail());
            //执行sql语句
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtils.releaseAll(connection,preparedStatement);
        }

    }

    /**
     * 查询所有消费者
     * @return 将查询得到的结果集用List返回
     * @throws SQLException
     */
    public List<Customer> findCustomers() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from customer";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //执行查询语句得到结果集
        ResultSet resultSet = null;
        List<Customer> customerList = null;
        try {
            resultSet = preparedStatement.executeQuery();

            customerList = new ArrayList<>();
            Customer customer = null;
            while (resultSet.next()){
                customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setUsername(resultSet.getString("username"));
                customer.setPassword(resultSet.getString("password"));
                customer.setBalance(resultSet.getDouble("balance"));
                customer.setRealName(resultSet.getString("realName"));
                customer.setCreationTime(resultSet.getDate("creationTime"));
                customer.setContactPhone(resultSet.getString("contactPhone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setLevel(resultSet.getInt("level"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseAll(connection,preparedStatement,resultSet);
        }
        return customerList;
    }

    /**
     * 删除用户
     */
    public void deleteCustomer(){
        Connection connection = JDBCUtils.getConnection();
    }
}

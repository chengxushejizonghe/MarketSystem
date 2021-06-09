package utills;


import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 操作数据库的工具类
 * @author 林敬舒
 * @create 2021-06-02-20:40
 */
public class JDBCUtils {

    private static DataSource source;
    static {
        try {
            Properties properties = new Properties();
            FileInputStream is = new FileInputStream("config/db.properties");
            properties.load(is);
            source = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("DBCP初始化异常，请检查配置文件！！！");
        }
    }
    /**
     * 使用DBCP数据库连接池获取数据库连接对象
     * @return Connection
     */
    public static Connection getConnection(){
        try {
            return source.getConnection();
        }catch (SQLException e){
            throw new RuntimeException("服务器忙。。。");
        }
    }

    /**
     * 关闭所有资源连接
     * @param conn
     * @param ps
     * @param rs
     */
    public static void releaseAll(Connection conn, Statement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


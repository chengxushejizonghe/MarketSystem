package test;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 林敬舒
 * @create 2021-06-02-22:40
 */
public class DBCPTest {
    @Test
    public void testGetConnection() throws Exception{
        Properties properties = new Properties();
        FileInputStream is = new FileInputStream("config/db.properties");
        properties.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(properties);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}

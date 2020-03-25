package oop.fun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Properties;

public class TestBlob {
    public static void main(String[] args) {
        TestBlob testBlob = new TestBlob();
        //testBlob.getBlob();
        testBlob.insertBlob();
    }
    public void getBlob() {//读取Blob数据
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCTools.getConnection();
            String sql = "SELECT BYTES_ FROM ACT_GE_BYTEARRAY WHERE ID_='08ff14e8-f190-11e9-8dc9-426e08113351'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Blob picture = rs.getBlob(1);//得到Blob对象
                //开始读入文件
                InputStream in = picture.getBinaryStream();
                OutputStream out = new FileOutputStream("1.xml");
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertBlob() {//插入Blob
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCTools.getConnection();
            String sql = "UPDATE ACT_GE_BYTEARRAY SET BYTES_=? WHERE ID_='79375295-fa35-11e9-a1f2-e6e5db727a27'";
            InputStream in = new FileInputStream("1.xml");//生成被插入文件的节点流
            ps = con.prepareStatement(sql);
            //设置Blob
            ps.setBlob(1, in);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(con, ps);
        }
    }

    static class JDBCTools {//JDBC工具类  用来建立连接和释放连接

        public static Connection getConnection() throws Exception {//连接数据库
            String driverClass = null;
            String url = null;
            String user = null;
            String password = null;
            driverClass = "com.mysql.cj.jdbc.Driver";
            url = "jdbc:mysql://192.168.1.254:3308/carloan?useLegacyDatetimeCode=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&autoReconnect=true&useSSL=true&nullNamePatternMatchesAll=true";
            user = "root";
            password = "";
            Class.forName(driverClass);
            return DriverManager.getConnection(url, user, password);
        }

        public static void release(Connection con, Statement state) {//关闭数据库连接
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        public static void release(ResultSet rs, Connection con, Statement state) {//关闭数据库连接
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Review {
    public Connection getConnection() throws Exception {//连接数据库
        String driverClass = null;
        String url = null;
        String user = null;
        String password = null;

        Properties properties = new Properties();

        InputStream in = Review.class.getClassLoader().getResourceAsStream("jdbc.properties");

        properties.load(in);

        driverClass = properties.getProperty("driver");
        url = properties.getProperty("jdbcurl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        Class.forName(driverClass);
        return DriverManager.getConnection(url, user, password);
    }

}
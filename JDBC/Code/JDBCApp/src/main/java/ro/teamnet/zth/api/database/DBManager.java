package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by Cristina.Constantin on 7/13/2017.
 */
public class DBManager {
    private static String CONNECTION_STRING= "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private DBManager() throws UnsupportedOperationException{

    }

    private static void registerDriver(){
        //Class.forName(DBProperties.DRIVER_CLASS);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    public static Connection getConnection() throws SQLException {
        registerDriver();

        String URL = CONNECTION_STRING;
        String USER = DBProperties.USER;
        String PASS = DBProperties.PASS;
        Connection conn = DriverManager.getConnection(URL, USER, PASS);

        return conn;
    }

    public static void checkConnection(Connection connection){
        String sql = "SELECT 1 FROM DUAL";
        try (Statement stm = connection.createStatement()){
            ResultSet rs = stm.executeQuery(sql);
            System.out.println(rs.getString(1));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package CheckProfile.GeneralData;

import java.sql.*;

import static CheckProfile.GeneralData.AllParameters.EndPoints.*;

public class SqlRequest {

    public static String getValueOfTable(String query) {
        Statement stmt;
        ResultSet rs;
        Connection con;
        String count = null;
        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getString(1);
            con.close();
            stmt.close();
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return count;
    }

}

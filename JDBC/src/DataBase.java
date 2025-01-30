import java.sql.*;

public class DataBase {

    void dbResult() throws Exception {
        String url = "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC";
        String uName = "root";
        String password = "M1S2@Sql";
//        String query = "SELECT name FROM users WHERE user_id = 7;";
        String query = "SELECT * FROM users;";


        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, uName, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

//        if (rs.next()) { // Prevent errors if no results are found
//            String name = rs.getString("name");
//            System.out.println(name);
//        } else {
//            System.out.println("No user found with ID 7.");
//        }

        String userData = "";

        while(rs.next()){
            userData = rs.getInt(1) + " : " + rs.getString(2)+ " : " + rs.getString(3)+ " : "+ rs.getString(4)+ " : "+ rs.getString(5);
            System.out.println(userData);
        }

        rs.close();
        st.close();
        con.close();
    }
}


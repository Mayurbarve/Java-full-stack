import java.sql.*;

public class InsertData {
    void insertValues() throws Exception {

        String url = "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC";
        String uName = "root";
        String password = "M1S2@Sql";

         /*
        Used When values Know

        String query = "INSERT INTO Users (name, email, password) VALUES ('Vaibhav', 'Vaibhav@example.com', 'hashed_password_5');";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, uName, password);
        Statement st = con.createStatement();
        */

        Connection con = DriverManager.getConnection(url, uName, password);

        String name = "Piyush";
        String email = "piyush@gmail.com";
        String pass = "GloryToHanuman";

        String query = "INSERT INTO Users (name, email, password) VALUES (?, ?, ?)"; // Specify column names

        PreparedStatement st = con.prepareStatement(query); // PreparedStatement

        st.setString(1, name);
        st.setString(2, email);
        st.setString(3, pass);

        int count = st.executeUpdate();  // No need to pass query again
        System.out.println(count + " Row/s affected");

        st.close();
        con.close();
    }
}

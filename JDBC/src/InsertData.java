import java.sql.*;

public class InsertData {
    void insertValues() throws Exception {

        String url = "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC";
        String uName = "root";
        String password = "M1S2@Sql";
        String query = "INSERT INTO Users (name, email, password) VALUES ('Vaibhav', 'Vaibhav@example.com', 'hashed_password_5');";

        // ✅ Use the correct driver class (or remove this line entirely)
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, uName, password);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);


        System.out.println(count + " Row/s affected");

        st.close();
        con.close();

    }
}

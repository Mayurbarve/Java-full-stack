package ProductData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/data";
    private static final String user= "root"; 
    private static final String password = "Yash@8803"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user,password);
    }

    public static void insertProduct(int productId, String name, String description, double costPrice, double sellingPrice) {
        String query = "INSERT INTO products (product_id, name, description, price, quantity) VALUES (?, ?, ?, ?, ?)";

        try {Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query) ;

            stmt.setInt(1, productId);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setDouble(4, costPrice);
            stmt.setDouble(5, sellingPrice);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Product added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
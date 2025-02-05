import java.sql.*;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/inventorymanagement?useSSL=false&serverTimezone=UTC";
    private static final String uName = "root";
    private static final String pass = "M1S2@Sql";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, uName, pass);
    }

    public static void insertProduct(int productId, String name, String description, double costPrice, double sellingPrice) {
        String query = "INSERT INTO products (product_id, name, description, cost_price, selling_price) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(query)) {

            st.setInt(1, productId);
            st.setString(2, name);
            st.setString(3, description);
            st.setDouble(4, costPrice);
            st.setDouble(5, sellingPrice);

            int rowAffected = st.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Product added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

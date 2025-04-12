import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCRUD {
    public boolean createUser(String name, String lastName, String email, String password) {
        String query = "INSERT INTO user (name, last_name, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            System.out.println("❌ Error inserting user: " + e.getMessage());
            return false;
        }
    }

    public void getUserById(int userId) {
        String query = "SELECT * FROM user WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("🧑‍💻 User found:");
                System.out.println("ID: " + rs.getInt("user_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("⚠️ User not found.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error fetching user: " + e.getMessage());
        }
    }

    public boolean updateUser(int userId, String name, String lastName, String email, String password) {
        String query = "UPDATE user SET name = ?, last_name = ?, email = ?, password = ? WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setInt(5, userId);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (Exception e) {
            System.out.println("❌ Error updating user: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUser(int userId) {
        String query = "DELETE FROM user WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (Exception e) {
            System.out.println("❌ Error deleting user: " + e.getMessage());
            return false;
        }
    }

    public void getAllUsers() {
        String query = "SELECT * FROM user";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n📄 List of users:");
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");

                System.out.println("🧑 ID: " + id + ", Name: " + name + " " + lastName + ", Email: " + email);
            }

        } catch (Exception e) {
            System.out.println("❌ Error fetching users: " + e.getMessage());
        }
    }
}

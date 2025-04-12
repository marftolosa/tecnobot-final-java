import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserCRUD userCRUD = new UserCRUD();
        boolean running = true;

        while (running) {
            System.out.println("\n📋 User CRUD Menu");
            System.out.println("1. Create user");
            System.out.println("2. Get user by ID");
            System.out.println("3. Update user");
            System.out.println("4. Delete user");
            System.out.println("5. List all users");
            System.out.println("6. Exit");
            System.out.print("👉 Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("📝 Name: ");
                    String name = scanner.nextLine();
                    System.out.print("📝 Last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("📧 Email: ");
                    String email = scanner.nextLine();
                    System.out.print("🔐 Password: ");
                    String password = scanner.nextLine();

                    boolean created = userCRUD.createUser(name, lastName, email, password);
                    System.out.println(created ? "✅ User created successfully!" : "❌ Failed to create user.");
                    break;

                case 2:
                    System.out.print("🔍 Enter user ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    userCRUD.getUserById(searchId);
                    break;

                case 3:
                    System.out.print("✏️ Enter user ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("📝 New name: ");
                    String newName = scanner.nextLine();
                    System.out.print("📝 New last name: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("📧 New email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("🔐 New password: ");
                    String newPassword = scanner.nextLine();

                    boolean updated = userCRUD.updateUser(updateId, newName, newLastName, newEmail, newPassword);
                    System.out.println(updated ? "✅ User updated successfully!" : "❌ Failed to update user.");
                    break;

                case 4:
                    System.out.print("🗑️ Enter user ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    boolean deleted = userCRUD.deleteUser(deleteId);
                    System.out.println(deleted ? "✅ User deleted successfully!" : "❌ Failed to delete user.");
                    break;

                case 5:
                    System.out.println("6. List all users");
                    userCRUD.getAllUsers();
                    break;

                case 6:
                    running = false;
                    System.out.println("👋 Exiting program.");
                    break;

                default:
                    System.out.println("⚠️ Invalid option, please try again.");
            }
        }
        scanner.close();
    }
}

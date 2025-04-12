public class User {

    //attributes
    private int user_id;
    private String name;
    private String last_name;
    private String email;
    private String password;

    //Construct without parameters
    public User() {

    }

    // Construct with parameters
    public User(int user_id, String name, String last_name, String email, String password) {
        this.user_id = user_id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }


    //Setters
    public void SetUserID(int user_id) {
        this.user_id = user_id;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public void SetLastName(String last_name) {
        this.last_name = last_name;
    }

    public void SetEmail(String email) {
        this.email = email;
    }

    public void SetPassword(String password) {
        this.password = password;
    }


    //Getters
    public int GetUserID() {
        return user_id;
    }

    public String GetName() {
        return name;
    }

    public String GetLastName() {
        return last_name;
    }

    public String GetEmail() {
        return email;
    }

    public String GetPassword() {
        return password;
    }

    // methods
    public void mostrarDatos() {
        System.out.println("The UserID is: "+GetUserID() );
        System.out.println("The Name is: "+GetName() );
        System.out.println("The LastName is: "+GetLastName() );
        System.out.println("The Email is: "+GetEmail() );
        System.out.println("The Password is: "+GetPassword() );
    }
}

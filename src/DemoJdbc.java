import java.sql.Connection;
import java.sql.DriverManager;

public class DemoJdbc {
    public static void main(String[] args) {
        /*
            MAIN STEPS FOR JDBC:
            import package
            load and register
            create connection
            create statement
            execute statement
            process the result
            close the connection
         */
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Itsme@june2025";

        try {
            //load and register, this is an optional step
            Class.forName("org.postgresql.Driver");
            //create connection
            Connection con = DriverManager.getConnection(url,uname,pass);
            System.out.println("Connection Established: " + con);

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

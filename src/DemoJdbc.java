import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
        String query = "select sname from students where sid = 100";

        try {
            //load and register, this is an optional step
            Class.forName("org.postgresql.Driver");
            //create connection
            Connection con = DriverManager.getConnection(url,uname,pass);
            System.out.println("Connection Established: " + con);
            //create statement
            Statement st = con.createStatement();
            //execute statement - to fetch use executeQuery method from statement object
            ResultSet results = st.executeQuery(query);
            //by default the pointer will point to before the first row, we need to do next to point it to first row
            results.next();
            String name = results.getString("sname");
            System.out.println("Name of the student: " + name);

            //close the connection
            con.close();
            System.out.println("Connection Closed");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

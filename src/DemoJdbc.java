import java.sql.*;

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
        String query_new = "select * from students";
        String insert_query = "insert into students values (500, 66, 'Rama')";
        String update_query = "update students set sname = 'Rama' where sid = 500";
        String delete_query = "delete from students where sid = 500";

        int sid = 500;
        int marks = 45;
        String sname = "Rama";

        //it becomes very tedious to concat strings by using variables in them
        //this may also lead to SQL injection
        String new_insert = "insert into students values (" + sid + "," + marks + ",'" + sname + "')";

        String proper_insert_for_prepared_st = "insert into students values (?,?,?)";

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
            System.out.println();

            //to fetch all results
            ResultSet new_results = st.executeQuery(query_new);

            //use a while over results to check if it has next
            while(new_results.next()) {
                System.out.print(new_results.getInt(1) + " - ");
                System.out.print(new_results.getInt(2) + " - ");
                System.out.print(new_results.getString(3));
                System.out.println();
            }

            //in order to run an insert,update,delete statements use execute, it returns a boolean
//            st.execute(insert_query);

            //update query
//            st.execute(update_query);

            //delete query
//            st.execute(delete_query);

            //Prepared statement extends Statement interface
//            PreparedStatement pst = con.prepareStatement(proper_insert_for_prepared_st);
//            pst.setInt(1, sid);
//            pst.setInt(2, marks);
//            pst.setString(3, sname);
//
//            pst.execute();


            //close the connection
            con.close();
            System.out.println("Connection Closed");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

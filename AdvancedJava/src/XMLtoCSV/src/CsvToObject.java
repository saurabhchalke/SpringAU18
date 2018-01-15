import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CsvToObject {

    public static void main(String[] args) throws SQLException {

        String csvFile = "src/output.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost/test";
        try {
			Class.forName(myDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection conn = DriverManager.getConnection(myUrl, "root", "");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] student = line.split(cvsSplitBy);

                System.out.println(student[0] + " " + student[1]);
                
                Statement st = conn.createStatement();

                st.executeUpdate("INSERT INTO student "
                    +"VALUES ('" + student[0] + "', '" + student[1] + "');");

            }
            
            conn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }

    }

}
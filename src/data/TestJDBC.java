package data;


import java.sql.*;
import logic.*;

public class TestJDBC implements Constante{




    public static void main(String[] args) throws SQLException  {


        Connection conn = DriverManager.getConnection(dbURL, benutzer, passwort);
        System.out.println(conn);

        //Hülle für SQL-Statemen aufbauen
        Statement stmt = conn.createStatement();
        System.out.println(stmt);

        String sql = "SELECT * FROM person";//
        ResultSet rs = stmt.executeQuery(sql);//executeQuery schickt eine Anfrage an die Datenbank


        System.out.println(rs);
               while(rs.next()) {

            int personID = rs.getInt("personID");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            Timestamp stempel = rs.getTimestamp("stempel");




            Person person = new Person( firstName, lastName, new Timestamp(System.currentTimeMillis()));

            System.out.println("Aus der Datenbank: " + person);


            System.out.println("Person ID: "+
                    personID + " FirstName "+
                    firstName + " LastName "+
                    lastName + "."+
                    stempel+ "stempel");

        }

    }
}

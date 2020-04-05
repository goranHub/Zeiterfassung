package data;


import java.sql.*;

public class ReadAllFromDB  implements Constante{


    public static void main()throws SQLException {


        Connection conn;
        Statement stmt;


        //Hülle für SQL-Statemen aufbauen

            conn = DriverManager.getConnection(dbURL, benutzer, passwort);
            System.out.println(conn);
            stmt = conn.createStatement();
            System.out.println(stmt);
            String sql = "SELECT * FROM person";//
            ResultSet rs = stmt.executeQuery(sql);//executeQuery schickt eine Anfrage an die Datenbank

            System.out.println(rs);
            while (rs.next()) {

                int personID = rs.getInt("personid");
                String firstName = rs.getString("first");
                String lastName = rs.getString("last");
                Timestamp stempel = rs.getTimestamp("time");

                System.out.println("Person ID: " +
                        personID + " FirstName " +
                        firstName + " LastName " +
                        lastName + "." +
                        stempel + "stempel");
            }




    }
}

package data;

import logic.Person;

import java.sql.*;
import java.util.List;

public class WriteIntoDB implements Constante {


    public static void writeIntoDB(Person person) throws SQLException {




        //String sql = "INSERT INTO person(personid,first,last,time) VALUES ('"+person.getId()+"','"+person.getFristName()+"','"+person.getLastName()+"','"+person.getTimestamp()+"')";


        String sql = "INSERT INTO person(personid,first,last,time) VALUES(?,?,?,?)";
        Connection conn = DriverManager.getConnection(dbURL, benutzer, passwort);
        System.out.println(conn);

        Statement stmt = conn.createStatement();


        PreparedStatement pstmt = conn.prepareStatement(sql);


        //pstmt.setInt(1,  person.getId());
        pstmt.setInt(1, person.getId());
        pstmt.setString(2, person.getFristName());

        pstmt.setString(3, person.getLastName());
        pstmt.setTimestamp(4, person.getTimestamp());

        pstmt.execute();// Schickt den sql-String umgewandelt an die Datenbank


    }

}

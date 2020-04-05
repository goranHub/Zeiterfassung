package data;


import logic.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAllFromDB implements Constante {


    static String firstName;
    static String lastName;

    public static List<Person> main() throws SQLException {


        Connection conn;
        Statement stmt;


        //Hülle für SQL-Statemen aufbauen

        conn = DriverManager.getConnection(dbURL, benutzer, passwort);

        stmt = conn.createStatement();

        String sql = "SELECT * FROM person";//
        ResultSet rs = stmt.executeQuery(sql);//executeQuery schickt eine Anfrage an die Datenbank


        List<Person> peopleList = new ArrayList<>();


        while (rs.next()) {

            int personID = rs.getInt("personid");
            firstName = rs.getString("first");
            lastName = rs.getString("last");
            Timestamp stempel = rs.getTimestamp("time");

            peopleList.add(new Person(firstName, lastName, stempel));

        }

        return peopleList;
    }

}

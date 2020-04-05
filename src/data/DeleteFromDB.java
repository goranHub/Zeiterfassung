package data;

import java.sql.*;

import static data.Constante.*;

public class DeleteFromDB {

    public static void main() throws SQLException {


        Connection conn;
        Statement stmt;


        conn = DriverManager.getConnection(dbURL, benutzer, passwort);

        stmt = conn.createStatement();

        String sql = "DELETE FROM person";
        int rs = stmt.executeUpdate(sql);

            conn.close();
        }


    }




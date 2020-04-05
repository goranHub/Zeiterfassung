package data;

import java.sql.*;

import static data.Constante.*;

public class DeleteFromDB {

    public static void main() throws SQLException {


        Connection conn;
        Statement stmt;


        conn = DriverManager.getConnection(dbURL, benutzer, passwort);
        System.out.println(conn);
        stmt = conn.createStatement();
        System.out.println(stmt);
        String sql = "DELETE FROM person";
        int rs = stmt.executeUpdate(sql);

        System.out.println(rs);

            conn.close();
        }


    }




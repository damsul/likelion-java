package com.example.javaproject2.week7.day30;

import com.example.javaproject2.week7.day30.model.BaseDAO;
import java.sql.SQLException;

public class DBMain extends BaseDAO {
    public static void main(String[] args) {
        DBMain dbMain = new DBMain();
        dbMain.initPerson();
    }

    private void initPerson() {
        try {
            // create a database connection
            getConn();
            smt = conn.createStatement();
            smt.setQueryTimeout(30);  // set timeout to 30 sec.

            smt.executeUpdate("drop table if exists person");
            smt.executeUpdate("create table person (id integer, name string)");
            smt.executeUpdate("insert into person values(1, 'leo')");
            smt.executeUpdate("insert into person values(2, 'yui')");
            rs = smt.executeQuery("select * from person");
            while(rs.next()) {
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void getCodeName() {
        String sql = "select code, name from country order by code, name";

        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while( rs.next() ) {
                System.out.print(rs.getString("code") + "\t");
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}

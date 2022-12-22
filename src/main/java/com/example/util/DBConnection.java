/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jerry
 */

//DBConnection 类：在创建该类对象的时候，就做出了一个conn。可以利用该对象，得到conn。
public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/myemploy?serverTimezone=Asia/Shanghai&characterEncoding=UTF8";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private Connection conn = null;

    public DBConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    public Connection getConnection(){
        return conn;
    }
    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

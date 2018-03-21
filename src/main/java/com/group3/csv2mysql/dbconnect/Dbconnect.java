package com.group3.csv2mysql.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

// dbconnect class by eldert, creates sql database connection with remote sql
public final class Dbconnect{
    
    private String url;
    private String username;
    private String password;
    private Connection con;

    public Dbconnect() throws SQLException{
        this.username = "eldert";
        this.password = "supersecret";
        this.url = "jdbc:mysql://codecrisp.com/bigmovie";
        
        // setup connection when loaded
        this.con = getConnection();
    }

    // create's connection, returns Connection con, null when failed.
    private Connection getConnection() throws SQLException{

        // Create Connection con
        try
        {
            // Estamblish connection
            con = DriverManager.getConnection (url,username,password);
        }
        catch (SQLException e)
		{
			// Catch SQLExeption
            System.out.println("SQL Exeption");
            con = null;
        }
        // return con, null if connection refused
        return con;
    }

    // inserts csv file with input query
    public Boolean insertCSV(String q) throws SQLException{
        
        // create statement
        Statement s = con.createStatement();
        
        // Set auto incresment value, DB will accept indentifier as zero
        s.execute("SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO'");
            
        // Execute LOAD Data query
        return s.execute(q);
    }

    // close db connection
    public void close() throws SQLException{
        con.close();
    }
}


package com.group3.csv2mysql;

import java.sql.SQLException;

import com.group3.csv2mysql.dbconnect.Dbconnect;

// toMySql class by eldert
public class toMysql
{
	private Dbconnect con;

	public toMysql() throws SQLException{
		// setup db connection by package dbconnect
		this.con = new Dbconnect();
		System.out.println("db connected..........");
	}

	// Read csv (String path + file), create connection with db, puts csv data into table (String table), catches exeptions, returns true/false
	public Boolean csvToSql(String path, String file, String table) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		System.out.println("Starting csvToSQL..........");
		return con.insertCSV("LOAD DATA LOCAL INFILE '" + path + file + "' IGNORE INTO TABLE "+ table +" FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\r\n' IGNORE 1 LINES");
	}
	
	// close db connection
	public void close() throws SQLException{
		System.out.println("Closing connection");
        con.close();
    }
}
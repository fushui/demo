package com.fushui.jdbc_demo.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fushui.jdbc_demo.dao.Dao;
import com.fushui.jdbc_demo.model.Goddess;

public class DBUtils {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection conn = null;
	static {

		try {
			// 1,加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
            // 2.获得数据库的连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static Connection getConn() {
		return conn;
	}




}

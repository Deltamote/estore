package com.briup.estore.util;

import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.estore.util.ConnectionFactory;
import com.sun.org.glassfish.external.statistics.Statistic;

import jdk.internal.dynalink.beans.StaticClass;

public class ExecTest {
 
	public static void execStat(String sql){
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			ConnectionFactory.closeResource(connection, statement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void resultStat(String sql,IProcessResult ps){
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			ps.process(resultSet);
			ConnectionFactory.closeResource(connection, statement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void execPre(String sql,ISetPrepare sp){
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			sp.setValue(prepareStatement);
			prepareStatement.execute();
			ConnectionFactory.closeResource(connection, prepareStatement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void resultPrepare(String sql,ISetPrepare sp,IProcessResult ps){
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement prepareStatement=connection.prepareStatement(sql);
			sp.setValue(prepareStatement);
			ResultSet resultSet= prepareStatement.executeQuery();
		    ps.process(resultSet);
		    ConnectionFactory.closeResource(connection, prepareStatement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

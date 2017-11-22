package com.briup.estore.service.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.estore.dao.BaseDao;
import com.briup.estore.util.ConnectionFactory;

public class BaseDaoImpl implements BaseDao {

	
	public int getCustomerId() {
		
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select cus_seq.nextval from dual");
			resultSet.next();
			int num = resultSet.getInt("nextval");
			return num;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	public int getOrderId() {
		
			Connection connection = ConnectionFactory.getConnection();
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select order_seq.nextval from dual");
				resultSet.next();
				int num = resultSet.getInt("nextval");
				return num;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
	}
		public int getLineId() {
			// TODO Auto-generated method stub
			Connection connection = ConnectionFactory.getConnection();
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select line_seq.nextval from dual");
				resultSet.next();
				int num = resultSet.getInt("nextval");
				return num;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}
		 public static void main(String[] args){
			 BaseDaoImpl dao=new BaseDaoImpl();
			 int customerId = dao.getCustomerId();
			 System.out.println(customerId);
		 }

}

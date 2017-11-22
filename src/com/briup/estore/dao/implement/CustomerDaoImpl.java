package com.briup.estore.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerDao;
import com.briup.estore.service.implement.BaseDaoImpl;
import com.briup.estore.util.ConnectionFactory;
import com.briup.estore.util.ExecTest;
import com.briup.estore.util.ISetPrepare;


public class CustomerDaoImpl implements CustomerDao {
	BaseDaoImpl baseDaoImpl=new BaseDaoImpl();
	
	
		public void insertTest(Customer customer) {
			ExecTest.execPre("insert into tbl_customer values(?,?,?,?,?,?,?)", new ISetPrepare() {
				
				@Override
				public void setValue(PreparedStatement preparedStatement){
					try {
						preparedStatement.setLong(1,baseDaoImpl.getCustomerId());
						preparedStatement.setString(2, customer.getName());
						preparedStatement.setString(3, customer.getPassword());
						preparedStatement.setString(4, customer.getZip());
						preparedStatement.setString(5, customer.getAddress());
						preparedStatement.setString(6, customer.getTelephone());
						preparedStatement.setString(7, customer.getEmail());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}	});
				}
	@Override
	/*public Customer findByName(String name) {
		Customer customer=new Customer();
		ExecTest.resultPrepare("select * from tbl_customer "
				+ "where name=? and password=?",new ISetPrepare() {
			@Override
			public void setValue(PreparedStatement preparedStatement) {
				// TODO Auto-generated method stub
				try {
					preparedStatement.setString(2,customer.getName());
					preparedStatement.setString(3,customer.getPassword());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},
				new IProcessResult() {
					
					@Override
					public void process(ResultSet resultSet) {
					try {
						if(resultSet.next()==true){
							Long id = resultSet.getLong("id");
							String name = resultSet.getString("name");
							String password = resultSet.getString("password");
							String zip = resultSet.getString("zip");
							String email = resultSet.getString("email");
							String telephone = resultSet.getString("telephone");
							String address = resultSet.getString("address");
							customer.setAddress(address);
							customer.setEmail(email);
							customer.setId(id);
							customer.setName(name);
							customer.setPassword(password);
							customer.setTelephone(telephone);
							customer.setZip(zip);
							
	
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
					}
				});
		return customer;
		}*/
	public Customer findByName(String name) {
		Connection connection=ConnectionFactory.getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from tbl_customer where name=?");
			prepareStatement.setString(1,name);
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()){
				Customer customer=new Customer();
				customer.setId(resultSet.getLong("id"));
				customer.setName(resultSet.getString("name"));
				customer.setPassword(resultSet.getString("password"));
				customer.setAddress(resultSet.getString("address"));
				customer.setEmail(resultSet.getString("email"));
				customer.setTelephone(resultSet.getString("telephone"));
				customer.setZip(resultSet.getString("zip"));
				return customer;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

ExecTest.execPre("insert into tbl_customer(id,name,password,zip,address,telephone,email) values(?,?,?,?,?,?,?)", new ISetPrepare() {
			
			@Override
			public void setValue(PreparedStatement preparedStatement) {
				// TODO Auto-generated method stub
				try {
					preparedStatement.setLong(1, customer.getId());
					preparedStatement.setString(2, customer.getName());
					preparedStatement.setString(3, customer.getPassword());
					preparedStatement.setString(4, customer.getZip());
					preparedStatement.setString(5, customer.getAddress());
					preparedStatement.setString(6, customer.getTelephone());
					preparedStatement.setString(7, customer.getEmail());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}

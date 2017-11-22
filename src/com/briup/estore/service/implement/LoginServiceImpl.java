package com.briup.estore.service.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.dao.BaseDao;
import com.briup.estore.dao.implement.CustomerDaoImpl;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.util.ConnectionFactory;

public class LoginServiceImpl implements ICustomerService {

	@Override
	public  void register(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public Customer  login(String name, String password) throws CustomerException {
		// TODO Auto-generated method stub
	 CustomerDaoImpl dao=new CustomerDaoImpl();
	 BaseDao baseDao=new BaseDaoImpl();
		
		Customer customer = dao.findByName(name);
		return customer;
		
//			/*
//			 * 防止SQL注入用prepareStatement
//			 */
//			 Connection connection = ConnectionFactory.getConnection();
//			
//			try {
//				PreparedStatement prepareStatement = connection.prepareStatement("select * from tbl_customer "
//						+ "where name=? and password=?");
//				prepareStatement.setString(1, "zhangsan");
//				prepareStatement.setString(2,"111111");//防止SQL注入（2的位置 为密码，即密码为10 或者1）
//				ResultSet resultSet = prepareStatement.executeQuery();
//				if(resultSet.next()==true){
//					System.out.println("登录成功！");	
//				}else{
//					System.out.println("登录失败！");
//					
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	return true;
	}
	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		
	}

}

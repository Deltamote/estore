package com.briup.estore.service.implement;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.dao.BaseDao;
import com.briup.estore.dao.implement.CustomerDaoImpl;
import com.briup.estore.service.ICustomerService;

public class RegisterServiceImpl implements ICustomerService{
	private BaseDaoImpl baseDao=new BaseDaoImpl();
	private CustomerDaoImpl dao= new CustomerDaoImpl();
	@Override
	public void register(Customer customer) throws CustomerException {
		Customer customer2 = dao.findByName(customer.getName());
		if(customer2!=null){
			throw new CustomerException("用户已存在");

		}
		int customerId = baseDao.getCustomerId();
		customer.setId((long)customerId);
		dao.saveCustomer(customer);
		}


	
	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer login(String name, String password) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}

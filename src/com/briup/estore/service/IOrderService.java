package com.briup.estore.service;

import java.util.Collection;
import java.util.List;



import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;

public interface IOrderService {
	void confirmOrder(Customer customer,Order order,Collection<Line> lines) throws OrderException;
	void deleteOrder(Long id) throws OrderException;
	Order findById(Long orderid) throws OrderException;
	List<Order> listAllOrder(long id) throws OrderException;
}

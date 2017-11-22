package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Order;

public interface OrderDao{
	public void saveOrder(Order order);
	public Order findOrderById(Long id);
	public void deleteOrder(Order order);
	public List<Order> findAllOrder(Long id);
}

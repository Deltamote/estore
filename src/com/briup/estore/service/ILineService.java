package com.briup.estore.service;

import java.util.Collection;
import java.util.List;



import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.common.exception.LineException;

public interface ILineService {
	public List<Line> findLineByCustomerId(Long id);
	public List<Line> findLineByOrderId(Long id);
}

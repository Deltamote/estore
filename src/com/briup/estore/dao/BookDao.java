package com.briup.estore.dao;

import java.util.ArrayList;
import java.util.List;
import com.briup.estore.bean.Book;

public interface BookDao {
	public List<Book> queryAll();
	//拿数据库的信息
	public Book queryById(Long id);
}

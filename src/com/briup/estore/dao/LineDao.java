package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Line;

public interface LineDao{
	public void saveLine(Line line);
	public List<Line> findLineByOrderId(long id);
	public void delLine(Line line);
	public void updateLine(Line line);
}

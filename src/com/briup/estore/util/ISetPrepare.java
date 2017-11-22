package com.briup.estore.util;

import java.sql.PreparedStatement;

//给SQL语句中的占位符进行赋值
public interface ISetPrepare {

	public void setValue(PreparedStatement preparedStatement);
}

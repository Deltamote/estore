package com.briup.estore.util;

import java.sql.ResultSet;
//处理结果集
public interface IProcessResult {
  public void process(ResultSet resultSet);
}

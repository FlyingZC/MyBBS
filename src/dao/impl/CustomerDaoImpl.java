package dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import util.DBUtil;
import dao.CustomerDao;
import entity.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
	public Customer login(String name, String password) {
		try {
			Customer c = runner.query("select id,name,password from customer where name=?"
					,new BeanHandler<Customer>(Customer.class),name);
			System.out.println(c);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("CustomerDaoImpl类中login失败");
		}
	}
	public void saveCustomer(Customer c) {
		try {
			runner.update("insert into customer(id,name,icon,password,sex) values(seq_user.nextVal,?,?,?,?)"
					,c.getName(),c.getIcon(),c.getPassword(),c.getSex());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

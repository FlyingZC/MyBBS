package dao;

import entity.Customer;

public interface CustomerDao {

	Customer login(String name, String password);

	void saveCustomer(Customer c);


}

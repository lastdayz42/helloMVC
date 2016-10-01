package Service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	private static final CustomerService instance = new CustomerService();

	private Map<String, Customer> customers;


	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	public static CustomerService getInstance() {
		return instance;
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	public boolean checkCustomer(Customer customer) {
		if( customer.getId().isEmpty()||customer.getPassword().isEmpty())
			return false;
		else
			return true;
		
	}

	public Customer findCustomer(String id) {
		if (id != null)
			return customers.get(id.toLowerCase());
		else
			return null;
	}

	public Customer login(String id, String password) {
		Customer registedCustomer = findCustomer(id);

		if (registedCustomer != null && registedCustomer.getPassword().equals(password))
			return registedCustomer;
		else
			return null;
	}

}

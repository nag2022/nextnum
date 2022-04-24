package numberseries.findnextnumberinseries.service;

import java.util.List;

import numberseries.findnextnumberinseries.entity.Customer;
import numberseries.findnextnumberinseries.entity.nextnumDetails;

import java.util.List;

public interface CustomerService {
	
	public List<Customer> getCustomers ();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public nextnumDetails nextNumInSeries(int a, int b, int c, int d, int e, int f,int g) throws InterruptedException;

}

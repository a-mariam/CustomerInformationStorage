package Service.userService;

import data.Model.Customer;
import dto.CreateCustomerRequest;

import java.util.ArrayList;

public interface UserService {
    ArrayList<Customer> saveCustomer(CreateCustomerRequest CreateCustomerRequest, ArrayList<Customer> list);
    ArrayList<Customer> getCustomer(String firstName);
   // ArrayList<Customer> getCustomersInformation();

}

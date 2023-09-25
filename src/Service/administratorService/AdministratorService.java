package Service.administratorService;

import data.Model.Customer;
import data.Model.User;
import dto.CreateCustomerRequest;
import dto.RegisterUser;

import java.util.ArrayList;

public interface AdministratorService {
    String addUser(User user);
    User registerUser(RegisterUser registerUser);
    byte [] encryptUserCustomerInformation(String information);
    Customer createNewUserCustomer(CreateCustomerRequest request);
    ArrayList<Customer> saveUserCustomer(CreateCustomerRequest request, ArrayList<Customer> userCustomerList);
    String getCustomersByFirstName(String firstName);


}

package Test;

import Service.userService.MariamUserService;
import data.Model.Address;
import data.Model.User;
import dto.CreateCustomerRequest;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MariamUserServiceTest {
    private MariamUserService service = new MariamUserService();
    private User user = new User();
    @Test
    public void test_Encrypt_Password(){
        String password = "mypassword";
        System.out.println(password.getBytes());
        byte [] encryptedPassword = password.getBytes(StandardCharsets.UTF_8);
        MariamUserService userService = new MariamUserService();
        String getActualPassword = new String(encryptedPassword, StandardCharsets.UTF_8);
        //assertEquals(getActualPassword,userService.encryptPassword(password));
        System.out.println("DECRYPTED :: " + getActualPassword);
        //System.out.println("ENCRYPTED:: " + userService.encryptPassword(password));
        assertEquals(getActualPassword, password);
        //assertEquals(encryptedPassword,userService.encryptPassword(password));
    }
    @Test
    public void testThat_save_Customer_Works(){
        CreateCustomerRequest request = new CreateCustomerRequest();
        Address address = new Address();
        address.setCity("ebutte metta");
        address.setCountry("Nigeria");
        address.setStreet("8 moss street");
       // request.setAddress(address);
        request.setEmail("mariam@gmail.com");
        request.setFirstName("firstname");
        request.setLastName("lastname");
        request.setPassword("password");
        service.saveCustomer(request, user.getCustomers());
        System.out.println(service.saveCustomer(request,user.getCustomers()));
    }
    @Test
    public void testThat_save_Customer_Work(){
        CreateCustomerRequest request = new CreateCustomerRequest();
        Address address = new Address();
        address.setCity("ebutte metta");
        address.setCountry("Nigeria");
        address.setStreet("8 moss street");
        request.setAddress("address");
        request.setEmail("mariam@gmail.com");
        request.setFirstName("firstname");
        request.setLastName("lastname");
        request.setPassword("password");
        CreateCustomerRequest requests = new CreateCustomerRequest();
        Address addresss = new Address();
        addresss.setCity("ebutte metta");
        addresss.setCountry("Nigeria");
        addresss.setStreet("8 moss street");
       requests.setAddress("address");
        requests.setEmail("mariam@gmail.com");
        requests.setFirstName("firstname");
        requests.setLastName("lastname");
        requests.setPassword("password");
        service.saveCustomer(requests, user.getCustomers());
        service.saveCustomer(request, user.getCustomers());
    }
    @Test
    public void  test_getCustomerInformation(){
        System.out.println(service.getCustomer("firstName"));

    }
    @Test
    public void testThat_ReadDataWorks(){
        System.out.println(service.readCustomerData());
    }
    @Test
    public void testThat_ReadDat(){
        service.getCustomer("firstname");
    }

}
package Service.userService;

import Service.administratorService.AdministratorService;
import Service.administratorService.MariamAdministratorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Model.Customer;
import data.Model.User;
import dto.CreateCustomerRequest;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MariamUserService implements UserService {
    private MariamUserService adminService = new MariamUserService();
    private  User user = new User();

    public MariamUserService() {
    }

    @Override
    public ArrayList<Customer> saveCustomer(CreateCustomerRequest createCustomerRequest, ArrayList<Customer> list) {
        ArrayList<Customer> customer =  adminService.saveCustomer(createCustomerRequest, user.getCustomers());
        return customer;
    }




    @Override
    public ArrayList<Customer> getCustomer(String firstName) {
        ArrayList<String[]> list = new ArrayList<>();

      String allCustomers = readCustomerData();
      String [] tokens = allCustomers.split("}, ");
      String searchPattern = "\"firstName\":" + firstName;
      for (int count = 0; count < tokens.length; count++){
          if (tokens[count].contains(searchPattern)){
              list.add(tokens);
              System.out.println(list);
          }
      String up = String.join("}, ", tokens);
          System.out.println(up);
          System.out.println("List  "+list);
      }

        return null;
    }
    public String readCustomerData(){
        String location = "C:\\Users\\mariam\\IdeaProjects\\CustomerInformationStorage\\src\\data\\repository\\CustomerStorage.json";
        Path path = Path.of(location);
        try(BufferedReader reader = Files.newBufferedReader(path)){
            Stream<String> content = reader.lines();
            return content.collect(Collectors.joining());
        }catch (IOException ex){
            return  (ex.getMessage());
        }
    }
}


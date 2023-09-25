package Service.administratorService;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Model.Customer;
import data.Model.User;
import dto.CreateCustomerRequest;
import dto.RegisterUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MariamAdministratorService implements AdministratorService{
    private char [] generateId(){
        int length =  7;
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghiijklmnopqrstuvwxyz";
        String characters = "!@$&_?+=";
        String combined = upper + lower + characters;
        Random random = new Random();
        char [] id = new char[length];
        for (int count = 0; count < 7; count++){
            id[count] = combined.charAt(random.nextInt(combined.length()));
        }
        return id;
    }
    @Override
    public String addUser(User user) {
        return null;
    }

    @Override
    public User registerUser(RegisterUser registerUser) {
        return null;
    }

    @Override
    public byte[] encryptUserCustomerInformation(String information) {
        byte [] encryptedPassword = information.getBytes(StandardCharsets.UTF_8);
        return encryptedPassword;

    }

    @Override
    public Customer createNewUserCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(encryptUserCustomerInformation(request.getFirstName()));
        customer.setLastName(encryptUserCustomerInformation(request.getLastName()));
        customer.setEmail(encryptUserCustomerInformation(request.getEmail()));
        customer.setAddress(encryptUserCustomerInformation(request.getAddress()));
        customer.setPassword(encryptUserCustomerInformation(request.getPassword()));
        customer.setId(generateId());
        return customer;
    }

    @Override
    public ArrayList<Customer> saveUserCustomer(CreateCustomerRequest request, ArrayList<Customer> userCustomerList) {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = createNewUserCustomer(request);
        userCustomerList.add(customer);
        String location = "C:\\Users\\mariam\\IdeaProjects\\CustomerInformationStorage\\src\\data\\repository\\CustomerStorage.json";
        Path path = Path.of(location);
        try(OutputStream outputStream = Files.newOutputStream(path);
        PrintStream printStream = new PrintStream(outputStream)){
            System.setOut(printStream);
            mapper.writeValue(System.out, userCustomerList);
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        return userCustomerList;
    }
    public String readData(){
     String location = "C:\\Users\\mariam\\IdeaProjects\\CustomerInformationStorage\\src\\data\\repository\\CustomerStorage.json";
     Path path = Path.of(location);
     try(BufferedReader reader = Files.newBufferedReader(path)){
         Stream<String> content = reader.lines();
         return content.collect(Collectors.joining());
     }catch (IOException ex){
         return ex.getMessage();
     }
    }
//    @Override
//    public ArrayList<String[]> getCustomersByFirstName(String firstName) {
//        ArrayList<String []> customers = new ArrayList<>();
//        String allCustomer = readData();
//        String [] token = allCustomer.split("}, ");
//        String searchPattern = "\"firstName\":" + firstName;
//
//        for (int count = 0; count < token.length; count++){
//            if (token[count].contains(searchPattern) ){
//                customers.add(token);
//            }
//        }
//        String up = String.join("}, ", token);
//        return null;
//    }
    @Override
    public String getCustomersByFirstName(String firstName) {
        ArrayList<String> customers = new ArrayList<>();
        String allCustomer = readData();
        String [] token = allCustomer.split("}, ");
        String searchPattern = "\"firstName\":" + firstName;

        for (int count = 0; count < token.length; count++){
                customers.add(token[count]);
            }
        String up = String.join("}, ", token);

        return up;
    }


}

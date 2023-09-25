package Service.AdminGeneratorService;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.AdminInfo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class MariamAdminGenerator implements AdminInfoGenerator {

    @Override
    public AdminInfo addNewAdmin() {
        return null;
    }

    public AdminInfo generateNewAdminInfo() {
    int length = 6;
    char [] password = generatePassword(length);
    String adminName = "Admin" ;

        AdminInfo adminInfo = new AdminInfo(adminName, password);
        return adminInfo;
    }

    public char[] generatePassword(int length) {
      String lowerCaseLetter = "abcdefghijklmnopqrstuvwxyz";
      String upperCaseLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String number = "1234567890";
      String symbol = "!@#$%*";
      String combined = lowerCaseLetter + upperCaseLetter + number + symbol ;
      char [] password = new char[length];
      Random random = new Random();

      password[0] = lowerCaseLetter.charAt(random.nextInt(lowerCaseLetter.length()));
      password[1] = upperCaseLetter.charAt(random.nextInt(upperCaseLetter.length()));
      password[2] = symbol.charAt(random.nextInt(symbol.length()));
      password[3] = number.charAt(random.nextInt(number.length()));
        System.out.println(password);
        for (int count = 4; count < length;count++ ){
            password[count] = combined.charAt(random.nextInt(combined.length()));
        }
        return password;

    }
    public ArrayList<AdminInfo> collectAllGeneratedAdmin(){
        int counts = 5;
        ArrayList<AdminInfo> AdminInfos = new ArrayList<>();
        for (int count = 0; count < counts; count++){
          AdminInfo adminInfo =  generateNewAdminInfo();
          AdminInfos.add(adminInfo);
        }
        return AdminInfos;
    }


    @Override
    public void saveAdminInfo() {
      ArrayList<AdminInfo> collect =  collectAllGeneratedAdmin();
       ObjectMapper writer = new ObjectMapper();
       String location = "C:\\Users\\mariam\\IdeaProjects\\CustomerInformationStorage\\src\\data\\repository\\UncheckedAdmin.json";
        Path path = Path.of(location);
        try(OutputStream stream = Files.newOutputStream(path);
        PrintStream printStream = new PrintStream(stream)){
            System.setOut(printStream);
            writer.writeValue(System.out, collect);
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }

    }





}


package Test;

import Service.AdminGeneratorService.MariamAdminGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MariamAdminGeneratorTest {
@Test
    public void test_Password_Generator(){
    int length = 7;
    MariamAdminGenerator generator = new MariamAdminGenerator();
    char []  a = generator.generatePassword(length);
    System.out.println(Arrays.toString(a));
    //int Number;
    assertTrue(generator.generatePassword(length).length == 7);
}
@Test
    public void test_SaveAdmin_Info(){
    MariamAdminGenerator generator = new MariamAdminGenerator();
    generator.saveAdminInfo();
}
}
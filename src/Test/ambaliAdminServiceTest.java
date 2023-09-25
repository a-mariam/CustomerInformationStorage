package Test;

import data.Model.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ambaliAdminServiceTest {
   @Test
    public void testAdmin_IsNot_Null(){
       char [] a = {'1','1','2','0','0','5'};
       Admin admin = new Admin("mariam",a);
       assertNotNull(admin);
}

}
package Service.AdminGeneratorService;

import dto.AdminInfo;

import java.util.List;

public interface AdminInfoGenerator {
     AdminInfo addNewAdmin();

     AdminInfo generateNewAdminInfo();

     char[] generatePassword(int length);

    void saveAdminInfo();
}

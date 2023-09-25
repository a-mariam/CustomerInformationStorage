package data.Model;

public class Admin {
   private String userName ;
   private  char [] password ;


    public Admin(String userName, char[] password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char [] getPassword() {
        return password;
    }

    public void setPassword(char [] password) {
        this.password = password;
    }
}

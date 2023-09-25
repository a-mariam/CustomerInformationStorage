package dto;

public class AdminInfo {
    private String name;
    char [] password;

    public AdminInfo(String name, char[] password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char []  getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}

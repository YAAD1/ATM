public class Users {
    private String Citizenship_number;
    private String Password;
    private String Balance;

    public Users(){}
    public Users(String citizenship_number, String password, String balance) {
        Citizenship_number = citizenship_number;
        Password = password;
        Balance = balance;
    }
    public void setCitizenship_number(String citizenship_number) {
        Citizenship_number = citizenship_number;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }
    public String getCitizenship_number() {
        return Citizenship_number;
    }

    public String getPassword() {
        return Password;
    }

    public String getBalance() {
        return Balance;
    }
}

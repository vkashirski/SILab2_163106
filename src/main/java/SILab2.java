import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<String> allUsers) { //1
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //2
        if (user==null) { //3
            throw new RuntimeException("The user is not instantiated"); //4
        } //5
        if (user.getUsername()==null || user.getPassword()==null) //6
            throw new RuntimeException("The user is missing some mandatory information"); //7
        String password = user.getPassword(); //8
        String passwordLower = password.toLowerCase(); //9
        if (passwordLower.contains(user.getUsername().toLowerCase())) { //10
            return false; //11
        } //12
        else if (passwordLower.length()<8) //13
            return false; //14
        else { //15
            boolean digit = false, upper = false, special = false; //16

            for (int i=0;i<password.length();i++) { //17
                if (Character.isDigit(password.charAt(i))) //18
                    digit = true; //19
                if (Character.isUpperCase(password.charAt(i))) //20
                    upper = true; //21
                if (specialCharacters.contains(String.valueOf(password.charAt(i)))) //22
                    special = true; //23
            } //24
            if (!digit || !upper || !special) //25
                return false; //26
        } //27
        return true; //28
    } //29
}
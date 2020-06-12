import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyStatementTest(){
        RuntimeException ex;
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";

        List<String> userList = new ArrayList<String>();

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, userList));
        assertTrue(ex.getMessage().contains("The user is not instantiated"));

        User user = new User(null, null, null);
        User finalUser = user;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(finalUser, userList));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        user = new User("bla", "blabla", null);
        String passwordLower = user.password.toLowerCase();
        assertTrue(passwordLower.contains(user.getUsername().toLowerCase()));

        assertTrue(passwordLower.length() < 8 );

        boolean digit = false, upper = false, special = false;
        for (int i=0;i<user.password.length();i++) { //17
            if (Character.isDigit(user.password.charAt(i))) //18
                digit = true; //19
            if (Character.isUpperCase(user.password.charAt(i))) //20
                upper = true; //21
            if (specialCharacters.contains(String.valueOf(user.password.charAt(i)))) //22
                special = true; //23
        }

        assertTrue(!digit || !upper || !special);

        assertFalse(digit || upper || special);

    }

}
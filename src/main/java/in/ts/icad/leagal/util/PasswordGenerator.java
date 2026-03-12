package in.ts.icad.leagal.util;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PasswordGenerator  {

	
	static char[] SYMBOLS = "^$*.[]{}()?-\"!@#%&/\\,><':;|_~`".toCharArray();
    static char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char[] NUMBERS = "0123456789".toCharArray();
    static char[] ALL_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    static Random rand = new SecureRandom();

    public static String getPassword(int length) {
        assert length >= 2;
        char[] password = new char[length];

        //get the requirements out of the way
        password[0] = LOWERCASE[rand.nextInt(LOWERCASE.length)];
       // password[1] = UPPERCASE[rand.nextInt(UPPERCASE.length)];
        password[1] = NUMBERS[rand.nextInt(NUMBERS.length)];
     //   password[3] = SYMBOLS[rand.nextInt(SYMBOLS.length)];

        //populate rest of the password with random chars
        for (int i = 2; i < length; i++) {
            password[i] = ALL_CHARS[rand.nextInt(ALL_CHARS.length)];
        }

        //shuffle it up
        for (int i = 0; i < password.length; i++) {
            int randomPosition = rand.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomPosition];
            password[randomPosition] = temp;
        }

        return new String(password);
    }

   /* public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getPassword(4));
        }
    }*/
}

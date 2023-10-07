package utils;

import java.util.Random;
public class RandomUtils {

    Random random = new Random();
    public String generateEmail(int length){
        String[] domains = { "gmail.com", "yahoo.com", "outlook.com", "example.com", "domain.com" };
        String domain = domains[random.nextInt(domains.length)];
        return (generateString(length) + "@" + domain);
    }

    public String generateString (int length){
        String characters = "abcdefghijklmnopqrstuvwxyz_____-----0123456789";
        char[] randomString = new char[length];
        int index = 0;
        for(int i = 0; i<length; i++){
            index = random.nextInt(characters.length());
            randomString[i] = characters.charAt(index);
        }
        return new String((randomString));
    }

    public String generatePassword (int length){
        String characters = "!@#$%^&*()1234567890QWERTYUIOPLKJHGFDSAzxcvbnm,.;lkjhgfddsa";
        char[] randomString = new char[length];
        int index = 0;
        for(int i = 0; i<length; i++){
            index = random.nextInt(characters.length());
            randomString[i] = characters.charAt(index);
        }
        return new String((randomString));
    }

}

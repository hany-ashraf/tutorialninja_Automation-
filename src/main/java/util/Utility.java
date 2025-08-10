package util;

import java.util.Random;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.Utility.generateRandomGmail;

public class Utility {

    static String loginMail;
    static String loginPassword;
    public static String getLoginMail() {
        return loginMail;
    }

    public static String getLoginPassword() {
        return loginPassword;
    }

    /**
     * This method generate name (firstName and lastName)
     * with a criteria in general name should be from 20 to 30 capital characters
     *
     * @return name
     */
    public static String generateRandomName() {
        Random random = new Random();
        int length = 20 + random.nextInt(11); // Random length between 20 and 30
        StringBuilder name = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('A' + random.nextInt(26)); // 'A' to 'Z'
            name.append(randomChar);
        }
        return name.toString();
    }

    /**
     * This method generate email in gmail domain
     *
     * @return email
     */
    public static String generateRandomGmail() {
        Random random = new Random();
        int length = 10 + random.nextInt(6); // Length between 10 and 15
        StringBuilder localPart = new StringBuilder(length);

        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            localPart.append(randomChar);
        }
        loginMail = localPart.toString() + "@gmail.com";
        return localPart.toString() + "@gmail.com";
    }

    /**
     * Here’s a Java method that generates a secure random password with:
     * Uppercase letters
     * Lowercase letters
     * Digits
     * Special characters
     * A random length between 20 and 30 ex. <;)=@@5@nrs*FrPSu@@GW>
     *
     * @return password
     */
    public static String generateRandomPassword() {
        SecureRandom random = new SecureRandom();

        // Character sets
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        // All characters combined
        String allChars = upperCase + lowerCase + digits + specialChars;

        // Random password length between 20 and 30
        int length = 20 + random.nextInt(11);

        List<Character> passwordChars = new ArrayList<>();

        // Ensure at least one of each type
        passwordChars.add(upperCase.charAt(random.nextInt(upperCase.length())));
        passwordChars.add(lowerCase.charAt(random.nextInt(lowerCase.length())));
        passwordChars.add(digits.charAt(random.nextInt(digits.length())));
        passwordChars.add(specialChars.charAt(random.nextInt(specialChars.length())));

        // Fill the rest of the password
        for (int i = 4; i < length; i++) {
            passwordChars.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle to avoid predictable pattern
        Collections.shuffle(passwordChars, random);

        // Convert to string
        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }
        loginPassword = password.toString();
        return password.toString();
    }

    public static String getRandomCurrency() {
        String[] currencies = {"€Euro", "£Pound Sterling", "$US Dollar"};
        Random random = new Random();
        int index = random.nextInt(currencies.length);
        return currencies[index];
    }
    public static String getRandomCategory(){
        String[] Category = {
                "Desktops",
                "Laptops & Notebooks",
                "Components",
                "MP3 Players"
        };

        Random random3 = new Random();
        int index_3 = random3.nextInt(Category.length);
        return Category[index_3];
    }

    public static String getRandomSupCategory(String Cat) {

        switch (Cat) {
            case "Desktops":
                String[] supCategory1 = {
                        "PC (0)",
                        "Mac (1)"
                };

                Random random1 = new Random();
                int index_1 = random1.nextInt(supCategory1.length);
                return supCategory1[index_1];
            case "Laptops & Notebooks":
                String[] supCategory2 = {
                        "Macs (0)",
                        "Windows (0)"
                };

                Random random2 = new Random();
                int index_2 = random2.nextInt(supCategory2.length);
                return supCategory2[index_2];
            case "Components":
                String[] supCategory3 = {
                        "Mice and Trackballs (0)",
                        "Monitors (2)",
                        "Scanners (0)",
                        "Web Cameras (0)"
                };

                Random random3 = new Random();
                int index_3 = random3.nextInt(supCategory3.length);
                return supCategory3[index_3];

            case "MP3 Players":
                String[] supCategory9 = {
                        "test 7 (0)",
                        "test 8 (0)",
                        "test 9 (0)",
                        "test 10 (0)"
                };

                Random random9 = new Random();
                int index_9 = random9.nextInt(supCategory9.length);
                return supCategory9[index_9];

        }
        return "Can't Find Cat !";
    }
    public static String removeParenthesesAndNumbers(String input) {
        // Remove parentheses and digits
        return input.replaceAll("[()\\d]", "").trim();
    }
}


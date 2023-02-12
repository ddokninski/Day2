package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenGenerator {

    public Token tokenGenerator() {
        Random random = new Random();
        StringBuilder userToken = new StringBuilder();

        while (true) {

            System.out.println("Enter token length (5 or 10 or 15): ");
            Scanner scanner = new Scanner(System.in);
            String valueFromUser = scanner.next();
            boolean correctValueFromUserFlag = checkValueFromUser(valueFromUser);

            if (correctValueFromUserFlag) {
                int tokenLength = Integer.parseInt(valueFromUser);
                for (int i = tokenLength; i > 0; i--) {
                    char randomChar = (char) (random.nextInt(256) + 1);
                    userToken.append(randomChar);
                }
                return new Token(userToken.toString());

            } else {
                System.out.println("Wrong value. Type correct value 5 or 10 or 15");
            }
        }
    }

    private boolean checkValueFromUser(String valueFromUser) {
        Pattern pattern = Pattern.compile("(5)|(10)|(15)");
        valueFromUser = valueFromUser.trim();
        Matcher matcher = pattern.matcher(valueFromUser);

        return matcher.matches();
    }
}

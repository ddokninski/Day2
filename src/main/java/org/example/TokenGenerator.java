package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenGenerator {
    public void tokenGenerator() {
        System.out.println("Enter token length (5 or 10 or 15) or exit: ");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String valueFromUser = scanner.next();
            boolean correctValueFromUserFlag = checkValueFromUser(valueFromUser);

            if (valueFromUser.equals("exit")) {
                break;
            }

            System.out.println(correctValueFromUserFlag ?
                    "Your " + valueFromUser + " digits token: " + tokenMaker(valueFromUser) : "Wrong value. Type correct value 5 or 10 or 15. For stop program type \"exit\" ");

            if (correctValueFromUserFlag) {
                break;
            }
        }
    }

    private String tokenMaker(String valueFromUser) {
        Random random = new Random();
        StringBuilder userToken = new StringBuilder();
        int tokenLength = Integer.parseInt(valueFromUser);
        while (userToken.length() != tokenLength) {
            char randomChar = (char) (random.nextInt(256) + 1);

            if (checkChar(String.valueOf(randomChar))) {
                userToken.append(randomChar);
            }
        }
        return (userToken.toString());
    }

    private boolean checkValueFromUser(String valueFromUser) {
        Pattern pattern = Pattern.compile("(5)|(10)|(15)");
        valueFromUser = valueFromUser.trim();
        Matcher matcher = pattern.matcher(valueFromUser);

        return matcher.matches();
    }

    private boolean checkChar(String valueFromUser) {
        Pattern pattern = Pattern.compile("[a-z]|[A-Z]|[0-9]|[!@#$%^&*()]");
        valueFromUser = valueFromUser.trim();
        Matcher matcher = pattern.matcher(valueFromUser);

        return matcher.matches();
    }
}

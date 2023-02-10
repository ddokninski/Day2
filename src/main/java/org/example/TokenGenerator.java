package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenGenerator {

    public Token tokenGenerator() {
        Pattern pattern = Pattern.compile("(5)|(10)|(15)");
        Random random = new Random();
        String userToken = "";
        String valueFromUser = "";

        while (true) {
            System.out.println("Enter token length (5 or 10 or 15): ");
            Scanner scanner = new Scanner(System.in);
            valueFromUser = scanner.next();
            valueFromUser = valueFromUser.trim();
            Matcher matcher = pattern.matcher(valueFromUser);

            if (matcher.matches()) {
                int tokenLength = Integer.parseInt(valueFromUser);
                while (tokenLength > 0) {
                    tokenLength--;
                    char randomChar = (char) (random.nextInt(256) + 1);
                    userToken = userToken.concat(String.valueOf(randomChar));
                }
                return new Token(userToken);
            } else {
                System.out.println("Wrong length. Type correct value 5 or 10 or 15");
            }
        }
    }
}

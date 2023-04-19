package ru.ntr;


import ru.ntr.library.IStack;
import ru.ntr.library.StackImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseText {
    public static void main(String[] args) {
        System.out.println("Reversed text: " + reverse(readFromConsole()));
    }

    private static String reverse(String text) {

        IStack<Character> charStack = new StackImpl<>(text.length());

        for (int i = 0; i < text.length(); i++) {
            charStack.push(text.charAt(i));
        }

        StringBuilder reversedText = new StringBuilder();

        while (!charStack.isEmpty()) {
            reversedText.append(charStack.pop());
        }

        return reversedText.toString();
    }

    private static String readFromConsole() {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter text to reverse: ");
            return consoleReader.readLine();
        } catch (IOException e) {
            System.out.println("Error during reading line from console.");
        }
        return null;
    }


}

package Main;

import java.util.Scanner;

public class Main {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encoding(String plainText, int Key) {
        plainText = plainText.toLowerCase();
        String cText = "";
        for (int i = 0; i < plainText.length(); i++) {
            int charIndex = alphabet.indexOf(plainText.charAt(i));
            int newIndex = (charIndex + Key) % 26;
            char cipherChar = alphabet.charAt(newIndex);
            cText = cText + cipherChar;
        }

        return cText;

    }

    public static String decoding(String cText, int Key) {
        cText = cText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cText.length(); i++) {
            int charIndex = alphabet.indexOf(cText.charAt(i));
            int newIndex = (charIndex - Key) % 26;
            if (newIndex < 0) {
                newIndex = alphabet.length() + newIndex;
            }
            char plainChar = alphabet.charAt(newIndex);
            plainText = plainText + plainChar;
        }
        return plainText;
    }

    public static void main(String[] args) {
        // making use of the encoding and decoding
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Plain text");
        String plain = scanner.nextLine();

        System.out.println("Enter Key");
        int Key = scanner.nextInt();

        String cipherText = encoding(plain, Key);
        System.out.println("The Cipher Text Is.."+ cipherText);

        System.out.println("the now decoded message is: "+ decoding(cipherText, Key));
    }

}

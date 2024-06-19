/*
 * MoreSo : to encode a plain text message to Morse code as well as decode it back to plain text.
 */

import java.util.HashMap;
import java.util.Scanner;

public class MorSo {

    // Mapping of characters to Morse code
    private static final HashMap<Character, String> morseKey = new HashMap<>();
    // Reverse mapping of Morse code to characters
    private static final HashMap<String, Character> reverseMorseKey = new HashMap<>();

    // Static block to initialize the Morse code mappings
    static {
        morseKey.put('A', ".-");
        morseKey.put('B', "-...");
        morseKey.put('C', "-.-.");
        morseKey.put('D', "-..");
        morseKey.put('E', ".");
        morseKey.put('F', "..-.");
        morseKey.put('G', "--.");
        morseKey.put('H', "....");
        morseKey.put('I', "..");
        morseKey.put('J', ".---");
        morseKey.put('K', "-.-");
        morseKey.put('L', ".-..");
        morseKey.put('M', "--");
        morseKey.put('N', "-.");
        morseKey.put('O', "---");
        morseKey.put('P', ".--.");
        morseKey.put('Q', "--.-");
        morseKey.put('R', ".-.");
        morseKey.put('S', "...");
        morseKey.put('T', "-");
        morseKey.put('U', "..-");
        morseKey.put('V', "...-");
        morseKey.put('W', ".--");
        morseKey.put('X', "-..-");
        morseKey.put('Y', "-.--");
        morseKey.put('Z', "--..");
        morseKey.put('1', ".----");
        morseKey.put('2', "..---");
        morseKey.put('3', "...--");
        morseKey.put('4', "....-");
        morseKey.put('5', ".....");
        morseKey.put('6', "-....");
        morseKey.put('7', "--...");
        morseKey.put('8', "---..");
        morseKey.put('9', "----.");
        morseKey.put('0', "-----");

        for (Character key : morseKey.keySet()) {
            reverseMorseKey.put(morseKey.get(key), key);
        }
    }

    /**
     * Encodes a given message into Morse code.
     *
     * @param msg The message to encode.
     * @return The encoded Morse code message.
     */
    public static String encode(String msg) {
        StringBuilder cipher = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (ch != ' ') {
                cipher.append(morseKey.get(ch)).append(' ');
            } else {
                cipher.append(' ');
            }
        }
        return cipher.toString();
    }

    /**
     * Decodes a given Morse code message into plain text.
     *
     * @param msg The Morse code message to decode.
     * @return The decoded plain text message.
     */
    public static String decode(String msg) {
        msg += ' ';
        StringBuilder decipher = new StringBuilder();
        StringBuilder citext = new StringBuilder();
        int spaceCount = 0;

        for (char ch : msg.toCharArray()) {
            if (ch != ' ') {
                spaceCount = 0;
                citext.append(ch);
            } else {
                spaceCount++;
                if (spaceCount == 2) {
                    decipher.append(' ');
                } else {
                    if (citext.length() > 0) {
                        decipher.append(reverseMorseKey.get(citext.toString()));
                        citext.setLength(0);
                    }
                }
            }
        }
        return decipher.toString();
    }

    /**
     * Main method to handle user input and display the Morse code encoding.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text here => ");
        String text = scanner.nextLine().toUpperCase();
        String result = encode(text);
        System.out.println(text + " => " + result);
        scanner.close();
    }
}

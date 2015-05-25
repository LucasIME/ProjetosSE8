/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meireles
 */
public class morseConverter {

    String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
        "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
        "9", "0", " ", "\n"};
    String[] dottie = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
        "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
        "-....", "--...", "---..", "----.", "-----", "    ", "<br>"};

    public String toMorse(char[] resp) {
        String morse = "";
        for (int i = 0; i < resp.length; i++) {
            for (int j = 0; j < this.alpha.length; j++) {
                if (resp[i] == alpha[j].charAt(0)) {
                    morse += this.dottie[j];
                }
            }
        }
        return morse;

    }

}

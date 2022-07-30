package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;

/* https://www.notion.so/jarvisdev/Print-letter-with-number-773b5ebc9cf247f7805fa2f90b78dff7 */
public class PrintLetterWithNumber {

    /* O(n). Loop through each character of the input,
    adding at most 3 characters into the output array. O(3n) = O(n). */
    public String enumerateStringChars(String input) {
        if (input == null || input.isEmpty())
            return "";

        char[] output = new char[input.length() * 3];
        String number;
        int codePoint, arrIndx = 0;

        for (int i = 0; i < input.length(); i++) {
            output[arrIndx] = input.charAt(i);
            arrIndx++;

            codePoint = input.codePointAt(i);
            if (codePoint >= 97 && codePoint <= 122)
                codePoint -= 96;
            else if (codePoint >= 65 && codePoint <= 90)
                codePoint -= 38;
            else
                return "";

            number = String.valueOf(codePoint);
            for (int j = 0; j < number.length(); j++) {
                output[arrIndx] = number.charAt(j);
                arrIndx++;
            }
        }
        return new String(Arrays.copyOfRange(output, 0, arrIndx));
    }

}

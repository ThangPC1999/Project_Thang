package runner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
        String input = "Phiếu gửi hàng PGHBD7817642";
        String pattern = "[A-Za-z]+\\d+"; // A sequence of letters followed by numbers

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        if (matcher.find()) {
            String extractedSubString = matcher.group();
            System.out.println("Extracted substring: " + extractedSubString);
        } else {
            System.out.println("Pattern not found in the input string.");
        }
    }

}

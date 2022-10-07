import java.io.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        Scanner scan = new Scanner(file);
        String str = scan.nextLine();
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)|(\\+|\\-|\\*|\\/)");
        Matcher matcher = pattern.matcher(str);
        List<String> strings = new ArrayList<>();
        while (matcher.find()) {
            strings.add(matcher.group());
        }
        String s = strings.toString();
        System.out.println(s.replaceAll ("^[-+/*]+|[-+/*]+$"," " ));
        scan.close();
    }
}
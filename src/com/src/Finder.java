package com.src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public interface Finder {

    public String FindFirst(String input);

    public String ReplaceFirst(String input, String replace);

    public boolean exists(String input);
}

    class AlgebraicExpressionFinder implements Finder {

        Pattern pattern;
        Matcher matcher;

        AlgebraicExpressionFinder() {
            pattern = Pattern.compile("[0-9]+\s*[+^*/-]\s*[0-9]+");
        }

        public String FindFirst(String input) {

            String output;

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                output = input.substring(matcher.start(), matcher.end());
            } else output = "";

            return output;

        }

        public String ReplaceFirst(String input, String replace) {

            String output;

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                output = matcher.replaceFirst(replace);
            } else output = input;

            return output;
        }

        public boolean exists(String input) {
            matcher = pattern.matcher(input);
            return matcher.find();
        }
    }
    class NumberFinder implements Finder {

        Pattern pattern;
        Matcher matcher;

        NumberFinder() {
            pattern = Pattern.compile("[0-9]+");
        }

        public String FindFirst(String input) {

            String output;

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                output = input.substring(matcher.start(), matcher.end());
            } else output = "";

            return output;

        }

        public String ReplaceFirst(String input, String replace) {

            String output;

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                output = matcher.replaceFirst(replace);
            } else output = input;

            return output;
        }

        public boolean exists(String input) {
            matcher = pattern.matcher(input);
            return matcher.find();
        }
    }
    class OperationFinder implements Finder {

        Pattern pattern;
        Matcher matcher;

        OperationFinder() {
            pattern = Pattern.compile("[+^*/-]");
        }

        public String FindFirst(String input) {

            String output;

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                output = input.substring(matcher.start(), matcher.end());
            } else output = "";

            return output;

        }

        public String ReplaceFirst(String input, String replace) {

            String output;

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                output = matcher.replaceFirst(replace);
            } else output = input;

            return output;
        }

        public boolean exists(String input) {
            matcher = pattern.matcher(input);
            return matcher.find();
        }
    }

public class Main {
    public static void main(String[] args) {



        System.out.println("Hello, World!");
    }


    public static String eval(String str) {

        if (str.contains("(")) {
            int strt = 0, end;
            strt = str.lastIndexOf('(');
            end = str.indexOf(')', strt);
            String inside = str.substring(strt, end);
            str = str + eval(inside) + str.substring(end + 1);
            return eval(str);
        }

        if (str.contains("*") || str.contains("/")) {
            int opr = 0;
            for (int i = 0; i < str.length() - 1; i++) {
                char c = str.charAt(i);
                if (c == '*' || c == '/') {
                    String right = eval(str.substring(0, i));
                    String left = eval(str.substring(i + 1));
                    int result = c == '*' ? Integer.parseInt(left) * Integer.parseInt(right) :
                            Integer.parseInt(left) / Integer.parseInt(right);
                    return String.valueOf(result);
                }

            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '+' || c == '-') {
                    String left = eval(str.substring(0, i)); // מה שמשמאל לאופרטור
                    String right = eval(str.substring(i + 1)); // מה שמימין לאופרטור
                    int result = c == '+' ? Integer.parseInt(left) + Integer.parseInt(right) :
                            Integer.parseInt(left) - Integer.parseInt(right);
                    return String.valueOf(result); // החזרה כמחרוזת
                }
            }
        }
        return str;
    }
}
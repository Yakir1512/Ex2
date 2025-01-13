package assignments.ex2;
// Add your documentation below:

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static assignments.ex2.Ex2Sheet.getCellValue;

public class SCell implements Cell {

    public enum CellType{
        NUMBER,
        TEXT,
        FORMULA,
        ERROR
    }


    private String line;
    private String data;
    private int type;
    private CellType CellType;
    private int order;

    public SCell(String s) {
        this.line=s;
        setData(s);
    }

    @Override
    public int getOrder() {
        return 0;
    }
    public String getAns(){
        return this.data;
     }
    public void setAns(String s){
         this.data=s;
    }

    @Override
    public String toString() {

        return getData();
    }

    @Override
    public void setData(String s) {
        classifying(s);
           s=this.line;


    }

    public void classifying(String s) {
        if (s.startsWith("=")) {
            String formula = s.substring(1); // הסרת הסימן '='

            // תרגום שמות תאים לערכים
            String formulaWithValues = replaceCellValues(formula);

            if (isValidFormula(formulaWithValues)) {
                setType(Ex2Utils.FORM);
                String result = Ex2Sheet.eval(formulaWithValues);
                setAns(result);
                this.line = result;
                return;
            } else {
                this.line = "ERR_FORM_FORMAT";
                setType(Ex2Utils.ERR_FORM_FORMAT);
            }
            return;
        }

        if (isNumber(s)) {
            setType(Ex2Utils.NUMBER);
            setAns(this.line);
            return;
        }

        setType(Ex2Utils.TEXT);
    }

    static boolean isValidFormula(String formula) {
        if (formula == null || formula.trim().isEmpty()) {
            return false;
        }

        if (!checkBrackets(formula)) {
            return false;
        }

        if (!operatorCheck(formula)) {
            return false;
        }

        // בדיקה שהתווים חוקיים
        return formula.matches("[A-Z]\\d+|\\d+(\\.\\d+)?|[-+*/()\\d\\s]+");
    }

    private static boolean checkBrackets(String expression) {
        int count = 0;
        if ((expression.contains("(") || expression.contains(")"))) {
            for (char c : expression.toCharArray()) {
                if (c == '(') count++;
                if (c == ')') count--;
                if (count < 0) return false;  // יותר סוגריים סוגרים מסוגרים פותחים
            }
        }
        return count == 0;
    }

    private static boolean operatorCheck(String expression) {
        int i = 1;
        if (expression.contains("+") || expression.contains("-") || expression.contains("/") || expression.contains("*")) {
            for (char c : expression.toCharArray()) {
                if (i == expression.length() - 1) return true;
                char next = expression.charAt(i);
                if (i < expression.length() && !(c == '+' || c == '-' || c == '*' || c == '/') && next == '(') return false;
                if (i < expression.length() && !(next == '+' || next == '-' || next == '*' || next == '/') && c == ')') return false;
                i++;
            }
        }
        return true;
    }

    static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String replaceCellValues(String str) {
        // תבנית לזיהוי תאים בפורמט אות+מספר (למשל: A2)
        Pattern pattern = Pattern.compile("([A-Z])(\\d+)");
        Matcher matcher = pattern.matcher(str);
        StringBuffer result = new StringBuffer();

        // מציאת תאים והחלפתם בערכים שלהם
        while (matcher.find()) {
            String column = matcher.group(1); // אות העמודה
            int row = Integer.parseInt(matcher.group(2)); // מספר השורה
            int x = row; // המספר מתאים לשורה
            int y = column.charAt(0) - 'A'; // המרה מאות לעמודה (A=0, B=1 וכו')
            double cellValue = getCellValue(x, y); // קבלת ערך התא
            matcher.appendReplacement(result, String.valueOf(cellValue)); // החלפה בערך התא
        }

        matcher.appendTail(result);
        return result.toString();
    }


    public void SetAns(String s){
        this.data=s;
    }
    @Override
    public String getData() {
        return this.line;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public  void setType(int t) {
        this.type = t;
    }

    @Override
    public void setOrder(int t) {
        this.order = t;
    }

}
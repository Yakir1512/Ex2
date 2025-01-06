package assignments.ex2;
// Add your documentation below:

public class SCell implements Cell {

    public enum CellType{
        NUMBER,
        TEXT,
        FORMULA,
        ERROR
    }


    private String line;
    private int type;
    private CellType CellType;
    private int order;

    public SCell(String s) {
        setData(s);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    //@Override
    @Override
    public String toString() {

        return getData();
    }

    @Override
    public void setData(String s) {
        this.line = s;

        if (s.startsWith("=")) {
            if (isValidFormula(s.substring(1))) {
                setType(Ex2Utils.FORM);
                setData(Ex2Sheet.eval(s));
            } else {
                setData("ERR_FORM_FORMAT");
                setType(Ex2Utils.ERR_FORM_FORMAT);
            }
            return;
        }
        if (isNumber(s)) {
            setType(Ex2Utils.NUMBER);
            return;
        }
        if (s == null || s.trim().isEmpty()) {
            setType(Ex2Utils.TEXT);
            return;
        }
        setType(Ex2Utils.TEXT);
    }

    private boolean isValidFormula(String formula) {
        if (formula == null || formula.trim().isEmpty()) {
            return false;
        }

        if (!checkBrackets(formula)) {
            return false;
        }

        if (!opertorCheck(formula))
            return false;
        // בדיקה בסיסית של תקינות הנוסחה
        // צריך להרחיב את זה בהמשך לבדיקה מקיפה יותר
        return formula.matches("[A-Z]\\d+|\\d+(\\.\\d+)?|[-+*/()\\d\\s]+");
    }

    private static boolean checkBrackets(String expression) {
        int count = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;  // יותר סוגריים סוגרים מפותחים
        }
        return count == 0;
    }

    private static boolean opertorCheck(String expression){
        int i = 1;
        for (char c: expression.toCharArray()) {

            if ((c!='+'||c!='-') && i<expression.length()&& expression.charAt(i) == '(') return false;
            if ((c!='*'||c!='/')&&i<expression.length() && expression.charAt(i) == '(') return false;
            if (c == ')' && (expression.charAt(i)!='*' || expression.charAt(i)!='/')) return false;
            if (c == ')' && (expression.charAt(i)!='-' || expression.charAt(i)!='+')) return false;
            i++;
        }
        return true;
    }


    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getData() {
        return line;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int t ) {
       this.type = t;
    }

    @Override
    public void setOrder(int t) {
        this.order = t;
    }

}

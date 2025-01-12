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
        classefing(s);
           s=this.line;


    }

    public void classefing(String s){
        if (s.startsWith("=")) {
            if (isValidFormula(s.substring(1))) {
                setType(Ex2Utils.FORM);
              setAns(Ex2Sheet.eval(s.substring(1)));
              this.line=Ex2Sheet.eval(s.substring(1));

              //לחשב את הפונקציה
              return;
            }
            else {
                this.line="ERR_FORM_FORMAT";
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

        if (!opertorCheck(formula))
            return false;

        return formula.matches("[A-Z]\\d+|\\d+(\\.\\d+)?|[-+*/()\\d\\s]+");
    }

    private static boolean checkBrackets(String expression) {
        int count = 0;
        if ((expression.contains("(")||expression.contains(")")))
        for (char c : expression.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;  // יותר סוגריים סוגרים מפותחים
        }
        return count == 0;
    }

    private static boolean opertorCheck(String expression){
        int i = 1;
        if (expression.contains("+")||expression.contains("-")||expression.contains("/")||expression.contains("/"))
        for (char c: expression.toCharArray()) {
            if (i==expression.length()-1)return true;
            char next = expression.charAt(i);
            if (i<expression.length() && !(c=='+'||c=='-'||c=='*'||c=='/') &&  next == '(') return false;
            if (i<expression.length() &&  !(next=='+'||next=='-'||next=='*'||next=='/') && c ==')') return false;
            i++;
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
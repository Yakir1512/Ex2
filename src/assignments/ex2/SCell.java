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
        if (s == null || s.trim().isEmpty()) {
            setType(Ex2Utils.TEXT);
            return;
        }
        if (isNumber(s)) {
            setType(Ex2Utils.NUMBER);
            return;
        }

        if (s.startsWith("=")) {
            if (isValidFormula(s.substring(1))) {
                setType(Ex2Utils.FORM);
            } else {
                setType(Ex2Utils.ERR_FORM_FORMAT);
            }
            return;
        }

        setType(Ex2Utils.TEXT);
    }

    private boolean isValidFormula(String formula) {
        if (formula == null || formula.trim().isEmpty()) {
            return false;
        }

        // בדיקה בסיסית של תקינות הנוסחה
        // צריך להרחיב את זה בהמשך לבדיקה מקיפה יותר
        return formula.matches("[A-Z]\\d+|\\d+(\\.\\d+)?|[-+*/()\\d\\s]+");
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
    public void setType(int t) {
       this.type = t;
    }

    @Override
    public void setOrder(int t) {
        this.order = t;
    }
}

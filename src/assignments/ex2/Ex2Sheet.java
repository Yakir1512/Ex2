package assignments.ex2;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.LinkedList;


public class Ex2Sheet implements Sheet {
    private Cell[][] table;

    public Ex2Sheet(int x, int y) {
        table = new SCell[x][y];
        for(int i=0;i<x;i=i+1) {
            for(int j=0;j<y;j=j+1) {
                table[i][j] = new SCell("");
            }
        }
        eval();
    }
    public Ex2Sheet() {
        this(Ex2Utils.WIDTH, Ex2Utils.HEIGHT);
    }

    @Override
    public String value(int x, int y) {
        String ans = Ex2Utils.EMPTY_CELL;
        // Add your code here

        Cell c = get(x,y);
        if(c!=null) {ans = c.toString();}

        return ans;
    }

    @Override
    public Cell get(int x, int y) {
        return table[x][y];
    }

    @Override
    public Cell get(String cords) {
        Cell ans = null;
        return ans;
    }

    @Override
    public int width() {
        return table.length;
    }


    @Override
    public int height() {
        return table[0].length;
    }



    @Override
    public void set(int x, int y, String s) {
        Cell c = new SCell(s);
        table[x][y] = c;
    }
    @Override
    public void eval() {

        int[][] dd = depth();

        //nna

    }

    @Override
    public boolean isIn(int xx, int yy) {
        boolean ans = xx>=0 && yy>=0;
        if(xx< table.length&&yy< table[0].length) {
            return ans;
        }

        return ans;
    }

    @Override
    public int[][] depth() {
        int[][] arr = new int[2] [2];
            return arr ;



    }

    @Override
    public void load(String fileName) throws IOException {
        // Add your code here

        /////////////////////
    }

    @Override
    public void save(String fileName) throws IOException {
        // Add your code here

        /////////////////////
    }

    @Override
    public String eval(int x, int y) {
        String ans = null;
        if(get(x,y)!=null) {
            ans = get(x,y).toString();}
        ans = eval(table[x][y].getData());

        /////////////////////
        return ans;
    }

    public static String eval(String str) {
        //  הסרת רווחים מיותרים
        str = str.replaceAll("\\s+", "");

        // טיפול בסוגריים
        if (str.contains("(")) {
            int openIndex = str.lastIndexOf('('); // סוגר פותח פנימי ביותר
            int closeIndex = str.indexOf(')', openIndex); // סוגר סוגר תואם
            String inside = str.substring(openIndex + 1, closeIndex); // מה שבתוך הסוגריים
            String result = eval(inside); // חישוב תוכן הסוגריים
            // הרכב מחדש את המחרוזת בלי הסוגריים
            str = str.substring(0, openIndex) + result + str.substring(closeIndex + 1);
            return eval(str); // המשך החישוב
        }

        //  טיפול באופרטורים: * ו-/
        if (str.contains("*")||str.contains("/"))
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '*' || c == '/') {
                String left = eval(str.substring(0, i)); // מה שמשמאל לאופרטור
                String right = eval(str.substring(i + 1)); // מה שמימין לאופרטור
                int result = c == '*' ? Integer.parseInt(left) * Integer.parseInt(right) :
                        Integer.parseInt(left) / Integer.parseInt(right);
                return String.valueOf(result); // החזרה כמחרוזת
            }
        }

        //  טיפול באופרטורים: + ו--
        if (str.contains("-")||str.contains("+"))
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

        // 5. תנאי עצירה: אם זו ספרה בלבד
        return str;
    }

}

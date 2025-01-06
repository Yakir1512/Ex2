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
        int ans = 0, arr = 0;
        String nstr = null;
        if(!str.contains("*")&&!str.contains("-")&&!str.contains("+")&&!str.contains("/"))
            return str;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int barCount = 0;

            if (c == '(') barCount++;
            if (c == ')') barCount--;

            if (str.startsWith("(") && str.endsWith(")"))
                return eval(str.substring(1, str.length() - 1));


            if (barCount == 0) {
                if (c == '+' || c == '-') {
                    int left = Integer.parseInt(eval(str.substring(0, i)));
                    int right = Integer.parseInt(eval(str.substring(i + 1)));
                    return Integer.toString(c == '+' ? left + right : left - right);
                }
            }

        }

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            int barCount = 0;

            if (c == ')') barCount++;
            if (c == '(') barCount--;

            // אם אנחנו מחוץ לסוגריים, בודקים אופרטורים
            if (barCount == 0) {
                if (c == '*' || c == '/') {
                    int left = Integer.parseInt(eval(str.substring(0, i)));
                    int right = Integer.parseInt(eval(str.substring(i + 1)));
                    return Integer.toString(c == '*' ? left * right : left / right);
                }
            }

        }

        if (str.matches("\\d+")) {
            return str;
        }


//        for(int i=0; str.length()>=i; i++){
//            int tempIndx = i+1;
//            if (str.charAt(i)=='(') {
//                while (str.charAt(i) != ')')
//                    i++;
//                nstr=str.substring(tempIndx,i);
//                return calculate(str);
//            }
//
//            if (str.charAt(i)=='*')
//                nstr=Integer.toString(Integer.parseInt(str.substring(tempIndx,i))*calculate(str.substring(i+1)));
//            if (str.charAt(i)=='-')
//                nstr=Integer.toString(Integer.parseInt(str.substring(tempIndx,i))-calculate(str.substring(i+1)));
//            if (str.charAt(i)=='+')
//                nstr=Integer.toString(Integer.parseInt(str.substring(tempIndx,i))+calculate(str.substring(i+1)));
//            if (str.charAt(i)=='/')
//                nstr=Integer.toString(Integer.parseInt(str.substring(tempIndx,i))/calculate(str.substring(i+1)));
//
//        }
//
//        return Integer.parseInt(nstr);
//    }
        return null;
    }
}

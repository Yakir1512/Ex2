package assignments.ex2;
import java.io.IOException;
// Add your documentation below:

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
0

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
        if(xx< table.length&&yy< table[0].length)
        return ans;

    }

    @Override
    public int[][] depth() {
        int[][] ans = new int[width()][height()];
        int[][] depth(Sheet s) {
            int[][] ans = new int[w][h];
            init each cell in ans to  -1;
            int depth = 0, count = 0, max = w*h;
            boolean flagC = true;
            while(count <max && flagC) {
                flagC = false;
                for(int x = 0;;x<w;x++) {
                    for(int y = 0;y<h;y++) {
                        if(canBeCompudedNow(x,y)) { // DIY
                            ans[x][y] = depth;
                            counter+=1;
                            flagC=true;
                        } // if
                    } // for yt
                }  // for x
                depth+=1;
            } while
            return ans;
        }


            // ///////////////////
        return ans;
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
        if(get(x,y)!=null) {ans = get(x,y).toString();}
        // Add your code here

        /////////////////////
        return ans;
        }
}

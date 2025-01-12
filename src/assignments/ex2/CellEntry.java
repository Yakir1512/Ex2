package assignments.ex2;
// Add your documentation below:

public class CellEntry  implements Index2D {

    @Override
    public String toString(int x, int y){

            if (x < 0 || y < 0) {
                throw new IllegalArgumentException("Indices must be non-negative.");
            }
            char column = getLetterFromIndex(x); // המרת X לאות
            return column + String.valueOf(y + 1); // צירוף האות והמספר (Y + 1)
        }

    @Override
    public boolean isValid() {
        if ((this.getX()>64&&this.getX()<91)||(this.getX()>96&&this.getX()<123)&&this.getY()<=99&&this.getY()>=0)
        return true;

        return false;
    }

    @Override
    public int getX() {return Ex2Utils.ERR;}

    @Override
    public int getY() {return Ex2Utils.ERR;}

    public  char getLetterFromIndex(int index) {
        if (index < 0 || index > 25) {
            throw new IllegalArgumentException("Index must be between 0 and 25.");
        }
        return (char) ('A' + index);
    }
}

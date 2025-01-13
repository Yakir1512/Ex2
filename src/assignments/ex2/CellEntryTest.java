package assignments.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellEntryTest {

    @Test
    void testGetLetterFromIndex() {
            int[] isok={1,2,6,0};
            char[] ansOfisOk={'B','C','G','A'};
            for (int i=0;i< isok.length;i=i+1){
                assertEquals(CellEntry.getLetterFromIndex(isok[i]),ansOfisOk[i]);

            }
    }

//    @Test
//    void testToString() {
//        int[] x={1,2,6,5};
//        int[] y={1,2,6,5};
//        String[] ansOfisOk={"B1","C2","G6","F5"};
//        for (int i=0;i< x.length-1;i=i+1){
//            assertEquals(toString(x[i],y[i]),ansOfisOk[i]);
//
//        }
//    }
}
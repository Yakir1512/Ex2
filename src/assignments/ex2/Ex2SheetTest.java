package assignments.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2SheetTest {

    @Test
    void eval() {
        String[] isok={"5.5+22","4*(2+3+5)/2","(2+2)+(2+2)"};
        String[] ansOfisOk={"27.5","20.0","8.0"};
        for (int i=0;i< isok.length;i=i+1){
            assertEquals(Ex2Sheet.eval(isok[i]),ansOfisOk[i]);

        }

    }
}
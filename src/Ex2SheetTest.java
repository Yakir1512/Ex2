import assignments.ex2.Ex2Sheet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex2SheetTest {
    @Test
    void value(){
        String s = "1+(1*2)";
        int v = Ex2Sheet.calculate(s);
        assertEquals(3, v, "Formula is calculated good");


    }
}

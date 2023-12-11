package FinalExam;

import com.shirley.demo.day16.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrayonTest {
    @Test
    public void getPercentRemaining(){
        Crayon crayon = new Crayon();
        double expected = 1;
        double actual = crayon.getPercentRemaining();

        assertEquals(expected, actual);
    }

    @Test
    public void getColor(){
        Crayon crayon = new Crayon();
        String expected = "black";
        String actual = crayon.getColor();

        assertEquals(expected, actual);
    }
}
import org.junit.Test;

import java.text.MessageFormat;

public class TestBinaryOperations {

    @Test
    public void TestBinaryMultiplication() {
        int[] x = new int[]{ 0b1000, 0b0, 0b101, 0b1101 };
        int y = 0b101;

        for (int i = 0; i < x.length; i++) {
            int result = BinaryOperations.Multiply(x[i], y);
            int xDecimal = Integer.parseInt(x[i]+"");
            int yDecimal = Integer.parseInt(y+"");
            int product = Integer.parseInt(Integer.toBinaryString(xDecimal * yDecimal), 2);
            assert (result == product);
        }
    }

    @Test
    public void TestBinaryDivision() {
        int x = 0b10110;
        int[] y = new int[]{ 0b1000, 0b101, 0b1101,  0b1011, 0b111111};

        for (int i = 0; i < y.length; i++) {
            int result = BinaryOperations.Divide(x, y[i]);
            int xDecimal = Integer.parseInt(x+"");
            int yDecimal = Integer.parseInt(y[i]+"");
            int product = Integer.parseInt(Integer.toBinaryString(xDecimal / yDecimal), 2);
            assert (result == product);
        }

        try {
            BinaryOperations.Divide(x, 0b0);
        } catch (Exception e) {
            String expectedMessage = "Cannot divide by 0";
            String actualMessage = e.getMessage();
            assert (expectedMessage == actualMessage);
        }
    }
}

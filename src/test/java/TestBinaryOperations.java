import backend.BinaryOperations;
import org.junit.Test;


public class TestBinaryOperations {

    @Test
    public void TestBinaryAddition() {
        int[] x = {0b1000, 0b0, 0b101, 0b1101};
        int[] y = {0b101, 0b0};

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                int result = BinaryOperations.Add(x[i], j);
                int xDecimal = Integer.parseInt(x[i] + "");
                int yDecimal = Integer.parseInt(j + "");
                int sum = Integer.parseInt(Integer.toBinaryString(xDecimal + yDecimal), 2);
                assert (result == sum);
            }
        }
    }
    
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
    public void TestBinarySubtraction() {
        int product;
        int result = 2-2;
        int difference = BinaryOperations.Subtract(0b10, 0b10);
                assert(result == difference);
    }

    @Test
    public void TestBinarySubtraction_Negatives() {
        int product;
        int result = ((-4)-(-4));
        int IntA = BinaryOperations.Subtract(0b0, 0b100);
        int IntB = BinaryOperations.Subtract(0b0, 0b100);
        int difference = BinaryOperations.Subtract(IntA, IntB);
        assert(result == difference);
    }

    @Test
    public void TestBinarySubtraction_PartNegatives() {
        int product;
        int result = ((-4)-(4));
        int IntA = BinaryOperations.Subtract(0b0, 0b100);
        int difference = BinaryOperations.Subtract(IntA, 0b100);
        assert(result == difference);
    }

    public void TestBinaryDivision() {
        int x = 0b10110;
        int[] y = new int[]{ 0b1000, 0b101, 0b1101,  0b1011, 0b111111};

        for (int i = 0; i < y.length; i++) {
            int result = BinaryOperations.Divide(x, y[i]);
            int xDecimal = Integer.parseInt(x+"");
            int yDecimal = Integer.parseInt(y[i]+"");
            int quotient = Integer.parseInt(Integer.toBinaryString(xDecimal / yDecimal), 2);
            assert (result == quotient);
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

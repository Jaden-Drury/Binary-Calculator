public class BinaryOperations {


    /// Returns the value obtained from (A * B)
    public static int Multiply(int A, int B) {
        int a = A, b = B, result=0;
        while (b != 0) {
            if ((b & 01) != 0) {
                result = result + a;
            }
            a <<= 1;
            b >>= 1;
        }
        return result;
    }

    /// Returns the value obtained from (A / B)
    public static int Divide(int A, int B) {

        if (B == 0b0) {
            throw new ArithmeticException("Cannot divide by 0");
        }

        if (A == 1 << 31 && B == -1) {
            return (1 << 31) - 1;
        }

        int a = Math.abs(A), b = Math.abs(B), res = 0;

        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        return (A > 0) == (B > 0) ? res : -res;
    }

    /// Returns the value obtained by adding b1 to b2
    public static int Add(int A, int B) {
        int sum;
        sum = A + B;

        return sum;
    }

    /// Returns the value obtained by subtracting b2 from b1
    public static int Subtract(int A, int B) {
//        int difference;
//        difference = A - B;
//        return difference;
        int difference;
        //2's complement
        difference = A + (~B + 1);
        return difference;
    }

    /// Returns the decimal representation of the passed in number
    public int ToDecimal(byte number) {
        return 0;
    }

    /// Returns the binary representation of the passed in number
    public byte ToBinary(int number) {
        return 0;
    }
}

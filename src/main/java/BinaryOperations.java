public class BinaryOperations {


    /// Returns the value obtained by multiplying b1 and b2
    public byte Multiply(byte b1, byte b2) {
        return 0;
    }

    /// Returns the value obtained by dividing b2 into b1
    public byte Divide(byte b1, byte b2) {
        return 0;
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

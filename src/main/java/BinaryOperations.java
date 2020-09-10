public class BinaryOperations {

    private static String result;
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

    public static String sqrt(int firstNumber){
        result = String.valueOf(Math.sqrt(BinaryToDecimal(firstNumber)));
        return result;
    }

    public static String pow(int firstNumber){
        result = String.valueOf(Math.pow(BinaryToDecimal(firstNumber),2));
        return result;
    }
    /// Returns the decimal representation of the passed in number
    public static Integer BinaryToDecimal(int  bi) {
        String binStr = bi+"";
        Integer sum = 0;
        int len = binStr.length();
        for (int i=1; i<=len; i++){
            int number = Integer.parseInt(binStr.substring(i-1,i));
            sum += (int)Math.pow(2,len-i)*number;
        }
        return  sum;
    }

    /// Returns the binary representation of the passed in number
    public static String ToBinary(int num) {
        String binaryNum="";
        int [] arr=new int[32];
        int  v,j=0;
        if(num==0) {
            return binaryNum + "0";
        }
        for(int  i=31;i>=0;i--) {
            v=num&1;
            arr[i]=v;
            num=num>>1;
        }
        one:for(int i=0;i<32;i++) {
            if(arr[i]==0&&arr[i+1]!=0) {
                j=i+1;
                break one;
            }
        }
        for(int i=j;i<32;i++ ) {
            binaryNum=binaryNum+arr[i];
        }
        return binaryNum;
    }
}

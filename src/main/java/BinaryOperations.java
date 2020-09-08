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
    public byte Add(byte b1, byte b2) {
        return 0;
    }

    /// Returns the value obtained by subtracting b2 from b1
    public byte Subtract(byte b1, byte b2) {
        return 0;
    }

    /// Returns the decimal representation of the passed in number
    public static Integer ToDecimal(int  bi) {
        String binStr = bi+"";
        Integer sum = 0;
        int len = binStr.length();
        for (int i=1;i<=len;i++){
            int dt = Integer.parseInt(binStr.substring(i-1,i));
            sum+=(int)Math.pow(2,len-i)*dt;
        }
        return  sum;
    }

    /// Returns the binary representation of the passed in number
    public String ToBinary(int number) {
        String binaryNum="";
        int [] arr=new int[32];
        int  v,j=0;
        if(num==0)
            return binaryNum+"0";
        else{
            for(int  i=31;i>=0;i--)
            {
                v=num&1;
                arr[i]=v;
                num=num>>1;
            }
            one:for(int i=0;i<32;i++)
            {
                if(arr[i]==0&&arr[i+1]!=0)
                {
                    j=i+1;
                    break one;
                }
            }
            for(int i=j;i<32;i++ )
            {
                binaryNum=binaryNum+arr[i];
            }
            return binaryNum;
        }
    }
}

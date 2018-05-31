package algorithm;

public class GenerateVehicleNumber {
    public static String getNumber(long n){

        if(n>26*26*9999 || n < 1)
            return "Invalid Number.";
        String string = "KA51";

        int firstOne =  'A';
        if(n%(26*9999) == 0)
            firstOne += n/(26*9999) - 1;
        else
            firstOne += n/(26*9999);
        string+=((char)firstOne);

        n = n%(26*9999);
        int secondOne =  'A';
        if(n%(9999) == 0)
            secondOne += (n/(9999) == 0? 26:(n/9999)) - 1;
        else
            secondOne += n/(9999);

        string+=((char)secondOne);

        n= n%(9999) == 0 ? 9999:n%9999;

        if(n<1000)
            string +=0;
        if(n<100)
            string +=0;
        if(n<10)
            string +=0;
        string+=(n);


        return string;
    }

    static long returnSequenceNumber(String number) {
        long sequence = 0;
        char chars[] = number.toCharArray();
        sequence += ((int)chars[4]-(int)'A')*26*9999;
        sequence += ((int)chars[5]-(int)'A')*9999;
        char temp[] = new char[4];
        temp[0] = chars[6];
        temp[1] = chars[7];
        temp[2] = chars[8];
        temp[3] = chars[9];
        sequence += Integer.parseInt(new String(temp));
        return sequence;
    }

    public static void main(String args[]) {

        String currentNumber = "KA51AA0000";
        int nextCount = 0;

        System.out.println(getNumber(returnSequenceNumber(currentNumber) + nextCount));
    }
}

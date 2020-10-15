import java.util.Arrays;

public class Multiplication {

    public static long gradeSchoolAlgorithm(int num1, int num2) {
        char[] number1 = Integer.toString(num1).toCharArray();
        char[] number2 = Integer.toString(num2).toCharArray();
        int[] result = new int[number1.length + number2.length];
        for (int i = number2.length - 1; i >= 0; i--) {
            int temp = 0;
            for(int j=number1.length-1; j >=0; j--) {
                temp += result[i+j + 1];
                temp += (number1[j]-'0')*(number2[i]-'0');
                result[i+j + 1] = temp%10;
                temp /= 10;
            }
            //there is something wrong with the following currently (probably indexes!)
            int destPos = i;
            while(temp !=0 ) {
                temp += result[destPos];
                result[destPos] = temp%10;
                temp /= 10;
                destPos--;
            }
            System.out.println(Arrays.toString(result));
        }
        System.out.println(Arrays.toString(result));
        long finalResult = 0;
        for(int i=0;i<result.length;i++) {
            finalResult+=result[i]*Math.pow(10,result.length -1 - i);
            System.out.println(finalResult);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        System.out.println(gradeSchoolAlgorithm(100, 222));
        System.out.println(gradeSchoolAlgorithm(222,100));
        System.out.println(gradeSchoolAlgorithm(1664789, 999992342));
        System.out.println("The answer should be: "+(long)1664789*999992342);
    }

}

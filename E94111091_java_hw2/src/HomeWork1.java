import java.util.Scanner;
import java.math.BigInteger;

public class HomeWork1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfCases = scanner.nextInt();
        String[][] digitArray = new String[numberOfCases][3];
        
        for(int i = 0; i < numberOfCases; i++) {
            digitArray[i][0] = scanner.next();
            digitArray[i][1] = scanner.next();
        }
        
        for(int i = 0; i < numberOfCases; i++) {
            String[] num1Array = digitArray[i][0].split("\\.");
            String[] num2Array = digitArray[i][1].split("\\.");
            
            int intSum = Integer.parseInt(num1Array[0]) + Integer.parseInt(num2Array[0]);

            
            int num1DecimalLength = num1Array[1].length();
            int num2DecimalLength = num2Array[1].length();
            
            BigInteger decSum = new BigInteger("0");
            String decSumString = "";
            int targetLength = 0;
            
            targetLength = calculateLCM(num1DecimalLength, num2DecimalLength);
            decSum = new BigInteger(repeatString(num1Array[1], targetLength)).add(new BigInteger(repeatString(num2Array[1], targetLength)));

            
            if(String.valueOf(decSum).length() != targetLength) {
                decSum = decSum.add(BigInteger.ONE);
                decSumString = removeFirstDigit(decSum);
                intSum += 1;
            } else {
                decSumString = decSum.toString();
            }
            
            String newDecSum = findRepeatingPattern(decSumString);
            
            if(newDecSum.equals("9")) {
                intSum += 1;
                digitArray[i][2] = String.valueOf(intSum);
            } else {
                digitArray[i][2] = String.format(intSum + "." + newDecSum);
            }
        }
        
        for(int i = 0; i < numberOfCases; i++) {
            System.out.println(digitArray[i][2]);
        }
    }
    
    public static int calculateLCM(int num1, int num2) {
        int largerNum = Math.max(num1, num2);
        int lcm = largerNum;
        while (true) {
            if (lcm % num1 == 0 && lcm % num2 == 0) {
                break;
            }
            lcm += largerNum;
        }
        return lcm;
    }

    public static int calculateGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
    
    public static String repeatString(String str, int length) {
        StringBuilder sb = new StringBuilder(length);
        while (sb.length() < length) {
            sb.append(str);
        }
        return sb.toString().substring(0, length);
    }

    public static String findRepeatingPattern(String str) {
        int length = str.length();
        for (int i = 1; i <= length / 2; i++) {
            String pattern = str.substring(0, i);
            boolean isValid = true;
            for (int j = i; j < length; j += i) {
                int endIndex = Math.min(j + i, length);
                if (!pattern.equals(str.substring(j, endIndex))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return pattern;
            }
        }
        return str;
    }
    
    public static String removeFirstDigit(BigInteger bigInteger) {
        String str = bigInteger.toString();
        return str.substring(1);
    }
}





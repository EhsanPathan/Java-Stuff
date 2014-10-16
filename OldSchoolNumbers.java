import java.util.Scanner;
 
public class Number {
 public char sign;
 public String whole;
 public String fraction;
 public double n1;
 public double n2;
 
 public static void main(String[] args) {
 System.out.println("Input two number, decimal valued");
 Scanner kbd1 = new Scanner(System.in);
 Scanner kbd2 = new Scanner(System.in);
 
 double num1, num2;
 num1 = kbd1.nextDouble();
 num2 = kbd2.nextDouble();
 
 System.out.println("The 2 numbers accepted are: " + num1 + " and "
 + num2);
 
 Number n = new Number(num1);
 Number n2 = new Number(num2);
 Number n3 = n.add(n2);
 Number n4 = n.subtract(n2);
 // System.out.println(n3);
 }
 
 public Number(double n) {
 double n1;
 n1 = n;
 
 System.out.println("n1 = " + n1);
 whole = "";
 fraction = "";
 if (n1 >= 0)
 sign = '+';
 else
 sign = '-';
 
 n1 = Math.abs(n1);
 
 // CONVERT THE DOUBLE TO STRING
 String numString = new Double(n1).toString();
 
 int pos = numString.indexOf(".");
 System.out.println("Position number = " + pos);
 if (pos == -1)
 whole = numString;
 else {
 whole = numString.substring(0, pos);
 fraction = numString.substring(pos + 1);
 }
 
 System.out.println("sign: " + sign + "\n" + "whole: " + whole + "\n"
 + "fraction: " + fraction);
 
 // cosmetic break line
 System.out.println("\n");
 
 }
 
 Number add(Number rhs) {
 
 // adding whole numbers first
 String wholeString1 = whole + fraction;
 String wholeString2 = rhs.whole + rhs.fraction;
 String wholeSum = "";
 int len = wholeString1.length();
 int carry = 0;
 String sum = "";
 {
 for (int i = len - 1; i >= 0; i--) {
 char w1 = wholeString1.charAt(i);
 char w2 = wholeString2.charAt(i);
 
 int wholeTempSum = (w1 - 48) + (w2 - 48) + carry;
 carry = wholeTempSum / 10;
 int wholeSumDigit = wholeTempSum % 10;
 sum = (char) (wholeSumDigit + 48) + sum;
 }
 
 if (carry == 1)
 sum = '1' + sum;
 
 System.out.println("Adding whole numbers: " + wholeString1 + " + "
 + wholeString2 + " = " + sum);
 
 String fractString1 = fraction;
 String fractString2 = rhs.fraction;
 
 String fractSum = "";
 int fractLen = fractString1.length();
 int fractCarry = 0;
 String sum2 = "";
 
 for (int j = fractLen - 1; j >= 0; j--) {
 char f1 = fractString1.charAt(j);
 char f2 = fractString2.charAt(j);
 
 int fractTempSum = (f1 - 48) + (f2 - 48) + fractCarry;
 fractCarry = fractTempSum % 10;
 // System.out.println("fraction carry = " + fractCarry);
 int fractSumDigit = fractTempSum % 10;
 sum2 = (char) (fractSumDigit + 48) + sum2;
 }
 
 if (fractCarry == 1)
 sum2 = '1' + sum2;
 
 System.out.println("Adding fraction numbers: " + fractString1
 + " + " + fractString2 + " = " + sum2);
 // // Number totalSumwhole = sum;
 // // RHS = totalSum;
 
 int xlen = sum.length();
 int wlen = whole.length();
 
 System.out.println("fractString1: " + fractString1);
 
 System.out.println("Adding both numbers together: " + wholeString1
 + " + " + wholeString2 + " = " + sum + "\n");
 
 if (fractString1 == "0") {
 System.out.println("Adding both numbers together: " + whole
 + "." + fraction + " + " + rhs.whole + "."
 + rhs.fraction + " = " + sum + "\n");
 
 } else {
 if (wlen > 1) {
 System.out.println("Adding both numbers together: " + whole
 + "." + fraction + " + " + rhs.whole + "."
 + rhs.fraction + " = " + sum.substring(0, wlen)
 + "." + sum.substring(wlen) + "\n");
 } else {
 System.out.println("Adding both numbers together: " + whole
 + "." + fraction + " + " + rhs.whole + "."
 + rhs.fraction + " = " + sum.substring(0, wlen + 1)
 + "." + sum.substring(wlen + 1) + "\n");
 }
 }
 return null;
 }
 
 }
 
 Number subtract(Number rhs) {
 
 // subtracting whole numbers first
 String wholeString1 = whole;
 String wholeString2 = rhs.whole;
 String wholeSum = "";
 int len = wholeString1.length();
 int carry = 0;
 String sum = "";
 
 {
 for (int i = len - 1; i >= 0; i--) {
 char w1 = wholeString1.charAt(i);
 char w2 = wholeString2.charAt(i);
 // picking bigger number to subtract the lower one (add negative
 // sign counter?)
 if (w1 > w2) {
 int wholeTempSum = (w1 - 48) - (w2 - 48) + carry;
 int wholeSumDigit = wholeTempSum % 10;
 sum = (char) (wholeSumDigit + 48) + sum;
 } else {
 int wholeTempSum = (w2 - 48) - (w1 - 48) + carry;
 int wholeSumDigit = wholeTempSum % 10;
 sum = (char) (wholeSumDigit + 48) + sum;
 }
 }
 
 if (carry == 1)
 sum = '1' + sum;
 
 System.out.println("Subtracting whole numbers: " + wholeString1
 + " - " + wholeString2 + " = " + sum);
 
 String fractString1 = fraction;
 String fractString2 = rhs.fraction;
 
 String fractSum = "";
 int fractLen = fractString1.length();
 int fractCarry = 0;
 String sum2 = "";
 
 for (int j = fractLen - 1; j >= 0; j--) {
 char f1 = fractString1.charAt(j);
 char f2 = fractString2.charAt(j);
 
 if (f1 > f2) {
 int fractTempSum = (f1 - 48) - (f2 - 48) + fractCarry;
 int fractSumDigit = fractTempSum % 10;
 sum2 = (char) (fractSumDigit + 48) + sum2;
 } else {
 int fractTempSum = (f2 - 48) - (f1 - 48) + fractCarry;
 int fractSumDigit = fractTempSum % 10;
 sum2 = (char) (fractSumDigit + 48) + sum2;
 }
 }
 
 if (fractCarry == 1)
 sum2 = '1' + sum2;
 
 System.out.println("Subtracting fraction numbers: " + fractString1
 + " - " + fractString2 + " = " + sum2);
 
 // Number totalSumwhole = sum;
 // RHS = totalSum;
 System.out.println("Subtracting both numbers together: "
 + wholeString1 + "." + fractString1 + " - " + wholeString2
 + "." + fractString2 + " = " + sum + "." + sum2);
 }
 
 return null;
 
 // System.out.println(RHS);
 // System.out.println("Adding both numbers together: " + n1 + " + " + n2
 // + " = " + sum + "." + sum2);
 }
 
}

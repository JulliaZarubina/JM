package com.company;


import java.io.IOException;
import java.util.Scanner;

public class JM {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите выражение");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] calc = str.split(" ");
        char operator = calc[1].charAt(0);
        Str s1 = new Str();
        int[] numbers = s1.check(calc);
        Calculator cl = new Calculator();
        int result = cl.calculate(numbers[0], numbers[1], operator);
        if (result > 0) {
            String result3 = s1.IfRome(result);
        } else {
            System.out.println("Неверно введено значение");
        }

    }
}

class Str {

    boolean rr = false;
    boolean rr1 = false;

    int[] check(String[] calc) throws IOException {
        int a = 0;
        int b = 0;
        String[] arab = new String[]{"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] rome = new String[]{"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};


        boolean ar = false;
        boolean ar1 = false;

        for (int i = 0; i < rome.length; i++) {

            if (rome[i].equals(calc[0])) {
                rr = true;
            }

            if (rome[i].equals(calc[2])) {
                rr1 = true;
            }
        }

        if (rr && rr1) {
            a = romeToNum(calc[0]);
            b = romeToNum(calc[2]);
            return new int[]{a, b};

        } else {
            for (int i = 0; i < arab.length; i++) {
                if (arab[i].equals(calc[0])) {
                    ar = true;
                }
                if (arab[i].equals(calc[2])) {
                    ar1 = true;
                }
            }
            if (ar && ar1) {
                a = Integer.parseInt(calc[0]);
                b = Integer.parseInt(calc[2]);
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Неверно введено значение");
                }
            }
        }

        return new int[]{a, b};

    }


    int romeToNum(String rome) {
        if (rome.equals("I")) {
            return 1;
        } else if (rome.equals("II")) {
            return 2;
        } else if (rome.equals("III")) {
            return 3;
        } else if (rome.equals("IV")) {
            return 4;
        } else if (rome.equals("V")) {
            return 5;
        } else if (rome.equals("VI")) {
            return 6;
        } else if (rome.equals("VII")) {
            return 7;
        } else if (rome.equals("VIII")) {
            return 8;
        } else if (rome.equals("IX")) {
            return 9;
        } else if (rome.equals("X")) {
            return 10;
        } else {
            return -1;

        }
    }

    String numToRome(int result) {
        int a, b = 0;
        String aa, bb;
        if (result > 10) {
            a = result / 10;
            b = result % 10;
            if (a == 1) {
                aa = "X";
            } else if (a == 2) {
                aa = "XX";
            } else {
                aa = "0";
            }
            if (b == 0) {
                bb = " ";
            } else if (b == 1) {
                bb = "I";
            } else if (b == 2) {
                bb = "II";
            } else if (b == 3) {
                bb = "III";
            } else if (b == 4) {
                bb = "IV";
            } else if (b == 5) {
                bb = "V";
            } else if (b == 6) {
                bb = "VI";
            } else if (b == 7) {
                bb = "VII";
            } else if (b == 8) {
                bb = "VIII";
            } else if (b == 9) {
                bb = "IX";
            } else if (b == 10) {
                bb = "X";
            } else {
                bb = "0";
            }
            String resultAr = (aa + bb);
            return resultAr;
        } else {
            a = result;
            if (a == 1) {
                aa = "I";
            } else if (a == 2) {
                aa = "II";
            } else if (a == 3) {
                aa = "III";
            } else if (a == 4) {
                aa = "IV";
            } else if (a == 5) {
                aa = "V";
            } else if (a == 6) {
                aa = "VI";
            } else if (a == 7) {
                aa = "VII";
            } else if (a == 8) {
                aa = "VIII";
            } else if (a == 9) {
                aa = "IX";
            } else if (a == 10) {
                aa = "X";
            } else {
                aa = "0";
            }
            String resultAr = (aa);
            return resultAr;
        }


    }

    String IfRome(int result) {
        if (rr && rr1) {
            String result1 = numToRome(result);
            System.out.println(result1);
        } else {
            System.out.println(result);
        }
        return null;
    }

}



 class Calculator {
    int calculate(int a, int b, char operator) throws IOException {
        int result = 0;
        if ((a > 10 || a < 0) || (b > 10 || b < 0)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Неверно введено значение");
            }
        }
        else {

            switch (operator) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
                default:
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Неверно введено значение");
                    }
            }
        }
            return result;


    }
}












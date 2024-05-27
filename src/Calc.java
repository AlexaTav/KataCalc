

import java.util.Scanner;

   class Calc {

       public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);
           System.out.println("Введите два числа");
           String expression = sc.nextLine();
           System.out.println(calc(expression));

       }

       public static String calc(String expression) throws Exception {
           int num1;
           int num2;
           String oper;
           String result;
           boolean isRoman;
           String[] operands = expression.split("[+\\-*/]");
           if (operands.length != 2) {
               throw new Exception("Должно быть два операнда");
           }
           oper = detectOperation(expression);
           if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
               num1 = Roman.convertToArabian(operands[0]);
               num2 = Roman.convertToArabian(operands[1]);
               isRoman = true;
           } else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
               num1 = Integer.parseInt(operands[0]);
               num2 = Integer.parseInt(operands[1]);
               isRoman = false;
           } else {
               throw new Exception("Числа должны быть одного формата");
           }
           if (num1 > 10 || num2 > 10) {
               throw new Exception("Числа должны быть меньше 10");
           }
           int arabian = calculated(num1, num2, oper);
           if (isRoman) {
               if (arabian <= 0) {
                   throw new Exception("Римское число должно быть больше 0");
               }
               result = Roman.convertToRoman(arabian);
           } else {
               result = String.valueOf(arabian);
           }
           return result;
       }

       static String detectOperation(String expression) {
           if (expression.contains("+")) return "+";
           else if (expression.contains("-")) return "-";
           else if (expression.contains("/")) return "/";
           else if (expression.contains("*")) return "*";
           else return null;
       }

       static int calculated(int a, int b, String oper) {
           if (oper.equals("+")) return a + b;
           else if (oper.equals("-")) return a - b;
           else if (oper.equals("/")) return a / b;
           else return a * b;
       }

   }
    class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        public static boolean isRoman (String val){
        for (int i=0; i< romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
        }
        public static int convertToArabian(String roman){
        for (int i=0; i< romanArray.length; i++){
            if (roman.equals(romanArray[i])){
                return i;
            }
        }
        return -1;
        }
        public static String convertToRoman(int arabian){

        return romanArray[arabian];
        }

        }




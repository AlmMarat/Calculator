import java.util.Scanner;

class Calc {
    static Scanner sc = new Scanner(System.in);
    static int num1, num2;
    static int result;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение с числами от 1 до 10 или от I до X (Пример 2 + 2 или X - IV):");
        String[] input = sc.nextLine().split(" ");
        if(input.length > 3) {
            throw new Exception("Не более 2 операндов и 1 знака операции");
        }

        if(input[0].equals("I") || input[0].equals("II") || input[0].equals("III") || input[0].equals("IV") || input[0].equals("V") || input[0].equals("VI") || input[0].equals("VII") || input[0].equals("VIII") ||
                input[0].equals("IX") || input[0].equals("X") && input[2].equals("I") || input[2].equals("II") || input[2].equals("III") || input[2].equals("IV") || input[2].equals("V") || input[2].equals("VI") ||
                input[2].equals("VII") || input[2].equals("VIII") || input[2].equals("IX") || input[2].equals("X")) {
            num1 = convertRomanToArab(input[0]);
            num2 = convertRomanToArab(input[2]);

            if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10) {
                result = calculated(num1, num2, input[1]);
                if(result > 0) {
                    String resultRomanNum = convertArabToRoman(result);
                    System.out.println(resultRomanNum);
                } else {
                    throw new Exception("Результат не может быть меньше 1");
                }
            } else {
                throw new Exception("Римские цифры не могут быть нулём и отрицательными");
            }
        } else {
            num1 = Integer.parseInt(input[0]);
            num2 = Integer.parseInt(input[2]);
            if(num1 <= 10 && num1 > 0 && num2 <= 10 && num2 > 0) {
                result = calculated(num1, num2, input[1]);
                System.out.println(result);
            } else {
                throw new Exception("Вводить нужно только от 1 до 10 включительно!");
            }
        }
    }

    private static int convertRomanToArab(String inp) throws Exception {
        if(inp.equals("I") || inp.equals("II") || inp.equals("III") || inp.equals("IV") || inp.equals("V") || inp.equals("VI") || inp.equals("VII") || inp.equals("VIII") ||
                inp.equals("IX") || inp.equals("X")) {
            switch (inp) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
                }
            } else {
            throw new Exception("Не верный ввод числа");
        }
       return 0;
    }

    private static String convertArabToRoman(int ArabNum) {
        int[] arabNum_list = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNum_list = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < arabNum_list.length; i += 1) {
            while (ArabNum >= arabNum_list[i]) {
                ArabNum = ArabNum - arabNum_list[i];
                res.append(romanNum_list[i]);
            }
        }
        return res.toString();
    }

    public static int calculated(int number1, int number2, String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                try {
                    result = number1 / number2;
                } catch (ArithmeticException e) {
                    throw new ArithmeticException("Нельзя делить на 0");
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции: " + operation);
        }
        return result;
    }
}

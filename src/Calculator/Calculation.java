package Calculator;

class Calculation {

    private Calculation(){}

    public static long factorial(long n) {
        if (n <= 14 && n >= 0) {
            long result = 1;
            if (n == 1 || n == 0) {
                return result;
            }
            result = n * factorial(n - 1);
            return result;
        }
        return -1;
    }

    public static double plus(double op1, double op2) {
        return op1 + op2;
    }

    public static double minus(double op1, double op2) {
        return op1 - op2;
    }

    public static double divide(double first_divisor, double second_divisor) {
        if (second_divisor != 0) {
            double res;
            res = first_divisor / second_divisor;
            if (Double.toString(res).length() > 10) {
                res = format(res);
            }
            return res;
        } else {
            return -1;
        }
    }


    public static double multiply(double m1, double m2) {

        double res = m1 * m2;
        if (Double.toString(res).length() > 10) {
            res = format(res);
        }
        return res;
    }

    public static double negateExact(double a) {

        if (a <= 0) {
            return a;
        } else {
            return -a;
        }
    }

    public static double percentage(double radicalNum, double percentNum) {
        if (percentNum >= 0) {
            return divide(multiply(radicalNum, percentNum), 100);
        }
        return -1;
    }

    private static double format(double num){
        return Double.parseDouble(Double.toString(num).substring(0, 11));
    }

}

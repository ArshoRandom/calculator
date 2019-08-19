package Calculator;


class Calculation {

    long factorial(long n) {
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

    double plus(double op1, double op2) {
        return op1 + op2;
    }

    double minus(double op1, double op2) {
        return op1 - op2;
    }

    double divide(double divisor1, double divisor2) {
        if (divisor2 != 0) {
            double res;
            res = divisor1 / divisor2;
            if (Double.toString(res).length() > 10) {
                res = Double.parseDouble(Double.toString(res).substring(0, 11));
            }
            return res;
        } else {

            return -1;
        }
    }


    double multiply(double m1, double m2) {

        double res = m1 * m2;
        if (Double.toString(res).length() > 10) {
            res = Double.parseDouble(Double.toString(res).substring(0, 11));
        }
        return res;
    }

    double negateExact(double a) {

        if (a <= 0) {
            return a;
        } else {
            return -a;
        }
    }

    double percentage(double radicalNum, double percentNum) {

        if (percentNum >= 0) {
            return divide(multiply(radicalNum, percentNum), 100);
        }
        return -1;
    }
}

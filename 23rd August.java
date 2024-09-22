class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public String fractionAddition(String expression) {
        int n = expression.length();
        int num1 = 0;
        int den1 = 1;
        int num2 = 0;
        int den2 = 1;
        int sign = 1;
        for (int i=0; i<n; i++) {
            char ch = expression.charAt(i);
            if (ch == '-') {
                sign = 0;
            }
            else if (ch == '+') {
                sign = 1;
            }
            else if(ch >= '0' && ch <= '9') {
                num2 = ch - '0';
                if (expression.charAt(i+1) == '0') {
                    num2 = 10;
                    i++;
                }

                den2 = expression.charAt(i+2) - '0';
                if (i+3<n && expression.charAt(i+3)=='0') {
                    den2 = 10;
                    i++;
                }
                i+=2;
                if (sign == 0) {
                    num1 = (num1 * den2) - (num2 * den1);
                    den1 = den1 * den2;
                }
                if (sign == 1) {
                    num1 = (num1 * den2) + (num2 * den1);
                    den1 = den1 * den2;
                }
                if (num1 % den1 == 0) {
                    num1 = num1/den1;
                    den1 = 1;
                }
                // System.out.println("num1: "+num1);
                // System.out.println("den1: "+den1);
            }
        }
        int g = Math.abs(gcd(num1, den1));
        // System.out.println("gcd: "+g);
        num1 /= g;
        den1 /= g;
        StringBuilder str = new StringBuilder();
        str.append(num1);
        str.append("/");
        str.append(den1);
        return str.toString();
    }

    
}

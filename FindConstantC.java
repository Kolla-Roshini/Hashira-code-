import java.math.BigInteger;
import java.util.*;

public class FindConstantC {
    public static void main(String[] args) {
        // ------------ Test Case 1 ------------
        String[][] testCase1 = {
            {"10", "4"},
            {"2",  "111"},
            {"10", "12"},
            {"4",  "213"}  // Not used (only k = 3 roots needed)
        };
        int k1 = 3;

        // ------------ Test Case 2 ------------
        String[][] testCase2 = {
            {"6",  "13444211440455345511"},
            {"15", "aed7015a346d635"},
            {"15", "6aeeb69631c227c"},
            {"16", "e1b5e05623d881f"},
            {"8",  "316034514573652620673"},
            {"3",  "2122212201122002221120200210011020220200"},
            {"3",  "20120221122211000100210021102001201112121"},
            {"6",  "20220554335330240002224253"},
            {"12", "45153788322a1255483"},
            {"7",  "1101613130313526312514143"}
        };
        int k2 = 7;

        // Process both test cases
        BigInteger c1 = computeConstantC(testCase1, k1);
        BigInteger c2 = computeConstantC(testCase2, k2);

        // Output only C values
        System.out.println("Test Case 1 - Constant C: " + c1);
        System.out.println("Test Case 2 - Constant C: " + c2);
    }

    /**
     * Computes the constant term C of a polynomial from roots:
     * (x - r1)(x - r2)...(x - rk) = Ax^k + ... + C
     * C = (-1)^k * (r1 * r2 * ... * rk)
     */
    private static BigInteger computeConstantC(String[][] rootData, int k) {
        BigInteger product = BigInteger.ONE;

        for (int i = 0; i < k; i++) {
            int base = Integer.parseInt(rootData[i][0]);
            String value = rootData[i][1];

            BigInteger root = new BigInteger(value, base);
            product = product.multiply(root);
        }

        // Apply sign: (-1)^k
        if (k % 2 != 0) {
            product = product.negate();
        }

        return product;
    }
}
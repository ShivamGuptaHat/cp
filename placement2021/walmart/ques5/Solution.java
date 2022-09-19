package placement2021.walmart.ques5;

import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        while(t-- > 0){
            String num = in.nextLine();
            boolean ans = solve(num);
            System.out.println(ans ? "YES" : "NO");
        }
    }

    public static boolean solve(String s){
        for (int i = 0; i < s.length() - 1; i += 2){
            int a = s.charAt(i) - '0';
            int b = s.charAt(i + 1) - '0';
            if(a + b <=  17) return false;
        }
        return true;
    }

    public static int solve(int n, int[] C, int[] W){
        int total = 0;
        for (int i = 0; i < n; i++){
            total += W[i];
        }

        int[][] M = new int[n][2];
        for (int i = 0; i < n; i++){
            M[i][0] = C[i];
            M[i][1] = W[i];
        }

        Arrays.sort(M, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        for (int i = n - 1; i >= 0 && total > 0; i--){
            total -= M[i][1];
            int temp = M[i][0] - M[i][1];
            total -= temp;
            ans++;
        }

        return ans;
    }
}

package RangeQueries.sparse_table;

/*
LOG = log(n) + 1
 */



/*

st[i][j] = minimum value in the range of [i, i + 2^j - 1]


 */


public class Solution {
    static int[][] st;
    static int LOG = 17, N;

    public static void init(int[] nums){
        N = nums.length;
        st = new int[N][LOG];
        for (int i = 0; i < N; i++){
            st[i][0] = nums[i];
        }

        for (int j = 1; j < LOG; j++){
            for (int i = 0;  i + (1 << (j - 1)) < N; i++){
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public static int query(int L, int R){
        int len = R - L + 1;
        int k = (int)(Math.log(len) / Math.log(2));
        return Math.min(st[L][k], st[R - (1 << k) + 1][k]);
    }
}

// min, max, gcd, AND

// requires idempotent property
// A op A = A

//No updation allowed
//O(nlogn) => creation time
//O(1) => query time

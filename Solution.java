
import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] A= {1,2,1,2,3,1};
        int s = 3;
        System.out.println(new Solution().taskSchedulerII(A, s));
    }

    public long taskSchedulerII(int[] tasks, int space) {
        Map<Long, Long> map = new HashMap<>();
        long day = 1l;
        int n = tasks.length;
        for (int i = 0; i < n; i++){
            long pre = map.getOrDefault((long)tasks[i], - 1l);
            if(pre == -1){
                day++;
                map.put((long)tasks[i], day + space);
            }else{
                if(pre < day){
                    day++;
                    map.put((long)tasks[i], day + space);
                }else{
                    day = pre + 1;
                    map.put((long)tasks[i], day + space);
                }
            }

        }
        return day - 1;

    }
}
import java.util.*;

public class PlacementMarathon {

    
    public int longestSubseq(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int num : arr) {
int prev = map.getOrDefault(num - k, 0);
int currLength = prev + 1;

            map.put(num, currLength);

            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }

  
}
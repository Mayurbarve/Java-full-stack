import java.util.*;


public class NextGreaterElement {
    // First Approch
    public void nextGrater(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[n];

        for (int i = 0; i < m; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < n; i++) {
            int currNum = nums1[i];
            int nextGrater2 = map.get(currNum);
            int graterNum = -1;
            for (int j = nextGrater2 + 1; j < m; j++) {
                if (nums2[j] > nextGrater2) {
                    graterNum = nums2[j];
                    break;
                }
            }
            result[i] = graterNum;
        }

        System.out.println(Arrays.toString(result));
    }


    // Second Approch
    public void nextGreater(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer currNum : nums1) {
            int index = nums2.indexOf(currNum);
            int greaterNum = -1;

            for (int j = index + 1; j < nums2.size(); j++) {
                if (nums2.get(j) > currNum) {
                    greaterNum = nums2.get(j);
                    break;
                }
            }

            result.add(greaterNum);
        }

        System.out.println(result);
    }
}

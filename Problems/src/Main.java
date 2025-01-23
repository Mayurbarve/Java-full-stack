import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        ArrayList<Integer> nums3 = new ArrayList<>(Arrays.asList(4, 1, 2));
        ArrayList<Integer> nums4 = new ArrayList<>(Arrays.asList(1, 3, 4, 2));

        //Next Grater Element LeetCode 496
        new NextGreaterElement().nextGrater(nums1, nums2);
        new NextGreaterElement().nextGreater(nums3, nums4);

        //Generic Class Example Find Power
        GenericClass<Double, Integer> genClass = new GenericClass<>(2.5, 2);
        System.out.println("Power: " + genClass.calculatePower());


        //Problem A
        ParenthesesChaeck obj = new ParenthesesChaeck();
        String str = "({{[]}})[]";
        System.out.println(obj.strFormat(str));
    

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListAddDelete {
    public static ArrayList<Integer> insertion(ArrayList<Integer> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insertion");
        int insertIndex = sc.nextInt();
        int insertVal = sc.nextInt();
        list.add(insertIndex, insertVal);

        System.out.println("Deletion");
        int deleteIndex = sc.nextInt();
        list.remove(deleteIndex);
        sc.close();

        return list;
    }

    public static void main(String[] args) {
        Integer[] arr = {12, 0, 1, 78, 12};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(insertion(list));
    }
}
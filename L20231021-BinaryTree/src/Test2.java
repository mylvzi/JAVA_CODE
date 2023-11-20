import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-24
 * Time: 20:27
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] sub = new int[n];
        sub[0] = scan.nextInt();

        for (int i = 1; i < n; i++) {
            sub[i] = sub[i] - sub[i-1];
        }

        Arrays.sort(sub);

        int sum = 0;
        for (int i = 0; i < n-k; i++) {
            sum += sub[i];
        }
        System.out.println(sum);

        scan.close();
















        //在此输入您的代码...
//        Scanner scan = new Scanner(System.in);
//        //在此输入您的代码...
//        int t = scan.nextInt();
//        scan.nextLine();
//
//        while(t > 0) {
//            String input = scan.nextLine();
//            String[] numbers = input.split(" ");
//            int x = Integer.parseInt(numbers[0]);
//            int y = Integer.parseInt(numbers[1]);
//
//            String res = "Yes";
//
//            if(x < 2 || y < 3) res = "No";
//
//            if((x*y) % 6 != 0) res = "No";
//
//            System.out.println(res);
//            t--;
//
//        }
//
//
//        scan.close();
    }
}

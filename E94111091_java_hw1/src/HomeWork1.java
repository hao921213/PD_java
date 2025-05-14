import java.util.Scanner;
import java.math.BigDecimal;

public class HomeWork1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        while (input.hasNextLine()) {//檢查是否有下一行
            String line = input.nextLine();
            if (line.isEmpty()) {
                break; //如果輸入為空則退出循環
            }
            String[] nums = line.split("\\s+");
            BigDecimal d1 = new BigDecimal(nums[0]);
            BigDecimal d2 = new BigDecimal(nums[1]);
            BigDecimal result = d1.add(d2);
            System.out.println( result);
        }
        
        input.close();
    }
}


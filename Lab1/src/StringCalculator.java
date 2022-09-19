import java.util.Scanner;
public class StringCalculator {
    public int add(String numbers) {
        int sum = 0;
        boolean has_negatives = false;
        String split_delimiters = "\\\\n|";
        String special_symbols = "()[]{}|^*$+.?";
        if(numbers.charAt(0) == '/' && numbers.charAt(1) == '/' && numbers.contains("\\n")){
            int pos = numbers.indexOf("\\n");
            if(pos == 3){
                if(special_symbols.contains(String.valueOf(numbers.charAt(2)))){
                    split_delimiters += "\\";
                }
                split_delimiters += numbers.charAt(2);
                numbers = numbers.substring(5);
            }
            else{
                String delimiters_together = numbers.substring(3,pos-1);
                String[] delimiters = delimiters_together.split("]\\[");
                boolean flag = false;
                for(String delim : delimiters){
                    if(flag){
                        split_delimiters += "|";
                    }
                    else{
                        flag = true;
                    }
                    for(char c : delim.toCharArray()){
                        if(special_symbols.contains(String.valueOf(c))){
                            split_delimiters += "\\" + c;
                        }
                        else{
                            split_delimiters += c;
                        }
                    }

                }
                numbers = numbers.substring(numbers.indexOf("\\n")+2);
            }

        }
        else{
            split_delimiters += ",";
        }
        String[] nums = numbers.split(split_delimiters);
        for (String num : nums) {
         //   if(num.isEmpty()){
        //        return -1;
        //    }
            int num_int;
            try{
                num_int = Integer.parseInt(num);
            }
            catch(Exception e){
                return -1;
            }
            if(num_int<=1000) sum += num_int;
            if(num_int < 0){
                if(!has_negatives){
                    System.out.println("Invalid input data. Negative numbers are not allowed. The list of negative numbers:");
                    has_negatives = true;
                }
                System.out.println(num_int);
            }

        }
        if(!has_negatives){
            return sum;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Print your string: ");

        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();

        StringCalculator sc = new StringCalculator();
        int sum = sc.add(in);

        if(sum == -1){
            System.out.println("Invalid input data");
        }
        else{
            System.out.println("Sum equals: " + sum);
        }
    }

}
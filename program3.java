import java.util.Scanner;

public class program3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Str = input.next();   
        
        System.out.print(palindrom(Str.toLowerCase()));
    }
        public static boolean palindrom (String user_string){
            boolean flag = true;
            for (int i = 0; i < user_string.length() / 2; i++) {
                if (user_string.charAt(i) != user_string.charAt(user_string.length()-1-i)){
                    flag = false;
                    break;
                } 
            }
            return flag;
    }

    
}

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class program1 {
    public static void main(String[] args) {
    /*     Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации запишите в лог-файл. */
        Scanner iScanner = new Scanner(System.in);
        
        File file = new File("log.txt");
        try{
            FileWriter writer = new FileWriter (file, false);
            writer.close();
        }
        catch (Exception e){
            System.out.println("Error!");
        }

        System.out.print("Задайте величину массива: ");
        int n = iScanner.nextInt();

        int[] arr = new int[n];
        arr_input(arr);
        
        int f = 1;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length-j-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    f = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = f;
                }
            }
            try{
                FileWriter writer = new FileWriter (file, true);
                for (int h = 0; h < arr.length; h++) {
                    String s = Integer.toString(arr[h]);
                    writer.write(s);
                    writer.write(" ");
                }
                writer.write("\n");
                writer.close();
            }
            catch (Exception e){
                System.out.println("Error!");
            }
        }
        arr_output(arr);
    }

    public static void arr_input(int[] arr) {
        Scanner iScanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Введите %d-e число: ", i);
            arr[i] = iScanner.nextInt();
        }
    }

    public static void arr_output(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
            }
        System.out.println(" ");
    }
}

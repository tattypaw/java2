import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class program2 {
    public static void main(String[] args) {
    /*     Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */
        
        String file_name = "results.txt";
        StringBuilder text = new StringBuilder();

        try(FileReader reader = new FileReader(file_name))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){
                 
                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                text.append(buf);
            } 
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        String Text = text.toString();
        String[] words = Text.split("\n");
        String Temp = "";        
        for(String word : words){
            String[] keys = word.split(",");
            Temp = student_str(word);
            if (Temp.indexOf('"') != -1) {
                Temp = Temp.substring(0, Temp.length()-1);
            }
                Temp += '.';
            System.out.println(Temp);
            Temp = "";  
        }

    }
    public static String student_str (String enter_string){
        String[] keys = enter_string.split(",");
        String[] test = {"Студент ", " получил ", " по предмету "};
        StringBuilder result = new StringBuilder();
        int index = 0;
        int i = 0;
        for(String key: keys){
            index = key.indexOf(":");
            result.append(test[i]);
            result.append(key.substring(index+2, key.length()-1));
            i++;
        }
        return result.toString();
        }
}

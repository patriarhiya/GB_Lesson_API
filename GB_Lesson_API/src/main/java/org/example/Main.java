package org.example;
import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 4, 8, 3, 1};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        try {
            ans.sort(arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Answer {
    public int countNTriangle(int n){
        // Введите свое решение ниже
        int m = 0;
        if (n < 1) {
            return -1;
        } else {
            for (int i = 1; i <= n; i++) {
                m += i;
            }
            return m;
        }
    }
    public void printPrimeNums(){
        // Напишите свое решение ниже
        System.out.println(2);
        for (int i = 3; i < 999; i++) {
            if (i % 2 != 0) {
                int count = 0;
                while (count < 2){
                    for (int j = 3; j < i + 1; j++) {
                        if (i % j == 0) count++;
                    }
                if (count == 1) System.out.println(i);
                }
            }
        }
    }
    public static StringBuilder answer(String QUERY, String PARAMS){
        StringBuilder sb = new StringBuilder(QUERY);
        PARAMS = PARAMS.substring(2, PARAMS.length() - 3);
        PARAMS = PARAMS.replace(':','=');
        PARAMS = PARAMS.replace('"', '\u0020');


        String[] strArr = PARAMS.split(" , ");
        for (int i = 0; i < strArr.length; i++) {
            String[] strOne = strArr[i].split(" = ");
            if (!strOne[1].equals("null")) {
                if (i > 0) sb.append(" and");
                sb.append(strOne[0]);
                sb.append("='");
                sb.append(strOne[1]);
                sb.append("'");
            }
            //if (i > 0) sb.append("and");
            //sb.append(strArr[i]);
        }
        return sb;
        // Напишите свое решение ниже

    }

}
class Calculator {
    public int calculate(char op, int a, int b) {
        // Введите свое решение ниже
        if (op == '+') {return a + b;}
        if (op == '-') {return a - b;}
        if (op == '/') {
            if (b != 0) {
                return a / b;
            } else {
                return -1;
            }
        }
        if (op == '*') {return a * b;}
        else {
            return -2;
        }
    }
}
class FileSystemDemo {
    public void fileSystemPath() {
        String pathProject = System.getProperty("src/test.dir");
        String pathFile = pathProject.concat("/file.txt");
        File f3 = new File(pathFile);
        System.out.println(f3.getAbsolutePath());
        // /Users/sk/vscode/java_projects/file.txt
        // C:/Users/Sk/Documents/xxx/brainexplosion/java/file.txt
    }
}
class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) throws IOException {
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }
            }
        }
        //System.out.println(Arrays.toString(mas));

        Logger logger = Logger.getLogger("MyLog");
        try {
            FileHandler fh = new FileHandler("log.txt", true);
            logger.setUseParentHandlers(false);
            logger.addHandler(fh);

            fh.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    LocalDateTime now = LocalDateTime.now();
                    Object DateTimeFormatter = now.format();
                    String format = now.format(DateTimeFormatter.ISO_DATE_TIME1);
                    String s = String.valueOf(LocalDate.now() + " " + hourNow + "\n");
                    return s;
                }
            });
            logger.info(String.valueOf(LocalDateTime.now()));


        } catch (SecurityException | IOException e) {
            logger.log(Level.SEVERE, "Произошла ошибка при работе с FileHandler.", e);
        }
    }

}
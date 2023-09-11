import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sit2 {
    public static void main(String[] args) {
        try {
            String str;
            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\tasklist.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int proc = 0;
            String firstProcess = null; // Переменная для хранения информации о первом процессе

            while ((str = input.readLine()) != null) {
                proc++;
                if (proc == 4) {
                    firstProcess = str; // Сохраняем информацию о первом процессе
                }
                System.out.println(str);

            }
            input.close();

            // Выводим информацию о первом процессе
            System.out.println("\nПервый стартовавший процесс:");
            System.out.println(firstProcess);

        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}


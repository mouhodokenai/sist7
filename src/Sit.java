import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sit {
    public static void main(String[] args) {
        List<Integer> processPIDs = getAllProcessPIDs();

        Collections.sort(processPIDs);

        for (int pid : processPIDs) {
            System.out.println("PID: " + pid);
        }
    }

    public static List<Integer> getAllProcessPIDs() {
        List<Integer> processPIDs = new ArrayList<>();

        try {

            Process process = new ProcessBuilder("jps").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println("список PIDов");
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" ");
                if (parts.length >= 1) {
                    try {
                        int pid = Integer.parseInt(parts[0]);
                        processPIDs.add(pid);
                    } catch (NumberFormatException e) {

                    }
                }
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return processPIDs;
    }
}
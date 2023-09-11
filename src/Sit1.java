public class Sit1 {
    public static void main(String[] args) {
       while (true) {
           try {
               ProcessBuilder proc = new ProcessBuilder("notepad.exe");
               proc.start();
               Thread.sleep(10000);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
}

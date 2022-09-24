import java.io.*;
public class Main {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("C:\\Users\\Юзер\\IdeaProjects\\project_\\src\\in.txt");
             FileOutputStream os = new FileOutputStream("C:\\Users\\Юзер\\IdeaProjects\\project_\\src\\out.txt")) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer, 0, buffer.length);
            os.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
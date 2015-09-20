package prjct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class testApp {
    public static void main(String[] args) throws Exception {
        long lastOut = System.currentTimeMillis();
        File file = new File("test.txt");

        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(
                    new FileOutputStream("test.txt"));
            Scanner sc=new Scanner(System.in);
            String s = sc.next();
            
            while (true) {
                out.writeUnshared(new lObj());
                if ((System.currentTimeMillis() - lastOut) > 3452) {
                    lastOut = System.currentTimeMillis();
                    System.out.println("Buffer " + file.length());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



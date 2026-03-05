import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String... args)  {
        File copyFile = new File("copyfile.txt");

        try{
            FileReader copyFileReader = new FileReader(copyFile);
            System.out.println(copyFileReader.readAllAsString());
            System.out.println("Dali zelite kopirati datoteku copyfile.txt? da/ne");
            Scanner input = new Scanner(System.in);
            String odg = input.nextLine();
            if(odg.contentEquals("da")){
                String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "copyFile.txt";
                FileInputStream in = new FileInputStream(copyFile);
                FileOutputStream out = new FileOutputStream(desktopPath);


                int c;
                while((c = in.read()) != -1){
                    out.write(c);
                }
                in.close();
                out.close();
                System.out.println("Datoteka kopirana na lokaciji: " + desktopPath);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Greska: File not found!");
        } catch (IOException e) {
            throw new RuntimeException("Greska: No data!");
        }
    }
}
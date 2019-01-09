import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String line = "";

        try {
            FileInputStream fs = new FileInputStream("/Users/tharindu/Documents/TMS/418_417/418/EDI_418_with_LH4_N1_N3_N4.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));

            int count = 0;
            FileOutputStream fos = new FileOutputStream("/Users/tharindu/Documents/TMS/418_417/418/418" + count + "_418.edi");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            //PrintWriter output = new PrintWriter(new File("C:/output.RPT"));
            while ((line = br.readLine()) != null) {
                String mine = line.trim();
                //output.println(line);
                if (mine.startsWith("\n")) {
                    count++;

                    fos.close();


                } else {
                    FileOutputStream fos1 = new FileOutputStream("/Users/tharindu/Documents/TMS/418_417/418/418" + count + "_418.edi");
                    BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos1));
                    bw1.write(line);
                    bw.newLine();
                    bw.flush();
                }



            }


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}


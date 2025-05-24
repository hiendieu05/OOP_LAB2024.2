package hust.soict.hespi.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) throws IOException {
        Random r = new Random(123);

        // + operator
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i ++) {
            s += r.nextInt(2);
        }
        System.out.println(System.currentTimeMillis() - start);

        // StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 65536; i ++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println(System.currentTimeMillis() - start);

        // StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 65536; i ++) {
            sb2.append(r.nextInt(2));
        }
        s = sb2.toString();
        System.out.println(System.currentTimeMillis() - start);

        String filename = "src/test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
//        String outputString = "";
//        for (byte b : inputBytes) {
//            outputString += b;
//        }
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
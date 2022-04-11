package RamdaPractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class processingFiles {
    public static String processFiles(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("/Users/imjongho/modernjava/src/RamdaPractice/data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String...args) throws IOException {
        String oneLine =
                processFiles((BufferedReader br) -> br.readLine());

        System.out.println("oneLine = " + oneLine);
    }
}

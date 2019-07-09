package compare;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TwoFiles {

    private static FileInputStream fin1;
    private static FileInputStream fin2;

    public static void main(String[] myArgs) throws IOException {

        Path file1 = Paths.get(myArgs[0]);
        Path file2 = Paths.get(myArgs[1]);

        boolean equal = FilesEqual(file1, file2);

        System.out.println("Comparing: " + myArgs[0] + " and " + myArgs[1]);

        //myArgs should be provided by the user in the command prompt
        fin1 = new FileInputStream(myArgs[0]);
        fin2 = new FileInputStream(myArgs[1]);

        int charLength1 = fin1.available();
        int charLength2 = fin2.available();

        //display if files have identical content or different content, even if they are of equal length
        System.out.println((equal == true) ? "Result: identical content" : "Result: different content");
        //display character length for one file (same length) or both files (different length)
        System.out.println((charLength1 == charLength2) ? "Character length for both files: " + charLength1 : "Character length for " + myArgs[0] + " : " + charLength1 + "\nCharacter length for " + myArgs[1] + " : " + charLength2);
    }

    // method for comparing bytes of the files to check for equal content
    static boolean FilesEqual(Path file1, Path file2) throws IOException {
        byte[] f1 = Files.readAllBytes(file1);
        byte[] f2 = Files.readAllBytes(file2);

        if (f1.length != f2.length)
            return false;
        else {
            for (int i = 0; i < f1.length; i++) {
                if (f1[i] != f2[i])
                    return false;
            }
            return true;
        }
    }
}
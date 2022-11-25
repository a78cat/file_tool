import java.io.File;
import java.io.IOException;

public class FileOperate {

    static File old_file;
    static File new_file;



    public static boolean rename(String old_name,
                                 String new_name) throws IOException {

        old_file = new File(old_name);
        new_file = new File(new_name);

        if (new_file.exists()) {
            throw new java.io.IOException("File already exists!");
        }
        if (old_file.renameTo(new_file)) {
            return true;
        }
        return false;
    }
}

import org.junit.Test;

import java.io.File;

public class FileOperateTest {

    private String filepath = "C:" + File.separator + "CODE" + File.separator;
    private String filename_old = "1.txt";
    private String filename_new = "3.txt";

    @Test
    public void rename_test() {

        String path = "C:\\CODE\\dir\\AKMU - Drift [qmms2].mp3";
        System.out.println("1" + path);
        path = path.replace(" \\[qmms2\\]", "");
        System.out.println("2" + path);
    }

    @Test
    public void add_exname_test() {
        String file_exname_regex = ".*\\.(jpg|png|gif|bmp|jpeg)$";
        String filename = "..jpg.jpg";
        System.out.println("filename:" + filename);
        if (!filename.matches(file_exname_regex)) {
            if (filename.endsWith(".")) {
                filename += "qmcflac";
            } else {
                filename += ".qmcflac";
            }

        }
        String new_name = filename;
        System.out.println("new_name:" + new_name);
    }
}

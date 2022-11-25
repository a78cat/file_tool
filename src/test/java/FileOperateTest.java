import org.junit.Test;

import java.io.File;
import java.io.IOException;

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

}

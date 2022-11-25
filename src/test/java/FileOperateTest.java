import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileOperateTest {

    private String filepath = "C:" + File.separator + "CODE" + File.separator;
    private String filename_old = "1.txt";
    private String filename_new = "3.txt";

    @Test
    public void rename_test() {

        try {
            FileOperate.rename(filepath + filename_old, filepath + filename_new);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void menu_test() {
        Menu.main_menu();
    }
}

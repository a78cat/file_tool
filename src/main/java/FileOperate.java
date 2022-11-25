import java.io.File;

public class FileOperate {

    public static String[] get_current_dir_filenames(String path) {
        File dir = new File(path);
        return dir.list();
    }
    public static int get_current_dir_file_count(String path) {
        return get_current_dir_filenames(path).length;
    }
    public static boolean show_current_dir_files(String path) {
        String[] files = get_current_dir_filenames(path);
        if (null == files) {
            System.out.println("目录不存在或它不是一个目录");
            return false;
        } else {
            for (String filename: files) {
                System.out.println(filename);
            }
            return true;
        }
    }

    public static boolean rename(String old_name,
                                 String new_name) {

        File old_file = new File(old_name);
        File new_file = new File(new_name);
        if (new_file.exists()) {
            System.out.println("新名称" + new_name + "已存在");
            return false;
        } else if (old_file.renameTo(new_file)) {

            return true;
        } else {
            System.out.println("未知错误");
        }
        return false;
    }
}

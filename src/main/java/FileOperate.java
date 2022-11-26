import java.io.File;

public class FileOperate {

    // 获取当前目录下所有文件名字
    public static String[] get_current_dir_filenames(String path) {
        File dir = new File(path);
        return dir.list();
    }
    // 获取当前目录下文件个数
    public static int get_current_dir_file_count(String path) {
        return get_current_dir_filenames(path).length;
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

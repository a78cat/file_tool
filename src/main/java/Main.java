import java.io.File;
import java.util.Scanner;

public class Main {

    private static Scanner sc_next = new Scanner(System.in);
    private static Scanner sc_nextline = new Scanner(System.in);
    private static String command = "";
    private static String path = "/";

    public static void main(String[] args) {

        while (true) {
            switch (command) {
                case "0": // 退出
                    command = "";
                    exit();
                    break;
                case "1": // 关于
                    command = "";
                    about();
                    break;
                case "2": // 设置文件夹路径
                    command = "";
                    set_dir_path();
                    break;
                case "3": // 查看当前目录下的所有文件
                    command = "";
                    show_current_dir_content();
                    break;
                case "4": // 修改文件名
                    command = "";
                    rename_file();
                    break;
                default: // 主菜单
                    Menu.main_menu(path);
                    command = sc_next.next();
                    break;
            }
        }
    }

    // 展示当前目录下的文件
    private static boolean show_current_dir_content() {
        while (true) {
            FileOperate.show_current_dir_files(path);
            Menu.show_dir_content_hint(FileOperate.get_current_dir_file_count(path));
            command = sc_next.next();
            if ("0".equals(command)) {
                command = "";
                break;
            } else {
                Menu.command_error_alert();
            }
        }
        return true;
    }

    // 设置文件夹路径
    private static boolean set_dir_path() {
        Menu.set_folder_path_hint();
        path = sc_nextline.nextLine().trim();
        // 对路径进行处理
        String temp;
        if ("\\".equals(File.separator)) {
            temp = "\\\\";
            path = path.replaceAll("/", temp);
        } else {
            temp = "/";
            path = path.replaceAll("\\\\", temp);
        }
        // 如果路径结尾没有”/”且”\“则添加
        if (!path.endsWith("\\") && !path.endsWith("/")) {
            path += File.separator;
        }
        return true;
    }

    // 重命名文件
    private static boolean rename_file() {
        Menu.rename_file_hint();
        String[] filename_list = FileOperate.get_current_dir_filenames(path);
        int flag = 0; // 修改失败计数
        for (String filename: filename_list) {
            String old_name = path + filename;
            String new_name = old_name.replaceAll("( \\[qmms\\])|( \\[qmms2\\])", "");
            if (!FileOperate.rename(old_name, new_name)) {
                flag++;
            }
        }
        Menu.rename_file_ok_hint(filename_list.length, flag);
        return true;
    }

    // 退出系统
    private static boolean exit() {
        while (true) {
            Menu.exit_alert();
            command = sc_next.next();
            if ("Y".equals(command) || "y".equals(command)) {
                System.out.println("bye");
                // 释放资源
                sc_next.close();
                sc_nextline.close();
                System.exit(1);
            } else if ("N".equals(command) || "n".equals(command)) {
                command = "";
                break;
            } else {
                Menu.command_error_alert();
            }
        }
        return true;
    }

    // 关于本软件
    private static boolean about() {
        while (true) {
            Menu.about_menu();
            command = sc_next.next();
            if ("0".equals(command)) {
                command = "";
                break;
            } else {
                Menu.command_error_alert();
            }
        }
        return true;
    }
}

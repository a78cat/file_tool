public class Menu {
    public static void main_menu(String path) {
        System.out.println("----欢迎使用文件批量改名工具v0.1----");
        System.out.println("当前操作系统：" + System.getProperty("os.name"));
        System.out.println("当前文件夹路径：" + path);
        System.out.println("0.退出");
        System.out.println("1.关于");
        System.out.println("2.设置文件夹路径");
        System.out.println("3.查看当前目录下的所有文件");
        System.out.println("4.修改文件名");
    }

    // 关于菜单
    public static void about_menu() {
        System.out.println("2022年11月25日制作 78cat made");
        System.out.println(">输入0返回主菜单");
    }

    // 退出警告
    public static void exit_alert() {
        System.out.println("真的要退出吗(Y/N)");
    }

    // 指令错误警告
    public static void command_error_alert() {
        System.out.println("错误！你的指令有误，请重试!");
    }

    // 设置文件夹路径菜单
    public static void set_folder_path_hint() {
        System.out.println(">请输入文件夹路径");
    }

    // 查看当前目录下的所有文件
    public static void show_dir_content_hint(int file_count) {
        System.out.println(">共计" + file_count + "个文件，展示完毕，输入0返回主菜单");
    }

    // 开始修改文件名
    public static void rename_file_hint() {
        System.out.println("重命名开始咯...");
    }
    public static void rename_file_ok_hint(int file_count, int change_fail_count) {
        System.out.println(">重命名完成，输入0返回主菜单");
        System.out.println("当前目录下共有" + file_count + "个文件，修改失败" + change_fail_count + "个");
    }
}

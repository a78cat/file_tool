public class Menu {
    public static void main_menu() {
        System.out.println("欢迎使用文件批处理工具v0.1");
        System.out.println("+———————————————————+");
        System.out.println("|0.退出\t\t\t\t|");
        System.out.println("|1.关于\t\t\t\t|");
        System.out.println("|2.修改文件名\t\t\t|");
        System.out.println("+———————————————————+");
    }
    public static void about_menu() {
        System.out.println("78cat made");
        System.out.println("+———————————————————+");
        System.out.println("|0.返回上一级\t\t\t|");
        System.out.println("+———————————————————+");
    }
    public static void exit_menu() {
        System.out.println("真的要退出吗(Y/N)");
    }
    public static void command_error_alert() {
        System.out.println("错误！你的指令有误，请重试!");
    }
    public static void rename_file_menu() {
        System.out.println("请输入源文件路径0返回上一级");
        System.out.println("+———————————————————+");
        System.out.println("|0.返回上一级\t\t\t|");
        System.out.println("+———————————————————+");
    }
}

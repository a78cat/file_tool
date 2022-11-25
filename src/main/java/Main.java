import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String command = "";

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
                case "2": // 功能
                    command = "";
                    rename_file();
                default: // 主菜单
                    Menu.main_menu();
                    command = scanner.next();
                    break;
            }
        }
    }

    private static boolean rename_file() {
        Menu.rename_file_menu();
        String raw_string = scanner.next();
        String filepath = "";
        String filename_old = "";
        String filename_new = "";
        command = "";
        return true;
    }

    private static boolean exit() {
        while (true) {
            Menu.exit_menu();
            command = scanner.next();
            if ("Y".equals(command) || "y".equals(command)) {
                System.out.println("bye");
                scanner.close();
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

    private static boolean about() {
        while (true) {
            Menu.about_menu();
            command = scanner.next();
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

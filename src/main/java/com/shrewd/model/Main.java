package com.shrewd.model;

import com.shrewd.controller.FileOperate;
import com.shrewd.view.Menu;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static Scanner sc_next = new Scanner(System.in);
    private static Scanner sc_nextline = new Scanner(System.in);
    private static String command = "";
    private static String path = "/";

    // 指定加密格式扩展名匹配规则
    private static final String FILENAME_SUFFIX_REGEX = ".*\\.(qmcflac|qmc0)$";
    // 为无扩展名的文件添加指定扩展名
    private static final String FILENAME_SUFFIX = ".qmcflac";
    // 指定去除特定文字的规则
    private static final String FILENAME_CONTAINS_REGEX = "( \\[qmms\\])|( \\[qmms2\\])";

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
                case "5": // 添加扩展名
                    command = "";
                    add_exfilename();
                    break;
                default: // 主菜单
                    Menu.main_menu(path);
                    command = sc_next.next();
                    break;
            }
        }
    }

    private static boolean add_exfilename() {
        Menu.add_file_extension_name_hint();
        String[] filename_list = FileOperate.get_current_dir_filenames(path);
        int flag = 0; // 修改失败计数
        for (String filename: filename_list) {
            String old_name = path + filename;
            if (!filename.matches(FILENAME_SUFFIX_REGEX)) {
                filename += FILENAME_SUFFIX;
            }
            String new_name = path + filename;
            if (!FileOperate.rename(old_name, new_name)) {
                flag++;
            }
        }
        Menu.add_file_extension_name_ok_hint(filename_list.length, flag);
        while (true) {
            command = sc_next.next();
            if ("0".equals(command)) {
                command = "";
                break;
            }
        }
        return true;
    }

    // 展示当前目录下的文件
    private static boolean show_current_dir_content() {
        while (true) {
            String[] filenames = FileOperate.get_current_dir_filenames(path);
            int file_count = filenames.length;
            if (null != filenames) {
                Menu.show_dir_content(filenames, file_count);
            }
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
            String new_name = old_name.replaceAll(FILENAME_CONTAINS_REGEX, "");
            if (!FileOperate.rename(old_name, new_name)) {
                flag++;
            }
        }
        Menu.rename_file_ok_hint(filename_list.length, flag);
        while (true) {
            command = sc_next.next();
            if ("0".equals(command)) {
                command = "";
                break;
            }
        }
        return true;
    }

    // 退出系统
    private static boolean exit() {
        while (true) {
            Menu.exit_alert();
            command = sc_next.next();
            if ("Y".equals(command) || "y".equals(command)) {
                System.out.println("bye");
                sc_next.close(); // 释放资源
                sc_nextline.close(); // 释放资源
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

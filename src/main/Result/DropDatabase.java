package main.Result;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DropDatabase {
    //delete database 数据库名称
    public static void deleteDB(String dbname) throws IOException {

        File file = new File("src/DatabaseSourse/" + dbname + "");
        if (!file.exists()) {
            System.out.println("database " + dbname + " is not exist");
            return;
        }
        //若数据库中有表存在，则提示用户
        if (file.listFiles().length > 0) {
            System.out.println("数据库" + dbname + "中有表存在，是否继续删除(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.toUpperCase().equals("Y")) {
                String dirPath = new String();
                dirPath = "src/DatabaseSourse/" + dbname;
                deleteDir(dirPath);
                System.out.println("数据库" + dbname + "删除成功");
            } else {
                return;
            }
        }
        //若数据库为空，直接删除
        else {
            file.delete();
            System.out.println("数据库" + dbname + "删除成功");
        }
    }

    public static void deleteDir(String dirPath) {
        File file = new File(dirPath);
        if (file.isFile()) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            if (files == null) {
                file.delete();
            } else {
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }

}

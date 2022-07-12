package main.Result;

import java.io.File;

public class DropTable {
    //delete table 表名
    public static void deleteTable(String dbName, String tbName) {
        //判断数据库是否为空
        if (IsLegal.isDatabaseEmpty()) {
            return;
        }
        String dirPath = new String();
        dirPath = "src/DatabaseSourse/" + dbName + "/" + tbName;
        deleteDir(dirPath);
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



package main.Result;

import java.io.File;

public class ShowTables {
    //show tables
    public static void showTable(String dbname){
        //数据库是否为空
        if(IsLegal.isDatabaseEmpty()){
            return;
        }
        File dir=new File("src/DatabaseSourse/"+dbname+"");
        for(File file:dir.listFiles()){
            if(file.exists()){
                System.out.println(file.getName());
            }
        }
    }
}

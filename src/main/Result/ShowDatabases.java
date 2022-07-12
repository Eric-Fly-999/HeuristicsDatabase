package main.Result;

import java.io.File;

public class ShowDatabases {
    //show databases
    public static void showDatabase(){
        File file=new File("src/DatabaseSourse");
        File[] files=file.listFiles();
        for(int i=0;i<files.length;i++){
            System.out.println(files[i].getName());
        }
    }
}

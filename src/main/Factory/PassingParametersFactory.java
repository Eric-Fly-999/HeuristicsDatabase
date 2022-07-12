package main.Factory;

import main.Result.*;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 工厂类：对解析后的sql语句进行判断，调用相应功能的模块函数
 */
public class PassingParametersFactory {

    public static void dealParameters(List<List<String>> list) throws IOException, DocumentException {
        List<String> ls = new ArrayList<String>();
        ls = list.get(0);

        String sql_key = ls.get(0);
        if (sql_key.equals("create table")) {
            System.out.println("Use Method：创建表");
            List<String> tmp = new ArrayList<String>();//传递参数
            List<String> tmp1 = list.get(1);
            for (int i = 1; i < tmp1.size(); i++) {
                tmp.add(tmp1.get(i));
            }
            CreateTable.createTb(UseDatabase.dbName, ls.get(1), tmp);
        } else if (sql_key.equals("show databases")) {
            System.out.println("Use Method：列出所有数据库");
            ShowDatabases.showDatabase();
        } else if (sql_key.equals("show tables")) {
            System.out.println("Use Method：列出所有表");
            ShowTables.showTable(UseDatabase.dbName);
        } else if (sql_key.equals("use database")) {
            System.out.print("Use Method：进入数据库");
            UseDatabase.dbName = ls.get(1);
            //if database illegal
            if (!IsLegal.isDatabase()) {
                UseDatabase.dbName = null;
                return;
            } else {
                System.out.println(" `" + UseDatabase.dbName + "`");
            }
        } else if (sql_key.equals("create database")) {
            System.out.println("Use Method：创建数据库");
            CreateDatabase.createDB(ls.get(1));
        } else if (sql_key.equals("insert into")) {
            System.out.println("Use Method：插入数据到表");

            List<String> tmp2 = list.get(2);
            List<String> tmp1 = list.get(1);

            InsertDataIntoTable.insertIntoTable(UseDatabase.dbName, ls.get(1), tmp1, tmp2);
        } else if (sql_key.equals("select * from")) {
            //包含where条件
            if (list.size() > 1) {
                System.out.println("Use Method：查询指定记录");
                String tableName = list.get(0).get(1);
                List<String> condition = list.get(1);
                SelectDataFromTable.select(UseDatabase.dbName, tableName, null, condition);

            } else {
                System.out.println("Use Method：查询所有记录");
                String tableName = list.get(0).get(1);
                SelectDataFromTable.select(UseDatabase.dbName, tableName, null, null);
            }

        } else if (sql_key.equals("select")) {
            System.out.println("Use Method：查询记录中的某些列");
            List<String> columns = list.get(0);
            List<String> condition = list.get(2);
            String tableName = list.get(1).get(1);

            SelectDataFromTable.select(UseDatabase.dbName, tableName, columns, condition);
        } else if (sql_key.equals("update")) {
            System.out.println("Use Method：更新指定记录");

            List<List<String>> tmp = getPararmeterList(list);
            UpdateDataFromTable.updateTable(UseDatabase.dbName, list.get(0).get(1), tmp);
        } else if (sql_key.equals("drop database")) {
            System.out.println("Use Method：删除数据库");
            DropDatabase.deleteDB((ls.get(1)));
        } else if (sql_key.equals("drop table")) {
            System.out.println("Use Method：删除表");
            DropTable.deleteTable(UseDatabase.dbName, ls.get(1));
        } else if (sql_key.equals("delete from")) {
            System.out.println("Use Method：删除指定记录");
            //取出每个list中的start部分，只传递后面的参数部分；
            List<String> tmp1 = list.get(1);
            List<String> tmp2 = new ArrayList<String>();
            for (int i = 1; i < tmp1.size(); i++) {
                String r = tmp1.get(i);
                tmp2.add(r);
            }
            DeleteDataFromTable.deleteFromTable(UseDatabase.dbName, ls.get(1), tmp2);
        } else if (sql_key.equals("create index on")) {
            System.out.println("Use Method：创建索引");
            CreateIndex.createIndex(UseDatabase.dbName, list.get(0).get(1), list.get(1).get(1));
        } else if (sql_key.equals("drop index on")) {
            System.out.println("Use Method：删除索引");
            DropIndex.dropIndex(UseDatabase.dbName, list.get(0).get(1));
        } else if (sql_key.equals("create user")) {
            System.out.println("Use Method：创建新用户");
            CreateUser.createUser();
        }
    }

    /*
     * 当list参数为多行时，用于提取多行有效的参数。
     */
    protected static List<List<String>> getPararmeterList(List<List<String>> list) {
        List<List<String>> tmp1 = new ArrayList<List<String>>(); //传递参数
        List<String> tmp2;
        List<String> tmp3;

        //System.out.println(list.size());

        for (int i = 1; i < list.size(); i++) {
            tmp2 = new ArrayList<String>();
            tmp3 = new ArrayList<String>();

            tmp2 = list.get(i);
            for (int j = 1; j < tmp2.size(); j++) {
                String r = tmp2.get(j);
                tmp3.add(r);
            }
            tmp1.add(tmp3);
        }

        return tmp1;
    }
}
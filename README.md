# Heuristics Database

![icon](.\picture\icon.jpg)


## Data Features

![image-20220615103121941](.\picture\image-20220615103121941.png)

![image-20220615103158452](.\picture\image-20220615103158452.png)

![image-20220615103239866](.\picture\image-20220615103239866.png)





## Support basic DDL(create table, drop table)

```java
//create table 表名(列名称1 数据类型1,列名称2 数据类型2)
create table sample(
    id int not null primary key,
    name varchar(20) not null 
);
```

```java
drop table 表名
```

### Support Type List:

- **BOOL**
- **BYTE, SHORT, INT, LONG**
- **FLOAT, DOUBLE**
- **VARCHAR(*)**

### Support Constraint Type

- `null`(default)
- `not null`
- `primary key`



## Support basic DML

### INSERT

```java
insert into table_name (name,age,sex) values ("小明","28","女");
```

### DELETE

```java
delete from 表名 where 列名称=列值
drop table 表名
```



## Support basic DQL

### SELECT

```java
select * from 表名 where 列名称=列值
select 列名称1，列名称2 from 表名
select 列名称1，列名称2 from 表名 where 列名称=列值
```





## LOGIN Code

```java
public class Login {
    public static void main(String[] args) throws IOException, DocumentException {
        System.out.println("Please Login First.");
        //声明一个变量loginCntMax，记录用户输入错误次数，超过3此则退出系统
        int loginCntMax = 3;
        while (loginCntMax > 0) {
            //Enter UserName and Password
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter UserName: ");
            String name = bufferedReader.readLine();
            System.out.println("Enter Password: ");
            String password = bufferedReader.readLine();

            //验证信息
            Document document = new SAXReader().read("src/DatabaseSourse/user/user.xml");
            org.dom4j.Element node = (org.dom4j.Element) document.selectSingleNode("users/user[@name='" + name + "'and @password='" + password + "']");

            if (node != null) {
                System.out.println("Welcome to the HeuristicsDatabase-1.0.0");
                loginCntMax = 0;
            } else {
                System.out.println("Wrong user name or password, please try again!");
                loginCntMax--;
                if (loginCntMax == 0) {
                    System.out.println("Enter the user name / password incorrectly 3 times, and the system will exit.\nBye~");
                    return;
                }
            }
        }

//        加载索引文件到内存
        if (IsLegal.need_loadIndex()) {
            CreateIndex.loadIndex();
        }

        UseDatabase.dbName = "test";
        //性能测试入口
//        timeTest();

        while (true) {
            System.out.println("Enter SQL statement:  (You can enter `help` to query SQL statement help ^.^)");
            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            String sql = input.nextLine();
            if (sql.equals("help")) {
                read_help();
                continue;
            }
            while (sql.lastIndexOf(";") != sql.length() - 1) {
                sql = sql + " " + input.nextLine();
            }
            //预处理:获得语句;
            sql = sql.trim();//处理前后空格;
            sql = sql.toLowerCase();//变小写;
            sql = sql.replaceAll("\\s+", " ");//处理中间多余的空格回车和特殊字符;

            sql = sql.substring(0, sql.lastIndexOf(";"));
            sql = "" + sql + " ENDOFSQL";//在末尾加特殊符号;
            List<List<String>> parameter_list = new ArrayList<List<String>>();
            if (sql.equals("exit ENDOFSQL")) {
                System.out.println("Bye~");
                return;
            } else {
                //将预处理后的SQL语句匹配SQL正则表达式，返回含有SQL的body信息的List
                try {
                    parameter_list = SingleSqlParserFactory.generateParser(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //根据SQL的body部分，调用相应的功能模块
                try {
                    PassingParametersFactory.dealParameters(parameter_list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void read_help() throws DocumentException {
        File file = new File("help.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        List<Node> nodes = document.getRootElement().selectNodes("help");
        for (Node node : nodes) {
            Element element = (Element) node;
            System.out.println(element.getText());
        }
    }
}
```



# Execute Time Test

```java
public static void timeTest() {
        long startTime = System.currentTimeMillis(); //获取开始时间
        //"insert into ins(var1,var2) values(1,1.1);
        for (int i = 0; i < 1000; i++) {
            StringBuilder sql1 = new StringBuilder();
            sql1.append("insert into ins(var1,var2) values(1,1.1);");
            String sql = sql1.toString();
            sql = sql.substring(0, sql.lastIndexOf(";"));
            sql = "" + sql + " ENDOFSQL";
            List<List<String>> parameter_list = new ArrayList<List<String>>();
            try {
                parameter_list = SingleSqlParserFactory.generateParser(sql);
                PassingParametersFactory.dealParameters(parameter_list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("Finished in (" + (endTime - startTime) + ") ms");
    }
```


















































































































































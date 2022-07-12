package main.Sqlparser.SQLDDL;


import main.Sqlparser.Basic.*;

public class CreateTableSqlParser extends BaseSingleSqlParser {
    public CreateTableSqlParser(String originalSql) {
        super(originalSql);
    }

    //create table table_name(id int not null primary key,name varchar(8) not null );
    @Override
    protected void initializeSegments() {
        segments.add(new SqlSegment("(create table)(.+?)([(])", "[,]"));
        segments.add(new SqlSegment("([(])(.+?)([)] ENDOFSQL)", "[,]"));
    }

}

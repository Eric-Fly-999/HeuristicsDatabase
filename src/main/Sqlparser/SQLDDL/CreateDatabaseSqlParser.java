package main.Sqlparser.SQLDDL;
/**
 *
 */

import main.Sqlparser.Basic.*;

//correct
public class CreateDatabaseSqlParser extends BaseSingleSqlParser {

    public CreateDatabaseSqlParser(String originalSql) {
        super(originalSql);
    }

    //create database database_name;

    @Override
    protected void initializeSegments() {
        segments.add(new SqlSegment("(create database)(.+)( ENDOFSQL)", "[,]"));
    }
}

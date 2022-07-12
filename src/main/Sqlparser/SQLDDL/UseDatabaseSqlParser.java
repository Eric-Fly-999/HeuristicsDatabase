package main.Sqlparser.SQLDDL;

import main.Sqlparser.Basic.*;

//correct
public class UseDatabaseSqlParser extends BaseSingleSqlParser {

    public UseDatabaseSqlParser(String originalSql) {
        super(originalSql);
    }

    //use databases_name;
    @Override
    protected void initializeSegments() {
        segments.add(new SqlSegment("(use database)(.+)( ENDOFSQL)", "[,]"));
    }

}

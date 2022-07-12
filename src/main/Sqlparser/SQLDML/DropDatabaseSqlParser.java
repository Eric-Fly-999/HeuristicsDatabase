package main.Sqlparser.SQLDML;

import main.Sqlparser.Basic.*;

public class DropDatabaseSqlParser extends BaseSingleSqlParser {
    public DropDatabaseSqlParser(String originalSql) {
        super(originalSql);
    }
    @Override
    protected void initializeSegments() {

        segments.add(new SqlSegment("(drop database)(.+)( ENDOFSQL)","[,]"));

    }
}

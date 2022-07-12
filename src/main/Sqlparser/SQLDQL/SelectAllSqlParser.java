package main.Sqlparser.SQLDQL;

import main.Sqlparser.Basic.*;

public class SelectAllSqlParser extends BaseSingleSqlParser {
    public SelectAllSqlParser(String originalSql)
    {
        super(originalSql);

    }
    @Override
    protected void initializeSegments(){
        segments.add(new SqlSegment("(select \\* from)(.+)( ENDOFSQL)","[,]"));
    }
}

package main.Sqlparser.SQLDQL;

import main.Sqlparser.Basic.*;

public class SelectAllWhereSqlParser extends BaseSingleSqlParser {
    public SelectAllWhereSqlParser(String originalSql)
    {
        super(originalSql);

    }
    @Override
    protected void initializeSegments(){
        segments.add(new SqlSegment("(select \\* from)(.+)( where)","[,]"));
        segments.add(new SqlSegment("(where)(.+)( ENDOFSQL)","[,]"));
    }
}

package main.Sqlparser.SQLDQL;

import main.Sqlparser.Basic.*;

public class ShowTablesSqlParser extends BaseSingleSqlParser {
    public ShowTablesSqlParser(String originalSql)
    {
        super(originalSql);
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void initializeSegments(){
        segments.add(new SqlSegment("(show tables)(.+)(ENDOFSQL)","[,]"));
    }
}

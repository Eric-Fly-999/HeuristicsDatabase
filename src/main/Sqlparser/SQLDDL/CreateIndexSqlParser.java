package main.Sqlparser.SQLDDL;

import main.Sqlparser.Basic.*;

public class CreateIndexSqlParser extends BaseSingleSqlParser {
    public CreateIndexSqlParser(String originalSql) {
        super(originalSql);

    }

    //create index on 表名(列名称);
    @Override
    protected void initializeSegments()
    {
        segments.add(new SqlSegment("(create index on)(.+?)([(])","[,]"));
        segments.add(new SqlSegment("([(])(.+?)([)] ENDOFSQL)","[,]"));

    }

}

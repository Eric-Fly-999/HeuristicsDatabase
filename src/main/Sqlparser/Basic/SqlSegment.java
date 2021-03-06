package main.Sqlparser.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Sql语句片段
public class SqlSegment {
    private static final String Crlf = "|";
    @SuppressWarnings("unused")
    private static final String FourSpace = "　　";
    //Sql语句片段开头部分
    private String start;

    //Sql语句片段中间部分
    private String body;

    //Sql语句片段结束部分		　
    private String end;

    //用于分割中间部分的正则表达式
    private String bodySplitPattern;

    //表示片段的正则表达式
    private String segmentRegExp;

    //分割后的Body小片段
    private List<String> bodyPieces;

    //构造函数
    public SqlSegment(String segmentRegExp, String bodySplitPattern) {
        start = "";
        body = "";
        end = "";
        this.segmentRegExp = segmentRegExp;
        this.bodySplitPattern = bodySplitPattern;
        this.bodyPieces = new ArrayList<String>();

    }


    //从sql中查找符合segmentRegExp的部分，并赋值到start,body,end等三个属性中
    public void parse(String sql) {
        Pattern pattern = Pattern.compile(segmentRegExp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sql);
        while (matcher.find()) {
            start = matcher.group(1);
            body = matcher.group(2);
            end = matcher.group(3);
            parseBody();
        }
    }

	//解析body部分
    private void parseBody() {
        //System.out.println("分body");
        List<String> ls = new ArrayList<String>();
        Pattern p = Pattern.compile(bodySplitPattern, Pattern.CASE_INSENSITIVE);
        // 先清除掉前后空格
        body = body.trim();
        Matcher m = p.matcher(body);
        StringBuffer sb = new StringBuffer();
        boolean result = m.find();

        while (result) {
            m.appendReplacement(sb, Crlf);
            result = m.find();
        }
        m.appendTail(sb);

        // 再按空格断行
        ls.add(start);
        String[] arr = sb.toString().split("[|]");
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++) {
            ls.add(arr[i]);
        }
        bodyPieces = ls;

    }

	//取得解析好的Sql片段
    public String getParsedSqlSegment() {
        StringBuffer sb = new StringBuffer();
        sb.append(start + Crlf);
        for (String piece : bodyPieces) {
            sb.append(piece + Crlf);
        }
        return sb.toString();
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBodySplitPattern() {
        return bodySplitPattern;
    }

    public void setBodySplitPattern(String bodySplitPattern) {
        this.bodySplitPattern = bodySplitPattern;
    }

    public String getSegmentRegExp() {
        return segmentRegExp;
    }

    public void setSegmentRegExp(String segmentRegExp) {
        this.segmentRegExp = segmentRegExp;
    }

    public List<String> getBodyPieces() {
        return bodyPieces;
    }

    public void setBodyPieces(List<String> bodyPieces) {
        this.bodyPieces = bodyPieces;
    }

}

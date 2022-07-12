<?xml version="1.0" encoding="gb2312"?>
<xsl:stylesheet xmlns:xsl=
                        "http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html" indent="yes" encoding="gb2312"/>

    <xsl:template match="/">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="students">
        <h3 style="text-align: center; font-size: 20px;  margin-top:20px;">Students Info</h3>
        <table border="1" width="100%" style="text-align:center; margin-top:10px;">
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Name
                </th>
                <th>
                    Sex
                </th>
                <th>
                    Age
                </th>
            </tr>
            <xsl:for-each select="student">
                <tr>
                    <td>
                        <i><xsl:value-of select="id"/></i>
                    </td>
                    <td>
                        <xsl:value-of select="name"/>
                    </td>
                    <td>
                        <xsl:value-of select="sex"/>
                    </td>
                    <td>
                        <xsl:value-of select="age"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>
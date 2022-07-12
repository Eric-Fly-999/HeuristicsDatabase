<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl=
                        "http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="schools">
        <h3 style="text-align: center; font-size: 20px;  margin-top:20px;">Schools Info</h3>
        <table border="1" width="100%" style="text-align:center; margin-top:10px;">
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Name
                </th>
                <th>
                    Location
                </th>
            </tr>
            <xsl:for-each select="school">
                <tr>
                    <td>
                        <i><xsl:value-of select="id"/></i>
                    </td>
                    <td>
                        <xsl:value-of select="name"/>
                    </td>
                    <td>
                        <xsl:value-of select="location"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>
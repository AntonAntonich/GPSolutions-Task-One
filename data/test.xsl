<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/class">
        <html>
            <body>
                <h2>Hotels</h2>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Address</th>
                    </tr>

                    <xsl:for-each select="Names">
                        <tr>
                            <td>
                                <xsl:value-of select="Name"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
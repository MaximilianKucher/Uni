<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output encoding="ISO-8859-1" method="text"/>

	<xsl:param name="br">
        <xsl:text>&#xa;</xsl:text>
	</xsl:param>
	
	<xsl:param name="space">
        <xsl:text>&#x20;</xsl:text>
	</xsl:param>

	<xsl:template match="RECHNUNGEN">
		<xsl:for-each select="RECHNUNG">
			<xsl:if test="RECHNUNGSGESAMTBRUTTOBETRAG &lt; 1000">
				<xsl:value-of select="ANREDE"/><xsl:copy-of select="$space"/><xsl:value-of select="NAME"/>.<xsl:copy-of select="$br"/>
				<xsl:text>Danke für die Zahlung von </xsl:text><xsl:value-of select="RECHNUNGSGESAMTBRUTTOBETRAG"/><xsl:text> für die Rechnung vom </xsl:text><xsl:value-of select="substring-after(substring-after(AUSSTELLUNGSDATUM,'-'),'-')"/>. <xsl:value-of select="substring-before(substring-after(AUSSTELLUNGSDATUM,'-'),'-')"/>. <xsl:value-of select="substring-before(AUSSTELLUNGSDATUM,'-')"/>.<xsl:copy-of select="$br"/>
				<xsl:text>Ich hoffe die </xsl:text><xsl:value-of select="count(POSITIONEN/POSITION)"/><xsl:text> Einzelposten sind zu Ihrer Zufriedenheit geliefert worden.</xsl:text><xsl:copy-of select="$br"/>
				<xsl:copy-of select="$br"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>
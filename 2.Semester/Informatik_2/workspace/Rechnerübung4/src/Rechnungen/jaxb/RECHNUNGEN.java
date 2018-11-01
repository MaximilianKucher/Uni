//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.12.10 um 04:58:28 PM EET 
//


package Rechnungen.jaxb;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RECHNUNG" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NAME_UND_ANSCHRIFT_LEISTENDER_UNTERNEHMER">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="STRASSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TELEFONNUMMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FAX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="E-MAIL_ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="NAME_UND_ANSCHRIFT_LEISTUNGSEMPFAENGER">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ANREDE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="STRASSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="LEISTUNGEN">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="LEISTUNG" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="NUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                       &lt;element name="WAEHRUNG">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="EUR"/>
 *                                             &lt;enumeration value="USD"/>
 *                                             &lt;enumeration value="AUD"/>
 *                                             &lt;enumeration value="CHF"/>
 *                                             &lt;enumeration value="GBP"/>
 *                                             &lt;enumeration value="JPY"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="HANDELSUEBLICHER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ANZAHL" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *                                       &lt;element name="DATUM" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="MEHRWERTSTEUER" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="STEUERNUMMER">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="STEUERNUMMER_UNTERNEHMER" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/>
 *                             &lt;element name="UMSATZSTEUER-IDENTIFIKATIONSNUMMER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AUSSTELLUNGSDATUM" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="RECHNUNGSNUMMER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ENTGELD_IN_EURO" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="ZAHLUNGSMOEGLICHKEITEN">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DEUTSCHLANDINTERN" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;all>
 *                                       &lt;element name="KONTOINHABER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="BANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="KONTONUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
 *                                       &lt;element name="BLZ" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
 *                                     &lt;/all>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="AUSSERHALB_DEUTSCHLANDS" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="KONTONUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                       &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="KRYPTOWAEHRUNG" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BITCOIN_ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rechnung"
})
@XmlRootElement(name = "RECHNUNGEN")
public class RECHNUNGEN {

    @XmlElement(name = "RECHNUNG", required = true)
    protected List<RECHNUNGEN.RECHNUNG> rechnung;

    /**
     * Gets the value of the rechnung property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rechnung property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRECHNUNG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RECHNUNGEN.RECHNUNG }
     * 
     * 
     */
    public List<RECHNUNGEN.RECHNUNG> getRECHNUNG() {
        if (rechnung == null) {
            rechnung = new ArrayList<RECHNUNGEN.RECHNUNG>();
        }
        return this.rechnung;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="NAME_UND_ANSCHRIFT_LEISTENDER_UNTERNEHMER">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="STRASSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TELEFONNUMMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FAX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="E-MAIL_ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="NAME_UND_ANSCHRIFT_LEISTUNGSEMPFAENGER">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ANREDE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="STRASSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="LEISTUNGEN">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="LEISTUNG" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="NUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *                             &lt;element name="WAEHRUNG">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="EUR"/>
     *                                   &lt;enumeration value="USD"/>
     *                                   &lt;enumeration value="AUD"/>
     *                                   &lt;enumeration value="CHF"/>
     *                                   &lt;enumeration value="GBP"/>
     *                                   &lt;enumeration value="JPY"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="HANDELSUEBLICHER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="ANZAHL" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
     *                             &lt;element name="DATUM" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="MEHRWERTSTEUER" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="STEUERNUMMER">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="STEUERNUMMER_UNTERNEHMER" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/>
     *                   &lt;element name="UMSATZSTEUER-IDENTIFIKATIONSNUMMER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AUSSTELLUNGSDATUM" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="RECHNUNGSNUMMER" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ENTGELD_IN_EURO" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="ZAHLUNGSMOEGLICHKEITEN">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DEUTSCHLANDINTERN" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;all>
     *                             &lt;element name="KONTOINHABER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="BANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="KONTONUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
     *                             &lt;element name="BLZ" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
     *                           &lt;/all>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="AUSSERHALB_DEUTSCHLANDS" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="KONTONUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *                             &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="KRYPTOWAEHRUNG" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BITCOIN_ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nameundanschriftleistenderunternehmer",
        "nameundanschriftleistungsempfaenger",
        "leistungen",
        "steuernummer",
        "ausstellungsdatum",
        "rechnungsnummer",
        "entgeldineuro",
        "zahlungsmoeglichkeiten"
    })
    public static class RECHNUNG {

        @XmlElement(name = "NAME_UND_ANSCHRIFT_LEISTENDER_UNTERNEHMER", required = true)
        protected RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER nameundanschriftleistenderunternehmer;
        @XmlElement(name = "NAME_UND_ANSCHRIFT_LEISTUNGSEMPFAENGER", required = true)
        protected RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER nameundanschriftleistungsempfaenger;
        @XmlElement(name = "LEISTUNGEN", required = true)
        protected RECHNUNGEN.RECHNUNG.LEISTUNGEN leistungen;
        @XmlElement(name = "STEUERNUMMER", required = true)
        protected RECHNUNGEN.RECHNUNG.STEUERNUMMER steuernummer;
        @XmlElement(name = "AUSSTELLUNGSDATUM", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar ausstellungsdatum;
        @XmlElement(name = "RECHNUNGSNUMMER", required = true)
        protected String rechnungsnummer;
        @XmlElement(name = "ENTGELD_IN_EURO", required = true)
        protected BigDecimal entgeldineuro;
        @XmlElement(name = "ZAHLUNGSMOEGLICHKEITEN", required = true)
        protected RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN zahlungsmoeglichkeiten;

        /**
         * Ruft den Wert der nameundanschriftleistenderunternehmer-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER }
         *     
         */
        public RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER getNAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER() {
            return nameundanschriftleistenderunternehmer;
        }

        /**
         * Legt den Wert der nameundanschriftleistenderunternehmer-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER }
         *     
         */
        public void setNAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER(RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER value) {
            this.nameundanschriftleistenderunternehmer = value;
        }

        /**
         * Ruft den Wert der nameundanschriftleistungsempfaenger-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER }
         *     
         */
        public RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER getNAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER() {
            return nameundanschriftleistungsempfaenger;
        }

        /**
         * Legt den Wert der nameundanschriftleistungsempfaenger-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER }
         *     
         */
        public void setNAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER(RECHNUNGEN.RECHNUNG.NAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER value) {
            this.nameundanschriftleistungsempfaenger = value;
        }

        /**
         * Ruft den Wert der leistungen-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link RECHNUNGEN.RECHNUNG.LEISTUNGEN }
         *     
         */
        public RECHNUNGEN.RECHNUNG.LEISTUNGEN getLEISTUNGEN() {
            return leistungen;
        }

        /**
         * Legt den Wert der leistungen-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link RECHNUNGEN.RECHNUNG.LEISTUNGEN }
         *     
         */
        public void setLEISTUNGEN(RECHNUNGEN.RECHNUNG.LEISTUNGEN value) {
            this.leistungen = value;
        }

        /**
         * Ruft den Wert der steuernummer-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link RECHNUNGEN.RECHNUNG.STEUERNUMMER }
         *     
         */
        public RECHNUNGEN.RECHNUNG.STEUERNUMMER getSTEUERNUMMER() {
            return steuernummer;
        }

        /**
         * Legt den Wert der steuernummer-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link RECHNUNGEN.RECHNUNG.STEUERNUMMER }
         *     
         */
        public void setSTEUERNUMMER(RECHNUNGEN.RECHNUNG.STEUERNUMMER value) {
            this.steuernummer = value;
        }

        /**
         * Ruft den Wert der ausstellungsdatum-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAUSSTELLUNGSDATUM() {
            return ausstellungsdatum;
        }

        /**
         * Legt den Wert der ausstellungsdatum-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAUSSTELLUNGSDATUM(XMLGregorianCalendar value) {
            this.ausstellungsdatum = value;
        }

        /**
         * Ruft den Wert der rechnungsnummer-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECHNUNGSNUMMER() {
            return rechnungsnummer;
        }

        /**
         * Legt den Wert der rechnungsnummer-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECHNUNGSNUMMER(String value) {
            this.rechnungsnummer = value;
        }

        /**
         * Ruft den Wert der entgeldineuro-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getENTGELDINEURO() {
            return entgeldineuro;
        }

        /**
         * Legt den Wert der entgeldineuro-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setENTGELDINEURO(BigDecimal value) {
            this.entgeldineuro = value;
        }

        /**
         * Ruft den Wert der zahlungsmoeglichkeiten-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN }
         *     
         */
        public RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN getZAHLUNGSMOEGLICHKEITEN() {
            return zahlungsmoeglichkeiten;
        }

        /**
         * Legt den Wert der zahlungsmoeglichkeiten-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN }
         *     
         */
        public void setZAHLUNGSMOEGLICHKEITEN(RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN value) {
            this.zahlungsmoeglichkeiten = value;
        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="LEISTUNG" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="NUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
         *                   &lt;element name="WAEHRUNG">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="EUR"/>
         *                         &lt;enumeration value="USD"/>
         *                         &lt;enumeration value="AUD"/>
         *                         &lt;enumeration value="CHF"/>
         *                         &lt;enumeration value="GBP"/>
         *                         &lt;enumeration value="JPY"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="HANDELSUEBLICHER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="ANZAHL" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
         *                   &lt;element name="DATUM" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="MEHRWERTSTEUER" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "leistung"
        })
        public static class LEISTUNGEN {

            @XmlElement(name = "LEISTUNG", required = true)
            protected List<RECHNUNGEN.RECHNUNG.LEISTUNGEN.LEISTUNG> leistung;

            /**
             * Gets the value of the leistung property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the leistung property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLEISTUNG().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link RECHNUNGEN.RECHNUNG.LEISTUNGEN.LEISTUNG }
             * 
             * 
             */
            public List<RECHNUNGEN.RECHNUNG.LEISTUNGEN.LEISTUNG> getLEISTUNG() {
                if (leistung == null) {
                    leistung = new ArrayList<RECHNUNGEN.RECHNUNG.LEISTUNGEN.LEISTUNG>();
                }
                return this.leistung;
            }


            /**
             * <p>Java-Klasse für anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="NUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
             *         &lt;element name="WAEHRUNG">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="EUR"/>
             *               &lt;enumeration value="USD"/>
             *               &lt;enumeration value="AUD"/>
             *               &lt;enumeration value="CHF"/>
             *               &lt;enumeration value="GBP"/>
             *               &lt;enumeration value="JPY"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="HANDELSUEBLICHER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ANZAHL" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
             *         &lt;element name="DATUM" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
             *       &lt;/sequence>
             *       &lt;attribute name="MEHRWERTSTEUER" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "nummer",
                "waehrung",
                "handelsueblichername",
                "anzahl",
                "datum"
            })
            public static class LEISTUNG {

                @XmlElement(name = "NUMMER")
                @XmlSchemaType(name = "unsignedInt")
                protected long nummer;
                @XmlElement(name = "WAEHRUNG", required = true)
                protected String waehrung;
                @XmlElement(name = "HANDELSUEBLICHER_NAME", required = true)
                protected String handelsueblichername;
                @XmlElement(name = "ANZAHL")
                @XmlSchemaType(name = "unsignedInt")
                protected Long anzahl;
                @XmlElement(name = "DATUM")
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar datum;
                @XmlAttribute(name = "MEHRWERTSTEUER")
                protected String mehrwertsteuer;

                /**
                 * Ruft den Wert der nummer-Eigenschaft ab.
                 * 
                 */
                public long getNUMMER() {
                    return nummer;
                }

                /**
                 * Legt den Wert der nummer-Eigenschaft fest.
                 * 
                 */
                public void setNUMMER(long value) {
                    this.nummer = value;
                }

                /**
                 * Ruft den Wert der waehrung-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getWAEHRUNG() {
                    return waehrung;
                }

                /**
                 * Legt den Wert der waehrung-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setWAEHRUNG(String value) {
                    this.waehrung = value;
                }

                /**
                 * Ruft den Wert der handelsueblichername-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHANDELSUEBLICHERNAME() {
                    return handelsueblichername;
                }

                /**
                 * Legt den Wert der handelsueblichername-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHANDELSUEBLICHERNAME(String value) {
                    this.handelsueblichername = value;
                }

                /**
                 * Ruft den Wert der anzahl-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Long }
                 *     
                 */
                public Long getANZAHL() {
                    return anzahl;
                }

                /**
                 * Legt den Wert der anzahl-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Long }
                 *     
                 */
                public void setANZAHL(Long value) {
                    this.anzahl = value;
                }

                /**
                 * Ruft den Wert der datum-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDATUM() {
                    return datum;
                }

                /**
                 * Legt den Wert der datum-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDATUM(XMLGregorianCalendar value) {
                    this.datum = value;
                }

                /**
                 * Ruft den Wert der mehrwertsteuer-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMEHRWERTSTEUER() {
                    return mehrwertsteuer;
                }

                /**
                 * Legt den Wert der mehrwertsteuer-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMEHRWERTSTEUER(String value) {
                    this.mehrwertsteuer = value;
                }

            }

        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="STRASSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TELEFONNUMMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FAX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="E-MAIL_ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name",
            "strasse",
            "adresse",
            "telefonnummer",
            "fax",
            "emailadresse"
        })
        public static class NAMEUNDANSCHRIFTLEISTENDERUNTERNEHMER {

            @XmlElement(name = "NAME", required = true)
            protected String name;
            @XmlElement(name = "STRASSE", required = true)
            protected String strasse;
            @XmlElement(name = "ADRESSE", required = true)
            protected String adresse;
            @XmlElement(name = "TELEFONNUMMER")
            protected String telefonnummer;
            @XmlElement(name = "FAX")
            protected String fax;
            @XmlElement(name = "E-MAIL_ADRESSE")
            protected String emailadresse;

            /**
             * Ruft den Wert der name-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNAME() {
                return name;
            }

            /**
             * Legt den Wert der name-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNAME(String value) {
                this.name = value;
            }

            /**
             * Ruft den Wert der strasse-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSTRASSE() {
                return strasse;
            }

            /**
             * Legt den Wert der strasse-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSTRASSE(String value) {
                this.strasse = value;
            }

            /**
             * Ruft den Wert der adresse-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getADRESSE() {
                return adresse;
            }

            /**
             * Legt den Wert der adresse-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setADRESSE(String value) {
                this.adresse = value;
            }

            /**
             * Ruft den Wert der telefonnummer-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTELEFONNUMMER() {
                return telefonnummer;
            }

            /**
             * Legt den Wert der telefonnummer-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTELEFONNUMMER(String value) {
                this.telefonnummer = value;
            }

            /**
             * Ruft den Wert der fax-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFAX() {
                return fax;
            }

            /**
             * Legt den Wert der fax-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFAX(String value) {
                this.fax = value;
            }

            /**
             * Ruft den Wert der emailadresse-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEMAILADRESSE() {
                return emailadresse;
            }

            /**
             * Legt den Wert der emailadresse-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEMAILADRESSE(String value) {
                this.emailadresse = value;
            }

        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="ANREDE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="STRASSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "anrede",
            "name",
            "strasse",
            "adresse"
        })
        public static class NAMEUNDANSCHRIFTLEISTUNGSEMPFAENGER {

            @XmlElement(name = "ANREDE")
            protected String anrede;
            @XmlElement(name = "NAME", required = true)
            protected String name;
            @XmlElement(name = "STRASSE", required = true)
            protected String strasse;
            @XmlElement(name = "ADRESSE", required = true)
            protected String adresse;

            /**
             * Ruft den Wert der anrede-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getANREDE() {
                return anrede;
            }

            /**
             * Legt den Wert der anrede-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setANREDE(String value) {
                this.anrede = value;
            }

            /**
             * Ruft den Wert der name-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNAME() {
                return name;
            }

            /**
             * Legt den Wert der name-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNAME(String value) {
                this.name = value;
            }

            /**
             * Ruft den Wert der strasse-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSTRASSE() {
                return strasse;
            }

            /**
             * Legt den Wert der strasse-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSTRASSE(String value) {
                this.strasse = value;
            }

            /**
             * Ruft den Wert der adresse-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getADRESSE() {
                return adresse;
            }

            /**
             * Legt den Wert der adresse-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setADRESSE(String value) {
                this.adresse = value;
            }

        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;element name="STEUERNUMMER_UNTERNEHMER" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/>
         *         &lt;element name="UMSATZSTEUER-IDENTIFIKATIONSNUMMER" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "steuernummerunternehmer",
            "umsatzsteueridentifikationsnummer"
        })
        public static class STEUERNUMMER {

            @XmlElement(name = "STEUERNUMMER_UNTERNEHMER")
            @XmlSchemaType(name = "unsignedLong")
            protected BigInteger steuernummerunternehmer;
            @XmlElement(name = "UMSATZSTEUER-IDENTIFIKATIONSNUMMER")
            protected String umsatzsteueridentifikationsnummer;

            /**
             * Ruft den Wert der steuernummerunternehmer-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getSTEUERNUMMERUNTERNEHMER() {
                return steuernummerunternehmer;
            }

            /**
             * Legt den Wert der steuernummerunternehmer-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setSTEUERNUMMERUNTERNEHMER(BigInteger value) {
                this.steuernummerunternehmer = value;
            }

            /**
             * Ruft den Wert der umsatzsteueridentifikationsnummer-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUMSATZSTEUERIDENTIFIKATIONSNUMMER() {
                return umsatzsteueridentifikationsnummer;
            }

            /**
             * Legt den Wert der umsatzsteueridentifikationsnummer-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUMSATZSTEUERIDENTIFIKATIONSNUMMER(String value) {
                this.umsatzsteueridentifikationsnummer = value;
            }

        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="DEUTSCHLANDINTERN" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="KONTOINHABER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="BANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="KONTONUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
         *                   &lt;element name="BLZ" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
         *                 &lt;/all>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="AUSSERHALB_DEUTSCHLANDS" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="KONTONUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
         *                   &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="KRYPTOWAEHRUNG" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BITCOIN_ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "deutschlandintern",
            "ausserhalbdeutschlands",
            "kryptowaehrung"
        })
        public static class ZAHLUNGSMOEGLICHKEITEN {

            @XmlElement(name = "DEUTSCHLANDINTERN")
            protected RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.DEUTSCHLANDINTERN deutschlandintern;
            @XmlElement(name = "AUSSERHALB_DEUTSCHLANDS")
            protected RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.AUSSERHALBDEUTSCHLANDS ausserhalbdeutschlands;
            @XmlElement(name = "KRYPTOWAEHRUNG")
            protected RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.KRYPTOWAEHRUNG kryptowaehrung;

            /**
             * Ruft den Wert der deutschlandintern-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.DEUTSCHLANDINTERN }
             *     
             */
            public RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.DEUTSCHLANDINTERN getDEUTSCHLANDINTERN() {
                return deutschlandintern;
            }

            /**
             * Legt den Wert der deutschlandintern-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.DEUTSCHLANDINTERN }
             *     
             */
            public void setDEUTSCHLANDINTERN(RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.DEUTSCHLANDINTERN value) {
                this.deutschlandintern = value;
            }

            /**
             * Ruft den Wert der ausserhalbdeutschlands-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.AUSSERHALBDEUTSCHLANDS }
             *     
             */
            public RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.AUSSERHALBDEUTSCHLANDS getAUSSERHALBDEUTSCHLANDS() {
                return ausserhalbdeutschlands;
            }

            /**
             * Legt den Wert der ausserhalbdeutschlands-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.AUSSERHALBDEUTSCHLANDS }
             *     
             */
            public void setAUSSERHALBDEUTSCHLANDS(RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.AUSSERHALBDEUTSCHLANDS value) {
                this.ausserhalbdeutschlands = value;
            }

            /**
             * Ruft den Wert der kryptowaehrung-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.KRYPTOWAEHRUNG }
             *     
             */
            public RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.KRYPTOWAEHRUNG getKRYPTOWAEHRUNG() {
                return kryptowaehrung;
            }

            /**
             * Legt den Wert der kryptowaehrung-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.KRYPTOWAEHRUNG }
             *     
             */
            public void setKRYPTOWAEHRUNG(RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN.KRYPTOWAEHRUNG value) {
                this.kryptowaehrung = value;
            }


            /**
             * <p>Java-Klasse für anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="KONTONUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
             *         &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "kontonummer",
                "bic"
            })
            public static class AUSSERHALBDEUTSCHLANDS {

                @XmlElement(name = "KONTONUMMER")
                @XmlSchemaType(name = "unsignedInt")
                protected long kontonummer;
                @XmlElement(name = "BIC", required = true)
                protected String bic;

                /**
                 * Ruft den Wert der kontonummer-Eigenschaft ab.
                 * 
                 */
                public long getKONTONUMMER() {
                    return kontonummer;
                }

                /**
                 * Legt den Wert der kontonummer-Eigenschaft fest.
                 * 
                 */
                public void setKONTONUMMER(long value) {
                    this.kontonummer = value;
                }

                /**
                 * Ruft den Wert der bic-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBIC() {
                    return bic;
                }

                /**
                 * Legt den Wert der bic-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBIC(String value) {
                    this.bic = value;
                }

            }


            /**
             * <p>Java-Klasse für anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;all>
             *         &lt;element name="KONTOINHABER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="BANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="BIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="KONTONUMMER" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
             *         &lt;element name="BLZ" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" minOccurs="0"/>
             *       &lt;/all>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {

            })
            public static class DEUTSCHLANDINTERN {

                @XmlElement(name = "KONTOINHABER")
                protected String kontoinhaber;
                @XmlElement(name = "BANK")
                protected String bank;
                @XmlElement(name = "BIC")
                protected String bic;
                @XmlElement(name = "IBAN")
                protected String iban;
                @XmlElement(name = "KONTONUMMER")
                @XmlSchemaType(name = "unsignedLong")
                protected BigInteger kontonummer;
                @XmlElement(name = "BLZ")
                @XmlSchemaType(name = "unsignedLong")
                protected BigInteger blz;

                /**
                 * Ruft den Wert der kontoinhaber-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getKONTOINHABER() {
                    return kontoinhaber;
                }

                /**
                 * Legt den Wert der kontoinhaber-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setKONTOINHABER(String value) {
                    this.kontoinhaber = value;
                }

                /**
                 * Ruft den Wert der bank-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBANK() {
                    return bank;
                }

                /**
                 * Legt den Wert der bank-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBANK(String value) {
                    this.bank = value;
                }

                /**
                 * Ruft den Wert der bic-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBIC() {
                    return bic;
                }

                /**
                 * Legt den Wert der bic-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBIC(String value) {
                    this.bic = value;
                }

                /**
                 * Ruft den Wert der iban-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIBAN() {
                    return iban;
                }

                /**
                 * Legt den Wert der iban-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIBAN(String value) {
                    this.iban = value;
                }

                /**
                 * Ruft den Wert der kontonummer-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getKONTONUMMER() {
                    return kontonummer;
                }

                /**
                 * Legt den Wert der kontonummer-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setKONTONUMMER(BigInteger value) {
                    this.kontonummer = value;
                }

                /**
                 * Ruft den Wert der blz-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getBLZ() {
                    return blz;
                }

                /**
                 * Legt den Wert der blz-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setBLZ(BigInteger value) {
                    this.blz = value;
                }

            }


            /**
             * <p>Java-Klasse für anonymous complex type.
             * 
             * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="BITCOIN_ADRESSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "bitcoinadresse"
            })
            public static class KRYPTOWAEHRUNG {

                @XmlElement(name = "BITCOIN_ADRESSE", required = true)
                protected String bitcoinadresse;

                /**
                 * Ruft den Wert der bitcoinadresse-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBITCOINADRESSE() {
                    return bitcoinadresse;
                }

                /**
                 * Legt den Wert der bitcoinadresse-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBITCOINADRESSE(String value) {
                    this.bitcoinadresse = value;
                }

            }

        }

    }

}

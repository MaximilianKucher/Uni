import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * JDBC Aufgabe 3c
 * 
 * Diese Klasse bietet Zugriff auf die Zusammenhänge zwischen Kunden und
 * Lieferanten.
 * 
  * Ziele
 * - Komplexe Join-Abfragen unter JDBC
 * - Vermeiden von Code-Redundanzen / Designentscheidungen Java vs. SQL
 * - Saubere Ressourcen-Freigabe
 * 
 * In dieser Datei sollen Sie: 
 * 1. getKundeLieferanten schreiben.
 *    Die folgende Ausgabe wird beim Aufruf der main() Methode erwartet:
 *
 *     kunde                          | knr         | lieferant                      | lnr         
 *     CHAR                           | NUMBER      | CHAR                           | NUMBER            
 *    --------------------------------+-------------+--------------------------------+-------------
 *     Biker Ecke                     |           5 |                                |             
 *     Fahrrad Shop                   |           1 | Firma Gerti Schmidtner         |           1 
 *     Fahrräder Hammerl              |           6 | Firma Gerti Schmidtner         |           1 
 *     Fahrräder Hammerl              |           6 | MSM GmbH                       |           5 
 *     Maier Ingrid                   |           3 |                                |             
 *     Rafa - Seger KG                |           4 | Firma Gerti Schmidtner         |           1 
 *     Rafa - Seger KG                |           4 | Rauch GmbH                     |           2 
 *     Zweirad-Center Staller         |           2 |                                |             
 *     (8 rows)
 *
 *    "kunde";"knr";"lieferant";"lnr"
 *    "Rafa - Seger KG";4;"Firma Gerti Schmidtner";1
 *    "Rafa - Seger KG";4;"Rauch GmbH";2
 *    
 *  2. Für eine saubere Ressourcen-Freigabe sorgen.
 *
 *  3. Diese Fragen müssen bei der Abgabe beantwortet sein:
 *
 *  3.a Warum und in welchen Fällen bieten Prepared Statements Performance-
 *      vorteile gegenüber dynamisch generierten Abfragen?
 *      
 *  Antwort: Prepared Statements bieten besonders bei SQL Abfragen mit Parametern einen Performance-Vorteil, da diese schon zum Zeitpunkt der 
 *          Erzeugung ein Statement als String übergeben bekommen. Das Statement wird somit sofort zum DBMS gesendet wo es kompiliert wird. Daraus folgt,
 *          dass das prepared Statment objekt nicht nur ein SQL-Statement enthält, sondern sin SQL-Statment das schon vorkompiliert wurde.
 *          Dies bedeutet wiederum bedeutet, dass sobald das prepared Statement ausgeführt wird, das DBMS das SQL-Statement sofort ausführen kann, ohne es
 *          kompilieren zu müssen. Der große Vorteil liegt nun darin, dass man für SQL-Statements mit parametern einfach immer dasselbe Statement benutzen
 *          kann und dieses lediglich mit neuen Parametern füllen muss.
 *  
 *  --------------------------------------------------------------------------------------------------------------------------------------------------
 *  
 *  3.b Was sind die Sicherheitsvorteile von Prepared Statements gegenüber
 *      dynamisch erzeugten Abfragen?
 *        
 *  Antwort: Bei dynamisch generierten Abfragen werden Code und Daten auf einmal an das DBMS gesendet und können so leicht manipuliert werden.
 *          Bei der Benutzung von Prepared Statements werden hingegen die Daten vom Code durch die "?" Platzhalter getrennt und in zwei verschiedenen 
 *          Anfragen an das DBMS gesendet.
 */
public class CustomerSupplierRelations {

	/**
	 * Die verwendete SQL Connection.
	 */
	private Connection connection;

	/**
	 * Ein Statement, das Lieferanten für Kunden listet.
	 */
	private PreparedStatement stmtKundeLieferanten;

	/**
	 * Konstruktor
     * <p>
	 * Erstellen der Datenbankverbindung über SQLConnector.
	 *
	 * @throws SQLException Falls ein Verbindungsaufbau oder ein Statement scheitert
	 */
	public CustomerSupplierRelations() throws SQLException {
	  
		// TODO begin
	    SQLConnector connector = SQLConnector.getTestInstance();
	    this.connection = connector.getConnection();
		// TODO end
	}

	/**
	 * Gibt ein ResultSet zurück, das alle Zulieferer, von denen Teile für
	 * einen Kunden mit der gegebenen Nummer nachgefragt wurden, auflistet.
	 * <p>
	 * Stellt sicher, dass ein Kunde auch dann gelistet wird, wenn keine
	 * Zulieferer gefunden werden.
	 *
	 * @param kdNr Die Kundennr des Kunden, für den Zulieferer ermittelt
	 *             werden sollen, bei der Nummer 0 wird die Liste für alle
	 *             Kunden erzeugt
	 * @return Zulieferer für einen gegebenen Kunden
	 * @throws SQLException Falls das ausgeführe Statement scheitert
	 */
	public ResultSet getKundeLieferanten(int kdNr) throws SQLException {
	    
		// TODO begin
	    String statement = "SELECT DISTINCT Kunde.name AS kunde, Kunde.nr AS knr, Lieferant.name AS lieferant, Lieferant.nr AS lnr FROM Lieferant " + 
	        "JOIN Lieferung ON Lieferung.liefnr = Lieferant.nr " + 
	        "JOIN Teilestamm ON Teilestamm.Teilnr = Lieferung.teilnr " + 
	        "JOIN Auftragsposten ON Auftragsposten.Teilnr = Teilestamm.Teilnr " + 
	        "JOIN Auftrag ON Auftrag.auftrnr = Auftragsposten.auftrnr " + 
	        "RIGHT OUTER JOIN Kunde ON Kunde.nr = Auftrag.kundnr "; 
	    String whereClause = "WHERE Kunde.nr = ?";
	    
	    if(kdNr == 0) {
          this.stmtKundeLieferanten = this.connection.prepareStatement(statement);
        } else if (kdNr > 0) {
          this.stmtKundeLieferanten = this.connection.prepareStatement(statement + whereClause);
          this.stmtKundeLieferanten.setInt(1, kdNr);
        } else {
          return null;
        }

	    return this.stmtKundeLieferanten.executeQuery();
		// TODO end
	}


	/**
	 * Gibt alle Resourcen frei.
	 */
	public void close() throws SQLException {
		// Hinweis: Stellen Sie sicher, dass dies wirklich aufgerufen wird.
		// TODO begin
	    this.stmtKundeLieferanten.close();
	    this.connection.close();
		// TODO end
	}

	/**
	 * Diese Methode wird zum Testen der Implementierung verwendet.
	 *
	 * @param args Kommandozeilenargumente, nicht verwendet
	 * @throws SQLException Bei jedem SQL Fehler
	 */
	public static void main(String[] args) throws SQLException {
	    try {
	      CustomerSupplierRelations csr = new CustomerSupplierRelations();

	      ResultSet rs = csr.getKundeLieferanten(0);
	      Output.printResultTable(rs, System.out);

	      rs = csr.getKundeLieferanten(4);
	      Output.resultToCsv(rs, System.out);
//	      System.out.println();
//	      
//	      rs = csr.getKundeLieferanten(6);
//	      Output.resultToCsv(rs, System.out);

	      // Hinweis: schließen sie alle Ressourcen
	      // TODO begin
	      rs.close();
	      csr.close();
	      
	    } catch(SQLException e) {
          System.out.println("SQL Exception: " + e.getLocalizedMessage());
          SQLException nextException = e.getNextException();
          while (nextException != null){
            System.out.println("SQL Exception: " + nextException.getLocalizedMessage() );
            nextException = nextException.getNextException();
          }
          e.printStackTrace();
        }
	    // TODO end
	}

}

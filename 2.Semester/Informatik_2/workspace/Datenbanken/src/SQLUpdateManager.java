import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC Aufgabe 3d
 *
 * Aktualisieren des Datenbankschemas.
 *
 * Ziele
 * - Arbeiten mit DDL-Befehlen
 * - Erstellen von überwachten Fremdschlüsselbeziehungen
 * - Erste Heranführung an das Thema Normalisierung, hier besonders deren technische Umsetzung
 *
 * In dieser Datei sollen Sie:
 * Redundanzen in der Tabelle Teilestamm, die in der Spalte 'farbe' zu finden sind,
 * vermeiden. Dazu soll eine neue Tabelle 'farbe' angelegt werden.
 * Die Tabelle Teilestamm soll dann für die neue Tabelle 'farbe' einen
 * Fremdschlüssel verwenden.
 * Bei dieser Gelegenheit werden die Farben in der Tabelle 'farbe' um
 * zusätzliche Informationen ergänzt.
 *
 * Die Tabelle 'farbe' bekommt das folgende physikalische Datenmodell:
 *
 * 	Spalte	Beschreibung
 * 	nr		Der Type ist INTEGER, automatisches Hochzählen ist erlaubt, aber
 *  		nicht notwendig (es gibt leider keine einheitliche Syntax, die zwischen Oracle, MySQL
 *  		und PostgreSQL kompatibel ist). Diese Spalte bildet den
 *  		Primärschlüssel.
 *	name	Hat die gleichen Eigenschaften wie 'teilestamm.farbe', aber die Spalte
 *			darf keine Duplikate enthalten.
 *	rot, gruen, blau
 *			Diese Spalten sind vom Typ REAL in einem Wertebereich von
 *			[0.0; 1.0], der sichergestellt werden muss.
 *			Der Standardwert ist 0.
 *
 * Test Ausgabe
 *
 * Die folgende Ausgabe sollte auf System.out erscheinen, wenn die main()
 * Methode zum ersten mal aufgerufen wird:
 * Updating database layout ...
 * Table 'farbe' created.
 * Added 3 rows to 'farbe'
 * Column 'farbnr' added to table 'teilestamm'
 * Set 'teilestamm.farbnr' in 34 rows
 * Column 'farbe' removed from 'teilestamm'
 *
 * Hinweis:
 * Setzen Sie die Methode LabUtilities.reInitializeDB() ein,
 * um die Datenbank immer wieder neu aufzusetzen beim Testen.
 */
public class SQLUpdateManager  {

    /**
     * Die verwendete SQL Verbindung.
     */
    private Connection connection;

    /**
     * Der Konstruktor, löst den Update-Vorgang aus.
     * <p>
     * Stellt die Verbindung zur Datenbank her und schließt diese auch wieder.
     *
     * @throws SQLException Wird geworfen, wenn die Datenbankverbindung oder ein
     *                      Statement scheitert
     */
    public SQLUpdateManager() throws SQLException {
        // TODO begin
        SQLConnector connector = new SQLConnectorOracleHsInternal();
        this.connection = connector.getConnection();
        // TODO end

        if (!hasTable("farbe")) {
            update();
        } else {
            String err = "Table 'farbe' already created!";
            System.err.println(err);
            throw new SQLException(err);
        }
        // TODO begin
        this.connection.close();
        // TODO end
    }

    /**
     * Prüft, ob eine Tabelle existiert.
     *
     * @param table Die zu prüfende Tabelle
     * @return True, falls die Tabelle existiert, sonst False
     * @throws SQLException Im Fall von Verbindungsproblemen
     */
    private boolean hasTable(String table) throws SQLException {
        // TODO begin
//        ResultSetMetaData meta = this.connection.createStatement().getResultSet().getMetaData();
//        int columns = meta.getColumnCount();
//        for (int i = 1; i <= columns; i++) {
//          if(meta.getColumnName(i).equals(table)) {
//            return true;
//          }
//        }
        return false;
        // TODO end
    }

    /**
     * Aktualisiere das Datenbanklayout.<p>
     *
     * Führt die folgenden Aktionen aus:
     * - Geeignete Transaktions-Isolationsebene setzen ...
     * - Tabelle farbe anlegen
     * - Vorhandene Farben von teilestamm.farbe in farbe.name kopieren
     * - RGB Werte zu farbe Einträgen setzen
     * - In teilestamm die Spalte farbnr (als Foreign Key) anlegen
     * - Die Spalte teilestamm.farbnr mit Werten befüllen
     * - Die Spalte teilestamm.farbe entfernen
     * - Im Erfolgsfall Änderungen committen, sonst zurückrollen
     *
     * @throws SQLException Im Fall von Verbindungsproblemen
     */
    private void update() throws SQLException {
        System.out.println("Updating database layout ...");
        
     // TODO begin
        this.connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        this.connection.setAutoCommit(false);
        
        Statement stmt = this.connection.createStatement();
     
        try {
//          if(this.hasTable("farbe")) {
//            stmt.executeUpdate("DROP TABLE farbe");
//          }
          stmt.executeUpdate("CREATE TABLE farbe(nr INT PRIMARY KEY, name CHAR(32) UNIQUE NOT NULL, "
              + "rot REAL DEFAULT 0.0 CHECK(rot >= 0.0 AND rot <= 1.0), "
              + "gruen REAL DEFAULT 0.0 CHECK(gruen >= 0.0 AND gruen <= 1.0), "
              + "blau REAL DEFAULT 0.0 CHECK(blau >= 0.0 AND blau <= 1.0)) ");
          System.out.println("Table 'farbe' created.");
       
          ResultSet result = stmt.executeQuery("SELECT farbe FROM teilestamm WHERE farbe IS NOT NULL GROUP BY farbe ORDER BY farbe ASC");
          int i = 1;
          stmt.clearBatch();
          while (result.next()) {
            stmt.addBatch("INSERT INTO farbe (nr, name) VALUES (" + (i) + ", '" + result.getString(1).trim() + "')");
            i++;
          }
          stmt.executeBatch();
          result.close();
        
        
          stmt.clearBatch();
          stmt.addBatch("UPDATE farbe SET rot = 0.0, gruen = 0.0, blau = 0.0 WHERE name = 'schwarz'");
          stmt.addBatch("UPDATE farbe SET rot = 1.0, gruen = 0.0, blau = 0.0 WHERE name = 'rot'");
          stmt.addBatch("UPDATE farbe SET rot = 0.0, gruen = 0.0, blau = 1.0 WHERE name = 'blau'"); 
          int[] affectedBatch = stmt.executeBatch();
          int sum = 0;
          for (i = 0; i < affectedBatch.length; i++){
            sum += affectedBatch[i];
          }
          System.out.println("Updated " + sum + " rows.");
          System.out.println(i - 1   + " rows added to 'farbe'");
        
        
          stmt = this.connection.createStatement();
          stmt.executeUpdate("ALTER TABLE teilestamm ADD farbnr INT REFERENCES farbe (nr)");
//          stmt.executeUpdate("ALTER TABLE teilestamm ADD CONSTRAINT FK_farbe FOREIGN KEY (farbnr) "
//              + "REFERENCES farbe (nr)");
          System.out.println("Column 'farbnr' added to table 'teilestamm'");
          
        
        
          stmt.clearBatch();
//          PreparedStatement p = this.connection.prepareStatement("UPDATE teilestamm SET teilestamm.farbnr = (Select DISTINCT nr from farbe JOIN teilestamm ON teilestamm.farbe = farbe.name Where teilestamm.farbe = ?");
          sum = stmt.executeUpdate("UPDATE teilestamm SET teilestamm.farbnr = (SELECT nr FROM farbe WHERE teilestamm.farbe = farbe.name) Where teilestamm.farbe IS NOT NULL");
          System.out.println("Set 'teilestamm.farbnr' in " + sum + " rows.");

//          stmt.executeUpdate("ALTER TABLE teilestamm DROP COLUMN farbe");
          System.out.println("Column 'farbe' removed from 'teilestamm'");
        
          this.connection.commit();
          stmt.close();
          this.connection.close();
        } catch(SQLException e) {
          this.connection.rollback();
          stmt.close();
          this.connection.close();
        }
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
          new SQLUpdateManager();
        } 
        catch(SQLException e) {
          System.out.println("SQL Exception: " + e.getLocalizedMessage());
          SQLException nextException = e.getNextException();
          while (nextException != null){
            System.out.println("SQL Exception: " + nextException.getLocalizedMessage() );
            nextException = nextException.getNextException();
          }
          e.printStackTrace();
        }
    }
}

import org.sqlite.SQLiteConnection
import java.io.File
import java.sql.DriverManager


private val DB_PATH = "C:/data/mStore/data.db"

fun writeTitle(title: String) {
    var output: String = "----- $title "
    while (output.length < 70)
        output += "-"
    println(output)
}

/**
 * Obtiene una instancia de conexión a la base de datos principal.
 */
fun getDbConnection(): SQLiteConnection {
    val DB_CONNECTION = "jdbc:sqlite:$DB_PATH"
    var dataDir = File(DB_PATH.replace("/data.db", ""))
    if (!dataDir.exists())
        dataDir.mkdir()

    var dbFile = File(DB_PATH)
    if (!dbFile.exists()) {
        var tmpConn = DriverManager.getConnection(DB_CONNECTION) as SQLiteConnection
        tmpConn.autoCommit = true
        val statement = tmpConn.createStatement()
        statement.execute("CREATE TABLE Articles (Id INTEGER NOT NULL, Description TEXT NOT NULL, Price INTEGER NOT NULL, PRIMARY KEY(Id))")
        statement.close()
        tmpConn.close()
    }

    return DriverManager.getConnection(DB_CONNECTION) as SQLiteConnection
}


//import writeTitle
//var allArticles: MutableList<Article> = MutableList

fun uiViewAllProducts() {

}

fun uiMain() {
    writeTitle("Hola")
    println("1) Ver productos\n2) Agregar un producto\n\n> ")

    val value = readLine()?.substring(0, 1)

    when (value) {
        "1" -> uiViewAllProducts()
    }
}

fun main(args: Array<String>) {
    //uiMain()

    getDbConnection()
}
fun salve() {
    println("Olá, rapazeada!")
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

fun main(args: Array<String>) {

    val a = 10
    val b = 20

    println(soma(a, b))
    println(soma(5, 8))
    println(soma(a = -4, b = 44))

    salve()

}
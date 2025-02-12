fun main(args: Array<String>) {

    var cidades = arrayOf<String>("São Paulo", "Rio de Janeiro", "Curitiba")

    println(cidades[1])
    println(cidades[2])

    cidades[2] = "Florianópolis"

    println(cidades[2])

    println(cidades.isEmpty())
    println(cidades.size)

    var frutas = ArrayList<String>()

    frutas.add("Banana")
    frutas.add("Maçã")
    frutas.add("Pêra")
    frutas.add("Pêra")

    println(frutas.contains("Uva"))

    println(frutas)

    frutas.remove("Banana")

}
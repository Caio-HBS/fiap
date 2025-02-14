import java.util.*

fun main() {

    // Filter ----------------------------------------
    val numeros = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    println("Lista completa: $numeros")

    val pares = numeros.filter {
        it % 2 == 0
    }

    println("Números pares da lista: $pares")


    // Map -------------------------------------------
    val frutas = listOf("banana", "maçã", "abacaxi", "morango", "laranja", "abacate")

    println("\nFrutas: $frutas")

    val frutasMaiusculas = frutas.map {
        it.uppercase(Locale.getDefault())
    }

    println("Frutas maiúsculas: $frutasMaiusculas")


    // Reduce ----------------------------------------
    val numeros2 = listOf(1, 2, 3, 4, 5)

    println("\nLista completa: $numeros2")

    val somaReduzido = numeros2.reduce {
        atual, novo -> atual + novo
    }

    println("Reduzido: $somaReduzido")

}
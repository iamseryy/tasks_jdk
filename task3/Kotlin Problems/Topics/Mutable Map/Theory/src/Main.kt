data class Musician(var name: String = "", var band: String = "", var role: String = "")

fun main() {
    val musician = Musician()

    musician.apply {
        name = readln()
        band = readln()
        role = readln()
    }

    // Write your code here

    val num = musician.let {
        println(musician)
        it.name.length
    }.let {
        println(it / 4)
        it / 4
    }.run { this + 10}

    println(num)

    val b0: Byte = 2
    val s0: Short = 10
    val n0: Int = 5
    val l0: Long = 14
    val f0: Float = 11.4f

    val b: Byte = 5
    val s: Short = 2 + b0
    val n: Int = s0.toByte() + 2
    val l: Long = n0 + 4
    val f: Float = l0.toFloat() + 1
    val d: Double = f0 / 1


}
import java.awt.print.Printable

enum class Nivel (val printableName: String) { BASICO("Básico"), INTERMEDIARIO("Intermediário"), AVANCADO("Avançado") }

data class Usuario(var nome: String, var sobrenome: String, val RA: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun imprimirInfo(){
        println("Curso: ${nome} \nNível: ${nivel.printableName} \n")
        conteudos.forEach {println("Disciplina: ${it.nome} || Duração: ${it.duracao}")}
        println("\nAlunos matriculados:")
        inscritos.forEach {println("Nome: ${it.nome} ${it.sobrenome}, RA: ${it.RA} ")}
    }
}

fun main() {

    val conteudoKotlin = mutableListOf(
        ConteudoEducacional("Git", 60),
        ConteudoEducacional("Data Types", 60),
        ConteudoEducacional("Collections", 120)
    )

    var curso = Formacao(nome="Kotlin",nivel=Nivel.BASICO,conteudos=conteudoKotlin)

    curso.matricular(Usuario(nome="Ana", sobrenome = "Alves", RA = 100))
    curso.matricular(Usuario(nome="Bruna", sobrenome = "Monteiro", RA = 101))
    curso.matricular(Usuario(nome="Camila", sobrenome = "Ribeiro", RA = 102))
    curso.imprimirInfo()

}
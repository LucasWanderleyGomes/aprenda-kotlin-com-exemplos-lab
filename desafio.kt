enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
data class Usuario(val nome: String)
data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("✅ ${usuario.nome} matriculado na formação $nome")
    }
}

fun main() {
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 30, Nivel.BASICO)
    val kotlinAvancado = ConteudoEducacional("Kotlin Avançado", 90, Nivel.DIFICIL)
    val androidDev = ConteudoEducacional("Android Development", 120, Nivel.INTERMEDIARIO)
    
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(kotlinBasico, kotlinAvancado), Nivel.INTERMEDIARIO)
    val formacaoAndroid = Formacao("Formação Android", listOf(kotlinBasico, androidDev), Nivel.INTERMEDIARIO)
    
    val usuario1 = Usuario("João Silva")
    val usuario2 = Usuario("Maria Santos")
    val usuario3 = Usuario("Carlos Oliveira")
    
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoAndroid.matricular(usuario3)
    formacaoAndroid.matricular(usuario1)
    
    println("\n📊 Resumo das Matrículas:")
    println("Formação: ${formacaoKotlin.nome} | Nível: ${formacaoKotlin.nivel} | Inscritos: ${formacaoKotlin.inscritos.size}")
    println("Formação: ${formacaoAndroid.nome} | Nível: ${formacaoAndroid.nivel} | Inscritos: ${formacaoAndroid.inscritos.size}")
    
    println("\nLista de inscritos em Kotlin: ${formacaoKotlin.inscritos}")
}
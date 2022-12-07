
data class Usuario(val id: Int, val nome: String, val idade: Int)

data class ConteudoEducacional(val nome: String, var nivel: Nivel, val duracao: Int)

enum class Nivel { Basico, Intermediario, Avancado }

data class Formacao(var nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listaDeContatos() {
        for (usuario in inscritos) {
            println("Id: ${usuario.id} - Nome: ${usuario.nome} - Idade: ${usuario.idade}")
        }
    }
}

fun main() {

    //Criar Lista de cursos
    val linuxFundamentals = ConteudoEducacional("Formação Linux Fundamentals", Nivel.Basico, 23)
    val uxDesigner = ConteudoEducacional("Formação UX Designer", Nivel.Intermediario, 30)
    val webtresFundamentals = ConteudoEducacional("Formação Web3 Fundamentals", Nivel.Avancado, 28)
    val listaDeConteudo = mutableListOf<ConteudoEducacional>()
    listaDeConteudo.add(linuxFundamentals)
    listaDeConteudo.add(uxDesigner)
    listaDeConteudo.add(webtresFundamentals)


    val LinuxFundamentalsFormacao = Formacao("Linux Fundamentals", listaDeConteudo)
    val UxDesignerFormacao = Formacao("UX Designer", listaDeConteudo)
    val WebtresFundamentalsFormacao = Formacao("Web3 Fundamentals", listaDeConteudo)

    //Criar lista de usuarios
    val usuario1 = Usuario(1, "Thainan", 17)
    val usuario2 = Usuario(2, "Suely", 55)
    val usuario3 = Usuario(3, "Hildegard", 42)
    val usuario4 = Usuario(4, "Isac", 26)

    //matricular usuarios na formação
    LinuxFundamentalsFormacao.matricular(usuario1)
    LinuxFundamentalsFormacao.matricular(usuario2)
    LinuxFundamentalsFormacao.matricular(usuario4)

    UxDesignerFormacao.matricular(usuario2)
    UxDesignerFormacao.matricular(usuario3)

    WebtresFundamentalsFormacao.matricular(usuario1)
    WebtresFundamentalsFormacao.matricular(usuario2)
    WebtresFundamentalsFormacao.matricular(usuario4)

    
    println("FORMAÇÕES:")
    for (conteudo in listaDeConteudo) {
        println("${conteudo.nome} - ${conteudo.duracao}h - Nível: ${conteudo.nivel}") //Imprimir Lista de todos os cursos
    }
    println("------------------------------------//-----------------------------------")
	println("Curso: ${linuxFundamentals.nome} | Nível: ${linuxFundamentals.nivel} | Duração: ${linuxFundamentals.duracao}h")
    println("Aluno(s):")
    println("Nome: ${LinuxFundamentalsFormacao.listaDeContatos()}")
    println("------------------------------------//-----------------------------------")
	println("Curso: ${uxDesigner.nome} | Nível: ${uxDesigner.nivel} | Duração: ${uxDesigner.duracao}h")
    println("Aluno(s):")
    println("Nome: ${UxDesignerFormacao.listaDeContatos()}")
    println("------------------------------------//-----------------------------------")
	println("Curso: ${webtresFundamentals.nome} | Nível: ${webtresFundamentals.nivel} | Duração: ${webtresFundamentals.duracao}h")
    println("Aluno(s):")
    println("Nome: ${WebtresFundamentalsFormacao.listaDeContatos()}")
}


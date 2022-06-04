import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        System.out.printf("-----------------------\n");
        System.out.printf("-Sistema Acadêmico API- \n");
        System.out.printf("-----------------------\n");

        // Definir o atributo estático - Nome da Instituição
        System.out.printf("Informe o nome da instituição de ensino: \n");
        Aluno.setNomeInstituicao(ler.next());

        Turma turma = new Turma();
        turma = adicionarTurma();
        turma.calcularMediaTurma();

        System.out.println("----------------------------------------");
		System.out.println("Dados da Turma");
		System.out.println("----------------------------------------");
	    System.out.println(turma .toString());

        System.out.println("----------------------------------------");
        System.out.println("Nome da Instituição: " + Aluno.getNomeInstituicao());
        System.out.println("Quantidade de Alunos: " + Aluno.getQuantidadeAlunos());

    }

    public static Endereco criarEndereco() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Criar o endereco
        Endereco endereco = new Endereco();

        System.out.printf("Informe o CEP do Endereço: \n");
        endereco.setCEP(ler.nextInt());

        System.out.printf("Informe a Rua do Endereço: \n");
        endereco.setRua(ler.next());

        System.out.printf("Informe o Bairro do Endereço: \n");
        endereco.setBairro(ler.next());

        System.out.printf("Informe a Cidade do Endereço: \n");
        endereco.setCidade(ler.next());

        System.out.printf("Informe o Estado do Endereço: \n");
        endereco.setEstado(ler.next());

        return endereco;

    }

    public static Pessoa adicionarDadosPessoa(Pessoa pessoa) {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe a nome do " + pessoa.getClass().getName() + ": \n");
        pessoa.setNome(ler.next());

        System.out.printf("Informe o sobrenome do " + pessoa.getClass().getName() + ": \n");
        pessoa.setSobrenome(ler.next());

        System.out.printf("Informe a idade do " + pessoa.getClass().getName() + ": \n");
        pessoa.setIdade(ler.nextInt());

        System.out.printf("Informe a naturalidade do " + pessoa.getClass().getName() + ": \n");
        pessoa.setNaturalidade(ler.next());

        System.out.printf("Informe o Sexo do " + pessoa.getClass().getName() + ": \n");
        pessoa.setSexo(ler.next().charAt(0));

        System.out.printf("Informe o CPF do " + pessoa.getClass().getName() + ": \n");
        pessoa.setCpf(ler.next());

        System.out.printf("-----------------------\n");
        System.out.printf("Informe o endereço do " + pessoa.getClass().getName() + ": \n");

        Endereco enderecoPessoa = criarEndereco();

        pessoa.setEndereco(enderecoPessoa);

        return pessoa;
    }

    public static Nota adicionarNotaAluno() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Criar o endereco
        Nota nota = new Nota();

        System.out.printf("Informe o valor da nota do aluno: \n");
        nota.setValor(ler.nextDouble());

        System.out.printf("Informe o peso da nota do aluno: \n");
        nota.setPeso(ler.nextInt());

        return nota;

    }

    public static List<Nota> adicionarNotasAluno() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        System.out.printf("----------------------------------------------------------------------------\n");
        System.out.printf("Informe o valor 2, 3 ou 4 para definir a quantidde de notas: \n");
        System.out.printf("Caso informe qualquer outro valor diferente será usado o padrão de 2 notas: \n");
        System.out.printf("----------------------------------------------------------------------------\n");
        int qtdNotas = ler.nextInt();

        // Garante que a quantidade de notas esteja em conformidade com as restrições
        // impostas no projeto
        if ((qtdNotas != 2) && (qtdNotas != 3) && (qtdNotas != 4)) {
            qtdNotas = 2;
        }

        // Cria uma variável local alunos do Tipo ArrayList de Aluno
        List<Nota> notas = new ArrayList<Nota>();

        // Estrtura de Repetição - Adicionar 4 notas
        for (int i = 1; i <= qtdNotas; i++) {

            System.out.printf("-------------------------------\n");
            System.out.printf(i + "ª Nota \n");

            notas.add(adicionarNotaAluno());

        }

        return notas;

    }

    public static Aluno adicionarAluno() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Criar o aluno
        Aluno aluno = new Aluno();

        // DowsCast
        aluno = (Aluno) adicionarDadosPessoa(aluno);

        System.out.printf("Informe o curso do aluno: \n");
        aluno.setCurso(ler.next());

        System.out.printf("Informe se o aluno está matriculado: \n");
        aluno.setEstaMatriculado(ler.nextBoolean());

        aluno.setNotas(adicionarNotasAluno());

        // Calcular as médias e verificar a situação
        aluno.calcularMediaAritimetica();
        aluno.calcularMediaPonderada();

        return aluno;

    }

    public static ArrayList<Aluno> adicionarListaAlunos() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Cria uma variável local alunos do Tipo ArrayList de Aluno
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        System.out.printf("----------------------------------------------------\n");
        System.out.printf("Informe a quantidade de alunos a serem cadastrados: \n");
        System.out.printf("----------------------------------------------------\n");
        int qtdAlunos = ler.nextInt();

        // Estrtura de Repetição - Adicionar Alunos
        for (int i = 1; i <= qtdAlunos; i++) {

            System.out.printf("-------------------------------\n");
            System.out.printf(i + "º Aluno \n");
            System.out.printf("-------------------------------\n");

            Aluno aluno = adicionarAluno();

            alunos.add(aluno);

        }

        return alunos;
    }

    public static Professor adicionarProfessor() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Criar o aluno
        Professor professor = new Professor();

        // DownCast
        professor = (Professor) adicionarDadosPessoa(professor);

        System.out.printf("Informe o salário do professor: \n");
        professor.setSalario(ler.nextDouble());

        System.out.printf("Informe a carga horária do professor: \n");
        professor.setCargaHoraria(ler.nextInt());

        return professor;

    }

    public static ArrayList<Professor> adicionarListaProfessores() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Cria uma variável local alunos do Tipo ArrayList de Aluno
        ArrayList<Professor> professores = new ArrayList<Professor>();

        System.out.printf("---------------------------------------------------------\n");
        System.out.printf("Informe a quantidade de professores a serem cadastrados: \n");
        System.out.printf("---------------------------------------------------------\n");
        int qtdProfessores = ler.nextInt();

        // Estrtura de Repetição - Adicionar Alunos
        for (int i = 1; i <= qtdProfessores; i++) {

            System.out.printf("-------------------------------\n");
            System.out.printf(i + "º Professor \n");
            System.out.printf("-------------------------------\n");

            Professor professor = adicionarProfessor();

            professores.add(professor);

        }

        return professores;
    }

    public static Disciplina adicionarDisciplina() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Cria Disciplina
        Disciplina disciplina = new Disciplina();

        System.out.printf("Informe o nome da disciplina: \n");
        disciplina.setNome(ler.next());

        System.out.printf("Informe a carga horária da disciplina: \n");
        disciplina.setCargaHoraria(ler.nextInt());

        return disciplina;

    }

    public static Sala adicionarSala() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Cria Sala
        Sala sala = new Sala();

        System.out.printf("Informe o número da sala: \n");
        sala.setNumero(ler.nextInt());

        System.out.printf("Informe a capacidade de alunos da sala: \n");
        sala.setCapacidade(ler.nextInt());

        System.out.printf("A sala tem ar condicionado? \n");
        sala.setArCondicionado(ler.nextBoolean());

        System.out.printf("A sala tem quadro branco? \n");
        sala.setQuadroBranco(ler.nextBoolean());

        System.out.printf("A sala é um laboratório? \n");
        sala.setLaboratorio(ler.nextBoolean());

        return sala;

    }

    public static ArrayList<Sala> adicionarListaSalas() {

        // Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        // Cria uma variável local salas do Tipo ArrayList de Salas
        ArrayList<Sala> salas = new ArrayList<Sala>();

        System.out.printf("---------------------------------------------------\n");
        System.out.printf("Informe a quantidade de salas a serem cadastradas: \n");
        System.out.printf("---------------------------------------------------\n");
        int qtdSalas = ler.nextInt();

        // Estrtura de Repetição - Adicionar Alunos
        for (int i = 1; i <= qtdSalas; i++) {

            System.out.printf("-------------------------------\n");
            System.out.printf(i + "º Sala \n");
            System.out.printf("-------------------------------\n");

            Sala sala = adicionarSala();

            salas.add(sala);

        }

        return salas;
    }

    public static Turma adicionarTurma(){

        //Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        //Cria Turma
        Turma turma = new Turma();

        System.out.printf("Informe o nome da turma: \n");
        turma.setNome(ler.next());

        System.out.printf("Informe o período da turma: \n");
        turma.setPeriodo(ler.next());
        
        System.out.printf("---------------------------------\n");
        System.out.printf("Quem é o professor da turma? \n");
        turma.setProfessor(adicionarProfessor());

        System.out.printf("--------------------------------\n");
        System.out.printf("Qual a disciplina da turma? \n");
        turma.setDisciplina(adicionarDisciplina());

        System.out.printf("---------------------------------\n");
        System.out.printf("Quem são os alunos da turma? \n");
        turma.setAlunos(adicionarListaAlunos());

        System.out.printf("---------------------------------\n");    
        System.out.printf("Quais são as salas da turma? \n");
        turma.setSalas(adicionarListaSalas());

        return turma;

    }    

}

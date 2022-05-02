import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Permite a entrada de dados através do teclado
        Scanner ler = new Scanner(System.in);

        //Definir o atributo estático - Nome da Instituição
        System.out.printf("Informe o nome da instituição de ensino: \n");
        Aluno.setNomeInstituicao(ler.next());

        //Criar Alunos
        ArrayList<Aluno> alunos = adicionarListaAlunos();

        //Criar Professores
        ArrayList<Professor> professores = adicionarListaProfessores();

		//Imprimir os dados dos alunos
		for (Aluno aluno: alunos) {
			System.out.printf("------------------------------ \n");
			System.out.printf("Aluno \n");
			System.out.printf(aluno.toString());
		}

        //Imprimir os dados dos professores
		for (Professor professor: professores) {
			System.out.printf("------------------------------ \n");
			System.out.printf("Professor \n");
			System.out.printf(professor.toString());
		}

        System.out.println("----------------------------------------");
        System.out.println("Nome da Instituição: " + Aluno.getNomeInstituicao());

        System.out.println("Quantidade de Alunos: " + Aluno.getQuantidadeAlunos());

    }

    public static Aluno adicionarAluno(){

        //Permite a entrada de dados através do teclado
		Scanner ler = new Scanner(System.in);

        //Criar o aluno
        Aluno aluno = new Aluno();

        System.out.printf("Informe a matrícula do aluno: \n");
		aluno.setMatricula(ler.nextInt());

        System.out.printf("Informe a nome do aluno: \n");
		aluno.setNome(ler.next());

        System.out.printf("Informe o sobrenome do aluno: \n");
		aluno.setSobrenome(ler.next());

        System.out.printf("Informe a idade do aluno: \n");
		aluno.setIdade(ler.nextInt());

        System.out.printf("Informe o curso do aluno: \n");
		aluno.setCurso(ler.next());

        System.out.printf("Informe a naturalidade do aluno: \n");
		aluno.setNaturalidade(ler.next());

		System.out.printf("Informe se o aluno está matriculado: \n");
		aluno.setEstaMatriculado(ler.nextBoolean());

        return aluno;

    }

    public static ArrayList<Aluno> adicionarListaAlunos(){

        //Permite a entrada de dados através do teclado
		Scanner ler = new Scanner(System.in);

        //Cria uma variável local alunos do Tipo ArrayList de Aluno
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        System.out.printf("Informe a quantidade de alunos a serem cadastrados: \n");
		int qtdAlunos = ler.nextInt();

        //Estrtura de Repetição - Adicionar Alunos
        for (int i = 1; i <= qtdAlunos; i++) {

            System.out.printf("-------------------------------\n");
			System.out.printf(i + "º Aluno \n");
			System.out.printf("-------------------------------\n");

            Aluno aluno = adicionarAluno();

            alunos.add(aluno);
            
        }

        return alunos;
    }

    public static Professor adicionarProfessor(){

        //Permite a entrada de dados através do teclado
		Scanner ler = new Scanner(System.in);

        //Criar o aluno
        Professor professor = new Professor();

        System.out.printf("Informe a matrícula do professor: \n");
		professor.setMatricula(ler.nextInt());

        System.out.printf("Informe a nome do professor: \n");
		professor.setNome(ler.next());

        System.out.printf("Informe o sobrenome do professor: \n");
		professor.setSobrenome(ler.next());

        System.out.printf("Informe a idade do professor: \n");
		professor.setIdade(ler.nextInt());

        System.out.printf("Informe o curso do professor: \n");
		professor.setSexo(ler.next().charAt(0));

        System.out.printf("Informe a naturalidade do professor: \n");
		professor.setCpf(ler.next());

		System.out.printf("Informe o endereço do professor: \n");
		professor.setEndereco(ler.next());

        return professor;

    }

    public static ArrayList<Professor> adicionarListaProfessores(){

        //Permite a entrada de dados através do teclado
		Scanner ler = new Scanner(System.in);

        //Cria uma variável local alunos do Tipo ArrayList de Aluno
        ArrayList<Professor> professores = new ArrayList<Professor>();

        System.out.printf("Informe a quantidade de professores a serem cadastrados: \n");
		int qtdProfessores = ler.nextInt();

        //Estrtura de Repetição - Adicionar Alunos
        for (int i = 1; i <= qtdProfessores; i++) {

            System.out.printf("-------------------------------\n");
			System.out.printf(i + "º Professor \n");
			System.out.printf("-------------------------------\n");

            Professor professor = adicionarProfessor();

            professores.add(professor);
            
        }

        return professores;
    }

}

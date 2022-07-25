package br.com.academico.aluno;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.academico.endereco.Endereco;
import br.com.academico.persistencia.FabricaConexoesPostgres;
import br.com.academico.persistencia.IFabricaConexoes;

public class AlunoTeste {
    
    private IFabricaConexoes fabrica; 
    private IAlunoDAO alunoDAO;

    public AlunoTeste() {
        try {
            fabrica = new FabricaConexoesPostgres();
            alunoDAO = new AlunoDAOPostgres(fabrica.obterConexao());
        }
        catch (SQLException ex) {
            System.out.println("Erro ao obter uma conexação");
            System.out.println(ex.toString());
        }
        catch (ClassNotFoundException ex) { 
            System.out.println("Erro ao obter uma conexação");
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {

        //testeInsercaoAluno();
        testeRecuperacaoAluno(20221548);
        //testeAtualizacaoAluno();
        //testeExclusaoAluno(20226703);
        //testeListagemAluno();
    
    }
    
    
    public static void testeInsercaoAluno(){

        AlunoTeste testeAluno =  new AlunoTeste();

        /////////////////////////////////////////////////////////
        //Teste - Criando um aluno no banco de dados - Postgres//
        /////////////////////////////////////////////////////////

        try {

            Aluno aluno = new Aluno();
            aluno.setNome("Mario");
            aluno.setSobrenome("Silva");
            aluno.setIdade(22);
            aluno.setNaturalidade("Aracaju");
            aluno.setSexo('M');
            aluno.setCpf("7897987");
            aluno.setCurso("Informática");
            aluno.setEstaMatriculado(true);
            aluno.setAprovado(true);

            Endereco endereco = new Endereco();
            endereco.setId(1);
            aluno.setEndereco(endereco);
                
            List<Nota> ListaNotas = new ArrayList<Nota>();
            Nota nota01 = new Nota();
            nota01.setValor(6.5);
            nota01.setPeso(1);
            nota01.setMatricula(aluno.getMatricula());
            ListaNotas.add(nota01);

            Nota nota02 = new Nota();
            nota02.setValor(7.9);
            nota02.setPeso(2);
            nota02.setMatricula(aluno.getMatricula());
            ListaNotas.add(nota02);

            aluno.setNotas(ListaNotas);
            
            int idAluno = testeAluno.alunoDAO.criar(aluno);

            System.out.println("Aluno inserido com sucesso no banco de dados.");
            System.out.println("ID do Endereço Inserido: " + idAluno);
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar inserir um aluno");
            System.out.println(ex.toString());
        }

    }

    public static void testeRecuperacaoAluno(int matricula){

        AlunoTeste testeAluno =  new AlunoTeste();

        ////////////////////////////////////////////////////////////////
        //Teste - Recuperando um aluno no banco de dados - Postgres//
        ////////////////////////////////////////////////////////////////

        try {
            Aluno aluno = testeAluno.alunoDAO.recuperar(matricula);
            aluno.calcularMediaAritimetica();
            aluno.calcularMediaPonderada();
            System.out.println("Aluno recuperado com sucesso.");
            System.out.println(aluno.toString());
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar recuperar um aluno");
            System.out.println(ex.toString());
        }
        catch (Exception ex) {
            System.out.println("Erro ao tentar recuperar um endereço");
            System.out.println(ex.toString());
        }

    }
    
    public static void testeAtualizacaoAluno(){

        AlunoTeste testeAluno =  new AlunoTeste();

        /////////////////////////////////////////////////////////////
        //Teste - Atualizando um aluno no banco de dados - Postgres//
        /////////////////////////////////////////////////////////////

        try {
            Aluno aluno = new Aluno();
            aluno.setMatricula(20221548);;
            aluno.setNome("Josefa");
            aluno.setSobrenome("Maria M.");
            aluno.setIdade(19);
            aluno.setNaturalidade("Lagarto");
            aluno.setSexo('F');
            aluno.setCpf("1234");
            aluno.setCurso("Des. Sistemas");
            aluno.setEstaMatriculado(false);
            aluno.setAprovado(true);

            Endereco endereco = new Endereco();
            endereco.setId(2);
            aluno.setEndereco(endereco);
            
            boolean atualizou = testeAluno.alunoDAO.atualizar(aluno);

            System.out.println("Aluno atualizado com sucesso no banco de dados.");
            System.out.println(aluno.toString());
            
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar atualizar um aluno");
            System.out.println(ex.toString());
        }

    }

    public static void testeExclusaoAluno(int matricula){

        AlunoTeste testeAluno =  new AlunoTeste();

        //////////////////////////////////////////////////////////////
        //Teste - Excluindo um aluno no banco de dados - Postgres//
        //////////////////////////////////////////////////////////////

        try {
            Aluno aluno = new Aluno();
            aluno.setMatricula(matricula);
            boolean excluiu = testeAluno.alunoDAO.excluir(aluno);
            System.out.println("aluno excluído com sucesso no banco de dados.");
            
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar excluir um aluno");
            System.out.println(ex.toString());
        }

    }

    public static void testeListagemAluno(){

        AlunoTeste testeAluno =  new AlunoTeste();

        ///////////////////////////////////////////////////////////
        //Teste - Listando os alunos do banco de dados - Postgres//
        ///////////////////////////////////////////////////////////

        try {
            List<Aluno> listaALunos = testeAluno.alunoDAO.listar();
            System.out.println("Listagem de alunos feita com sucesso.");
            System.out.println(listaALunos.toString());
            
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar listar os endereço");
            System.out.println(ex.toString());
        }

    }
    
}
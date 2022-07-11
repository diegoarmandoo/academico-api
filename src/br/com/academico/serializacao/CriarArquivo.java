package br.com.academico.serializacao;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.academico.aluno.Aluno;
import br.com.academico.aluno.Nota;
import br.com.academico.endereco.Endereco;

public class CriarArquivo {

    // Gera saída dos dados no arquivo
    private static ObjectOutputStream output;

    private static String nomeArquivo = "alunos.dat";

    // Abre o arquivo alunos.dat
    public static void abrirArquivo() {
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get(nomeArquivo)));
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo. Terminando.");
            System.exit(1); // termina o programa
        }
    }

    // Adiciona registros ao arquivo
    public static void adicionarRegistro() {

        try {

            // Cria novo registro de aluno com endereço
            Aluno aluno = new Aluno();
            aluno.setNome("Maria");
            aluno.setSobrenome("José");
            aluno.setIdade(33);
            aluno.setNaturalidade("Aracaju");
            aluno.setSexo('F');
            aluno.setCpf("999");
            aluno.setEndereco(new Endereco(999, "Rua", "Bairro", "Cidade", "Estado"));
            aluno.setCurso("Informatica");
            aluno.setEstaMatriculado(true);
            aluno.getNotas().add(new Nota(5,1));
            aluno.getNotas().add(new Nota(6,1));
            aluno.calcularMediaAritimetica();
            aluno.calcularMediaPonderada();
            output.writeObject(aluno); //Serializa o objeto aluno em um arquivo

            // Cria novo registro de aluno 
            Aluno aluno2 = new Aluno();
            aluno2.setNome("Felipe");
            aluno2.setSobrenome("José");
            aluno2.setIdade(22);
            aluno2.setNaturalidade("Tobias");
            aluno2.setSexo('M');
            aluno2.setCpf("555");
            aluno2.setEndereco(new Endereco(555, "RuaA", "BairroA", "CidadeA", "EstadoA"));
            aluno2.setCurso("Informatica");
            aluno2.setEstaMatriculado(false);
            aluno2.getNotas().add(new Nota(8,1));
            aluno2.getNotas().add(new Nota(9,1));
            aluno2.getNotas().add(new Nota(10,1));
            aluno2.calcularMediaAritimetica();
            aluno2.calcularMediaPonderada();
            output.writeObject(aluno2); //Serializa o objeto aluno em um arquivo

            System.out.println("Arquivo Gravado.");

        } catch (IOException ioException) {
            System.err.println("Erro ao escrever o arquivo.");
            System.out.println(ioException.toString());
        }

    }
    
    // Fecha o arquivo e termina o aplicativo
    public static void fecharArquivo() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ioException) {
            System.err.println("Erro ao fechar o arquivo.");
        }
    }

    public static void main(String[] args) {	
        abrirArquivo();
        adicionarRegistro();
        fecharArquivo();
    }

}

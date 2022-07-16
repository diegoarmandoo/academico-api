package br.com.academico.serializacao;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.academico.aluno.Aluno;

public class LerArquivo {

    private static ObjectInputStream input;

    private static String nomeArquivo = "alunos.dat";

    // Permite que o usuário selecione o arquivo a abrir
    public static void abrirArquivo() {
        try // abre o arquivo
        {
            input = new ObjectInputStream(Files.newInputStream(Paths.get(nomeArquivo)));
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo.");
            System.err.println(ioException.toString());
            System.exit(1);
        }
    }
    
    // Lê o registro no arquivo
    public static void lerRegistros() {
						
        try {
            while (true) // faz um loop até ocorrer uma EOFException
            {
                Aluno aluno = (Aluno) input.readObject();

                // exibe o conteúdo de registro
                System.out.println("---------------Aluno----------------");
                System.out.println(aluno.toString());
                
            }
        } catch (EOFException endOfFileException) {
            System.out.println("------------------------------------");
            System.out.println("Não há mais registros");
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Tipo de objeto inválido. Terminando.");
        } catch (IOException ioException) {
            System.err.println("Erro ao ler do arquivo. Terminando.");
        }
    } // fim do método readRecords

    // Fecha o arquivo e termina o aplicativo
    public static void fecharArquivo() {
        try {
            if (input != null) {
                input.close();
            }	
        } catch (IOException ioException) {
            System.err.println("Erro ao fechar o arquivo. Terminando.");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        abrirArquivo();
        lerRegistros();
        fecharArquivo();
    }

}

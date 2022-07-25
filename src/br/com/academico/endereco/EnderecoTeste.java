package br.com.academico.endereco;


import java.sql.SQLException;
import java.util.List;
import br.com.academico.persistencia.FabricaConexoesPostgres;
import br.com.academico.persistencia.IFabricaConexoes;

public class EnderecoTeste {

    private IFabricaConexoes fabrica; 
	private IEnderecoDAO enderecoDAO;

    public EnderecoTeste() {
        try {
            fabrica = new FabricaConexoesPostgres();
            enderecoDAO = new EnderecoDAOPostgres(fabrica.obterConexao());
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

    public static void testeInsercaoEndereco(){

        EnderecoTeste testeEndereco =  new EnderecoTeste();

        ////////////////////////////////////////////////////////////
        //Teste - Criando um endereço no banco de dados - Postgres//
        ////////////////////////////////////////////////////////////

        try {
            Endereco endereco = new Endereco(7894, "Rua da Ladeira", "Siqueira Campos", "Aracaju", "Sergipe");
            int idEndereco = testeEndereco.enderecoDAO.criar(endereco);
            System.out.println("Endereço inserido com sucesso no banco de dados.");
            System.out.println("ID do Endereço Inserido: " + idEndereco);
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar inserir um endereço");
            System.out.println(ex.toString());
        }

    }

    public static void testeRecuperacaoEndereco(int idEndereco){

        EnderecoTeste testeEndereco =  new EnderecoTeste();

        ////////////////////////////////////////////////////////////////
        //Teste - Recuperando um endereço no banco de dados - Postgres//
        ////////////////////////////////////////////////////////////////

        try {
            Endereco endereco = testeEndereco.enderecoDAO.recuperar(idEndereco);
            System.out.println("Endereço recuperado com sucesso.");
            System.out.println(endereco.toString());
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar recuperar um endereço");
            System.out.println(ex.toString());
        }
        catch (Exception ex) {
            System.out.println("Erro ao tentar recuperar um endereço");
            System.out.println(ex.toString());
        }

    }

    public static void testeAtualizacaoEndereco(){

        EnderecoTeste testeEndereco =  new EnderecoTeste();

        ////////////////////////////////////////////////////////////////
        //Teste - Atualizando um endereço no banco de dados - Postgres//
        ////////////////////////////////////////////////////////////////

        try {
            Endereco endereco = new Endereco();
            endereco.setId(4);
            endereco.setCEP(8596);
            endereco.setRua("Rua nova");
            endereco.setBairro("Area Rural");
            endereco.setCidade("Itapicuru");
            endereco.setEstado("Bahia");
            
            boolean atualizou = testeEndereco.enderecoDAO.atualizar(endereco);

            System.out.println("Endereço atualizado com sucesso no banco de dados.");
            System.out.println(endereco.toString());
            
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar atualizar um endereço");
            System.out.println(ex.toString());
        }

    }

    public static void testeExclusaoEndereco(int idEndereco){

        EnderecoTeste testeEndereco =  new EnderecoTeste();

        //////////////////////////////////////////////////////////////
        //Teste - Excluindo um endereço no banco de dados - Postgres//
        //////////////////////////////////////////////////////////////

        try {
            Endereco endereco = new Endereco();
            endereco.setId(idEndereco);
            boolean excluiu = testeEndereco.enderecoDAO.excluir(endereco);
            System.out.println("Endereço excluído com sucesso no banco de dados.");
            
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar excluir um endereço");
            System.out.println(ex.toString());
        }

    }

    public static void testeListagemEndereco(){

        EnderecoTeste testeEndereco =  new EnderecoTeste();

        //////////////////////////////////////////////////////////////
        //Teste - Listando os endereços do banco de dados - Postgres//
        //////////////////////////////////////////////////////////////

        try {
            List<Endereco> listaEnderecos = testeEndereco.enderecoDAO.listar();
            System.out.println("Listagem de endereços feita com sucesso.");
            System.out.println(listaEnderecos.toString());
            
        }
        catch (SQLException ex) {
            System.out.println("Erro ao tentar listar os endereço");
            System.out.println(ex.toString());
        }

    }

    public static void main(String[] args) {

        //testeInsercaoEndereco();
        //testeRecuperacaoEndereco(3);
        //testeAtualizacaoEndereco();
        //testeExclusaoEndereco(3);
        //testeListagemEndereco();

    }
    
}

package br.com.academico.endereco;

import java.sql.SQLException;
import java.util.List;

public interface IEnderecoDAO {
    
    //CRUD//
    public int criar(Endereco endereco) throws SQLException;
    public Endereco recuperar(int id) throws Exception, SQLException;
    public boolean atualizar(Endereco endereco) throws SQLException;
    public boolean excluir(Endereco endereco) throws SQLException;

    //Outras funcionalidades//    
    public List<Endereco> listar()  throws SQLException;

    
}

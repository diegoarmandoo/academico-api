package br.com.academico.aluno;

import java.sql.SQLException;
import java.util.List;

public interface IAlunoDAO {
    
    //CRUD//
    public int criar(Aluno aluno) throws SQLException;
    public Aluno recuperar(int id) throws Exception, SQLException;
    public boolean atualizar(Aluno aluno) throws SQLException;
    public boolean excluir(Aluno aluno) throws SQLException;

    //Outras funcionalidades//    
    public List<Aluno> listar()  throws SQLException;

}

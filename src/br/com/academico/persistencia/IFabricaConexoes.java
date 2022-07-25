package br.com.academico.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

public interface IFabricaConexoes {

    Connection obterConexao() throws ClassNotFoundException, SQLException;
    
}

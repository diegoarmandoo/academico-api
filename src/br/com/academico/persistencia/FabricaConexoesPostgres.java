package br.com.academico.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoesPostgres implements IFabricaConexoes {

    private static String DriverJDBC = "org.postgresql.Driver";
    private static String usuario = "postgres";
    private static String senha = "postgres";
    private static String URL = "jdbc:postgresql://localhost:5433/academico-db";

    @Override
    public Connection obterConexao() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DriverJDBC);
            return DriverManager.getConnection(URL, usuario, senha);
        }
        catch (SQLException e) {
            throw e;			
        }
        catch (ClassNotFoundException e) {
            throw e;	
        }
    }
}

package br.com.academico.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAOPostgres implements IEnderecoDAO {

    private Connection conexao;

    public EnderecoDAOPostgres(Connection pConexao) {
        this.conexao = pConexao;
    }

    @Override
    public int criar(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO public.enderecos (cep, rua, bairro, cidade, estado) VALUES (?,?,?,?,?)";
        int id = 0;
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, endereco.getCEP());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.execute();
            
            sql = "SELECT CURRVAL('enderecos_id_seq'::regclass) AS id";
            stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }

            return id;

        } catch (SQLException e) {
            throw e;
        }
        finally {
            conexao.close();
        }
    }

    @Override
    public Endereco recuperar(int id) throws Exception, SQLException {
        String sql = "SELECT id, cep, rua, bairro, cidade, estado FROM public.enderecos WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setCEP(rs.getInt("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                return endereco;

            } else {
                throw new Exception("O ID do endereço não existe.");
            }

        } catch (SQLException e) {
            throw e;
        } 
        finally {
            conexao.close();
        }
    }

    @Override
    public boolean atualizar(Endereco endereco) throws SQLException {
        String sql = "UPDATE public.enderecos SET cep=?, rua=?, bairro=?, cidade=?, estado=? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, endereco.getCEP());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getBairro());
            stmt.setInt(6, endereco.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {			
            throw e;
        }
        finally {
            conexao.close();
        }
    }

    @Override
    public boolean excluir(Endereco endereco) throws SQLException {
        String sql = "DELETE FROM public.enderecos WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, endereco.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {			
            throw e;
        }
        finally {
            conexao.close();
        }
    }

    @Override
    public List<Endereco> listar() throws SQLException {
        String sql = "SELECT id, cep, rua, bairro, cidade, estado FROM public.enderecos ORDER BY id";
        List<Endereco> listaEnderecos =  new ArrayList<Endereco>();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setCEP(rs.getInt("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                listaEnderecos.add(endereco);
            }
            return listaEnderecos;
        } catch (SQLException e) {
            throw e;
        }
        finally {
            conexao.close();
        }
    }

}

package br.com.academico.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.academico.endereco.Endereco;

public class AlunoDAOPostgres implements IAlunoDAO {
    
    private Connection conexao;
				
    public AlunoDAOPostgres(Connection pConexao) {
        this.conexao = pConexao;
    }

    @Override
    public int criar(Aluno aluno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO public.alunos (matricula, nome, sobrenome, idade, naturalidade, sexo, cpf, curso, matriculado, aprovado, id_endereco)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?)");
        int id = 0;
        try {

            //Alterando a configuração do commit    
            conexao.setAutoCommit(false);

            ///////////////////////////////////
            //Insere os dados na tabela aluno//
            ///////////////////////////////////

            PreparedStatement stmt = this.conexao.prepareStatement(sql.toString());
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getSobrenome());
            stmt.setInt(4, aluno.getIdade());
            stmt.setString(5, aluno.getNaturalidade());
            stmt.setString(6, String.valueOf(aluno.getSexo()));
            stmt.setString(7, aluno.getCpf());
            stmt.setString(8, aluno.getCurso());
            stmt.setBoolean(9, aluno.isEstaMatriculado());
            stmt.setBoolean(10, aluno.isAprovado());
            stmt.setInt(11, aluno.getEndereco().getId());
            stmt.execute();

            //////////////////////////////////
            //Insere os dados na tabela nota//
            //////////////////////////////////
            
            sql.setLength(0); //Limpa a objeto SQL
            sql.append("INSERT INTO public.notas(valor, peso, matricula_aluno) VALUES (?, ?, ?)");
            stmt = this.conexao.prepareStatement(sql.toString());
            for(Nota nota : aluno.getNotas()){
                stmt.setDouble(1,nota.getValor());
                stmt.setInt(2,nota.getPeso());
                stmt.setDouble(3,aluno.getMatricula());
                stmt.addBatch();
            }
            stmt.executeBatch();

            //Confirma as declarações no banco
            conexao.commit();

            return aluno.getMatricula();

        } catch (SQLException e) {
            conexao.rollback();
            throw e;
        }
        finally {
            conexao.setAutoCommit(true);
            conexao.close();
        }
	}

    @Override
    public Aluno recuperar(int matricula) throws Exception, SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT A.matricula,");
            sql.append("A.nome,");
            sql.append("A.sobrenome,");
            sql.append("A.idade,");
            sql.append("A.naturalidade,");
            sql.append("A.sexo,");
            sql.append("A.cpf,");
            sql.append("A.curso,");
            sql.append("A.aprovado,");
            sql.append("A.matriculado,");
            sql.append("A.id_endereco,");
            sql.append("E.cep,");
            sql.append("E.rua,");
            sql.append("E.bairro,");
            sql.append("E.cidade,");
            sql.append("E.estado");
        sql.append(" FROM public.alunos AS A ");
        sql.append(" INNER JOIN public.enderecos AS E ON (A.id_endereco = E.id) ");
        sql.append(" WHERE (A.matricula = ?) ");
       
        try {

            //Alterando a configuração do commit    
            conexao.setAutoCommit(false);

            ////////////////////////////////////////////////
            //Recupera os dados de um aluno e seu endereço//
            ////////////////////////////////////////////////

            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setInt(1, matricula);
            ResultSet rs = stmt.executeQuery();
            Aluno aluno = new Aluno();
            if (rs.next()) {
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setNaturalidade(rs.getString("naturalidade"));
                aluno.setSexo(rs.getString("sexo").charAt(0));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setEstaMatriculado(rs.getBoolean("matriculado"));
                aluno.setAprovado(rs.getBoolean("aprovado"));

                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id_endereco"));
                endereco.setCEP(rs.getInt("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));

                aluno.setEndereco(endereco);
                
            } else {
                throw new Exception("O ID do aluno não existe.");
            }
            rs.close();

            //////////////////////////////
            //Recupera as notas do aluno//
            //////////////////////////////

            sql.setLength(0); //Limpa a objeto SQL
            sql.append("SELECT id, valor, peso, matricula_aluno FROM public.notas WHERE matricula_aluno = ?");
            stmt = conexao.prepareStatement(sql.toString());
            stmt.setInt(1, matricula);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Nota nota = new Nota();
                nota.setId(rs.getInt("id"));
                nota.setValor(rs.getDouble("valor"));
                nota.setPeso(rs.getInt("peso"));
                nota.setMatricula(matricula);
                aluno.getNotas().add(nota);
            }

            //Confirma as declarações no banco
            conexao.commit();

            return aluno;

        } catch (SQLException e) {
            conexao.rollback();
            throw e;
        } 
        finally {
            conexao.setAutoCommit(true);
            conexao.close();
        }
    }

    @Override
    public boolean atualizar(Aluno aluno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE public.alunos SET nome=?, sobrenome=?, idade=?, naturalidade=?, sexo=?, cpf=?, curso=?, matriculado=?, aprovado=?, id_endereco=?");
        sql.append(" WHERE matricula=?");
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getSobrenome());
            stmt.setInt(3, aluno.getIdade());
            stmt.setString(4, aluno.getNaturalidade());
            stmt.setString(5, String.valueOf(aluno.getSexo()));
            stmt.setString(6, aluno.getCpf());
            stmt.setString(7, aluno.getCurso());
            stmt.setBoolean(8, aluno.isEstaMatriculado());
            stmt.setBoolean(9, aluno.isAprovado());
            stmt.setInt(10, aluno.getEndereco().getId());
            stmt.setInt(11, aluno.getMatricula());
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
    public boolean excluir(Aluno aluno) throws SQLException {
        String sql = "";
        try {

            //Alterando a configuração do commit    
            conexao.setAutoCommit(false);

            ////////////////////////////
            //Exclui as notas do aluno//
            ////////////////////////////

            sql = "DELETE FROM public.notas WHERE matricula_aluno = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, aluno.getMatricula());
            stmt.execute();

            //////////////////
            //Exclui o aluno//
            //////////////////

            sql = "DELETE FROM public.alunos WHERE matricula = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, aluno.getMatricula());
            stmt.execute();

            //Confirma as declarações no banco
            conexao.commit();

            return true;
        } catch (SQLException e) {		
            conexao.rollback();	
            throw e;
        }
        finally {
            conexao.setAutoCommit(true);
            conexao.close();
        }
    }

    @Override
    public List<Aluno> listar() throws SQLException {
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT A.*, E.* ");
        sql.append(" FROM public.alunos AS A ");
        sql.append(" INNER JOIN public.enderecos AS E ON (A.id_endereco = E.id)");
        
        List<Aluno> listaAlunos =  new ArrayList<Aluno>();
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setNaturalidade(rs.getString("naturalidade"));
                aluno.setSexo(rs.getString("sexo").charAt(0));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setEstaMatriculado(rs.getBoolean("matriculado"));
                aluno.setAprovado(rs.getBoolean("aprovado"));

                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id_endereco"));
                endereco.setCEP(rs.getInt("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));

                aluno.setEndereco(endereco);

                listaAlunos.add(aluno);
            }
            return listaAlunos;
        } catch (SQLException e) {
            throw e;
        }
        finally {
            conexao.close();
        }
    }
				
	
}

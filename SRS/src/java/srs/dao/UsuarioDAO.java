/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import srs.entidades.Usuario;

/**
 * DAO para a entidade Usuario.
 *
 * @author David Buzatto
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() throws SQLException {
    }

    @Override
    public void salvar(Usuario obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO "
                + "usuario( "
                + "    cpf, "
                + "    nome, "
                + "    sobrenome, "
                + "    departamento, "
                + "    funcao, "
                + "    senha )"
                + "VALUES( ?, ?, ?, ?, ?, ? );");

        stmt.setString(1, obj.getCpf());
        stmt.setString(2, obj.getNome());
        stmt.setString(3, obj.getSobrenome());
        stmt.setString(4, obj.getDepartamento());
        stmt.setString(5, obj.getFuncao());
        stmt.setString(6, obj.getSenha());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar(Usuario obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE usuario "
                + "SET"
                + "    cpf = ?, "
                + "    nome = ?, "
                + "    sobrenome = ?, "
                + "    departamento = ?, "
                + "    funcao = ?, "
                + "    senha = ? "
                + "WHERE"
                + "    idUsuario = ? ; ");

        stmt.setString(1, obj.getCpf());
        stmt.setString(2, obj.getNome());
        stmt.setString(3, obj.getSobrenome());
        stmt.setString(4, obj.getDepartamento());
        stmt.setString(5, obj.getFuncao());
        stmt.setString(6, obj.getSenha());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Usuario obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM usuario "
                + "WHERE"
                + "    idUsuario = ? ; ");

        stmt.setInt(1, obj.getIdUsuario());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {

        List<Usuario> lista = new ArrayList<Usuario>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    u.idUsuario idUsuario, "
                + "    u.cpf cpfUsuario, "
                + "    u.nome nomeUsuario, "
                + "    u.sobrenome sobrenomeUsuario, "
                + "    u.departamento departamentoUsuario, "
                + "    u.funcao funcaoUsuario "
                + "FROM "
                + "    usuario u ");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Usuario u = new Usuario();

            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setCpf(rs.getString("cpfUsuario"));
            u.setNome(rs.getString("nomeUsuario"));
            u.setSobrenome(rs.getString("sobrenomeUsuario"));
            u.setDepartamento(rs.getString("departamentoUsuario"));
            u.setFuncao(rs.getString("funcaoUsuario"));

            lista.add(u);

        }

        rs.close();
        stmt.close();

        return lista;

    }

    @Override
    public Usuario obterPorId(int id) throws SQLException {

        Usuario u = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    u.idUsuario idUsuario, "
                + "    u.cpf cpfUsuario, "
                + "    u.nome nomeUsuario, "
                + "    u.sobrenome sobrenomeUsuario, "
                + "    u.departamento departamentoUsuario, "
                + "    u.funcao funcaoUsuario "
                + "FROM "
                + "    usuario u "
                + "WHERE"
                + "    u.idUsuario = ? ");

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            u = new Usuario();

            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setCpf(rs.getString("cpfUsuario"));
            u.setNome(rs.getString("nomeUsuario"));
            u.setSobrenome(rs.getString("sobrenomeUsuario"));
            u.setDepartamento(rs.getString("departamentoUsuario"));
            u.setFuncao(rs.getString("funcaoUsuario"));

        }

        rs.close();
        stmt.close();

        return u;

    }

}

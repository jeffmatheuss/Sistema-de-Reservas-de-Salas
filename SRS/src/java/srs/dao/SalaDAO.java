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
import srs.entidades.Sala;

/**
 * DAO para a entidade Sala.
 *
 * @author David Buzatto
 */
public class SalaDAO extends DAO<Sala> {

    public SalaDAO() throws SQLException {
    }

    @Override
    public void salvar(Sala obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO "
                + "Sala( "
                + "    tipoSala, "
                + "    status, "
                + "    descricao, "
                + "    local, "
                + "    estadoConservacao, "
                + "    numero )"
                + "VALUES( ?, ?, ?, ?, ?, ? );");

        stmt.setString(1, obj.getTipoSala());
        stmt.setString(2, obj.getStatus());
        stmt.setString(3, obj.getDescricao());
        stmt.setString(4, obj.getLocal());
        stmt.setString(5, obj.getEstadoConservacao());
        stmt.setString(6, obj.getNumero());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar(Sala obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE usuario "
                + "SET"
                + "    tipoSala = ?, "
                + "    status = ?, "
                + "    descricao = ?, "
                + "    local = ?, "
                + "    estadoConservacao = ?, "
                + "    numero = ? "
                + "WHERE"
                + "    idSala = ? ; ");

        stmt.setString(1, obj.getTipoSala());
        stmt.setString(2, obj.getStatus());
        stmt.setString(3, obj.getDescricao());
        stmt.setString(4, obj.getLocal());
        stmt.setString(5, obj.getEstadoConservacao());
        stmt.setString(6, obj.getNumero());
        stmt.setInt(7, obj.getIdSala());

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
                + "    u.funcao funcaoUsuario, "
                + "    u.senha senhaUsuario "
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
            u.setSenha(rs.getString("senhaUsuario"));

        }

        rs.close();
        stmt.close();

        return u;

    }

}

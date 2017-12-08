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
                + "    `status`, "
                + "    descricao, "
                + "    `local`, "
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
                "UPDATE sala "
                + "SET"
                + "    tipoSala = ?, "
                + "    `status` = ?, "
                + "    descricao = ?, "
                + "    `local` = ?, "
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
    public void excluir(Sala obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM sala "
                + "WHERE"
                + "    idSala = ? ; ");

        stmt.setInt(1, obj.getIdSala());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<Sala> listarTodos() throws SQLException {

        List<Sala> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    s.idSala idSala, "
                + "    s.tipoSala tipoSala"
                + "    s.`status` statusSala, "
                + "    s.descricao descricaoSala, "
                + "    s.`local` localSala, "
                + "    s.estadoConservacao estadoConservacaoSala, "
                + "    s.numero numeroSala "
                + "FROM "
                + "    sala s ");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Sala s = new Sala();

            s.setIdSala(rs.getInt("idSala"));
            s.setTipoSala(rs.getString("tipoSala"));
            s.setStatus(rs.getString("statusSala"));
            s.setDescricao(rs.getString("descricaoSala"));
            s.setLocal(rs.getString("localSala"));
            s.setEstadoConservacao(rs.getString("estadoConservacaoSala"));
            s.setNumero(rs.getString("numeroSala"));

            lista.add(s);

        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Sala obterPorId(int id) throws SQLException {

        Sala s = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    s.idSala idSala, "
                + "    s.tipoSala tipoSala"
                + "    s.`status` statusSala, "
                + "    s.descricao descricaoSala, "
                + "    s.`local` localSala, "
                + "    s.estadoConservacao estadoConservacaoSala, "
                + "    s.numero numeroSala "
                + "FROM "
                + "    sala s "
                + "WHERE"
                + "    s.idSala = ? ");

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            s = new Sala();

            s.setIdSala(rs.getInt("idSala"));
            s.setTipoSala(rs.getString("tipoSala"));
            s.setStatus(rs.getString("statusSala"));
            s.setDescricao(rs.getString("descricaoSala"));
            s.setLocal(rs.getString("localSala"));
            s.setEstadoConservacao(rs.getString("estadoConservacaoSala"));
            s.setNumero(rs.getString("numeroSala"));

        }

        rs.close();
        stmt.close();

        return s;

    }

}

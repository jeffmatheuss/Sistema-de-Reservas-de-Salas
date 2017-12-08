/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import srs.entidades.Reserva;
import srs.entidades.Sala;
import srs.entidades.Usuario;

/**
 *
 * @author Laionel
 */
public class ReservaDAO extends DAO<Reserva> {

    public ReservaDAO() throws SQLException {
    }

    @Override
    public void salvar(Reserva obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO "
                + "reserva( "
                + "    idUsuario, "
                + "    idSala, "
                + "    dataReserva ) "
                + "VALUES( ?, ?, ? ); ");

        stmt.setInt(1, obj.getUsuario().getIdUsuario());
        stmt.setInt(2, obj.getSala().getIdSala());
        stmt.setDate(3, obj.getDataReserva());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar(Reserva obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE reserva "
                + "SET"
                + "    idUsuario = ?, "
                + "    idSala = ?, "
                + "    dataReserva = ? "
                + "WHERE"
                + "    idReserva = ? ; ");

        stmt.setInt(1, obj.getUsuario().getIdUsuario());
        stmt.setInt(2, obj.getSala().getIdSala());
        stmt.setDate(3, obj.getDataReserva());
        stmt.setInt(4, obj.getIdReserva());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Reserva obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM reserva "
                + "WHERE"
                + "    idReserva = ? ; ");

        stmt.setInt(1, obj.getIdReserva());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<Reserva> listarTodos() throws SQLException {

        List<Reserva> lista = new ArrayList<Reserva>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    r.idReserva idReserva, "
                + "    r.dataReserva dataReserva, "
                + "    s.idSala idSala, "
                + "    s.tipoSala tipoSala, "
                + "    s.status statusSala, "
                + "    s.descricao descricaoSala, "
                + "    s.local localSala, "
                + "    s.estadoConservacao estadoConservacaoSala, "
                + "    s.numero numeroSala, "
                + "    u.idUsuario idUsuario, "
                + "    u.cpf cpfUsuario, "
                + "    u.nome nomeUsuario, "
                + "    u.sobrenome sobrenomeUsuario, "
                + "    u.departamento departamentoUsuario, "
                + "    u.funcao funcaoUsuario, "
                + "    u.senha senhaUsuario "
                + "FROM "
                + "    reserva r, "
                + "    sala s,"
                + "    usuario u "
                + "WHERE"
                + "    r.idSala = s.idSala AND "
                + "    r.idUsuario = u.idUsuario; ");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Reserva r = new Reserva();
            Sala s = new Sala();
            Usuario u = new Usuario();

            r.setIdReserva(rs.getInt("idReserva"));
            r.setSala(s);
            r.setUsuario(u);
            r.setDataReserva(rs.getDate("dataReserva"));

            s.setIdSala(rs.getInt("idSala"));
            s.setTipoSala(rs.getString("tipoSala"));
            s.setStatus(rs.getString("statusSala"));
            s.setDescricao(rs.getString("descricaoSala"));
            s.setLocal(rs.getString("localSala"));
            s.setEstadoConservacao(rs.getString("estadoConservacaoSala"));
            s.setNumero(rs.getString("numeroSala"));

            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setCpf(rs.getString("cpfUsuario"));
            u.setNome(rs.getString("nomeUsuario"));
            u.setSobrenome(rs.getString("sobrenomeUsuario"));
            u.setDepartamento(rs.getString("departamentoUsuario"));
            u.setFuncao(rs.getString("funcaoUsuario"));
            u.setSenha(rs.getString("senhaUsuario"));

            lista.add(r);

        }

        rs.close();
        stmt.close();

        return lista;

    }

    @Override
    public Reserva obterPorId(int id) throws SQLException {

        Reserva r = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    r.idReserva idReserva, "
                + "    r.dataReserva dataReserva, "
                + "    s.idSala idSala, "
                + "    s.tipoSala tipoSala, "
                + "    s.status statusSala, "
                + "    s.descricao descricaoSala, "
                + "    s.local localSala, "
                + "    s.estadoConservacao estadoConservacaoSala, "
                + "    s.numero numeroSala, "
                + "    u.idUsuario idUsuario, "
                + "    u.cpf cpfUsuario, "
                + "    u.nome nomeUsuario, "
                + "    u.sobrenome sobrenomeUsuario, "
                + "    u.departamento departamentoUsuario, "
                + "    u.funcao funcaoUsuario, "
                + "    u.senha senhaUsuario "
                + "FROM "
                + "    reserva r, "
                + "    sala s,"
                + "    usuario u "
                + "WHERE"
                + "    r.idReserva = ? AND "
                + "    r.idSala = s.idSala AND "
                + "    r.idUsuario = u.idUsuario; ");

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            
            r = new Reserva();
            Sala s = new Sala();
            Usuario u = new Usuario();

            r.setIdReserva(rs.getInt("idReserva"));
            r.setSala(s);
            r.setUsuario(u);
            r.setDataReserva(rs.getDate("dataReserva"));

            s.setIdSala(rs.getInt("idSala"));
            s.setTipoSala(rs.getString("tipoSala"));
            s.setStatus(rs.getString("statusSala"));
            s.setDescricao(rs.getString("descricaoSala"));
            s.setLocal(rs.getString("localSala"));
            s.setEstadoConservacao(rs.getString("estadoConservacaoSala"));
            s.setNumero(rs.getString("numeroSala"));

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

        return r;

    }

}

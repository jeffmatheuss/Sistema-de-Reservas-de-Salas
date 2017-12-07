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
                + "    idUsuario = ?, "
                + "    idSala = ?, "
                + "    dataReserva = ? )"
                + "VALUES( ?, ?, ? );");

        stmt.setInt(1, obj.getIdUsuario());
        stmt.setInt(2, obj.getIdSala());
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

        stmt.setInt(1, obj.getIdUsuario());
        stmt.setInt(2, obj.getIdSala());
        stmt.setDate(3, obj.getDataReserva());
        stmt.setInt(7, obj.getIdReserva());

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
                + "    r.idUsuario idUsuario, "
                + "    r.idSala idSala, "
                + "    r.dataReserva dataReserva "
                + "FROM "
                + "    reserva r ");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Reserva r = new Reserva();

            r.setIdReserva(rs.getInt("idReserva"));
            r.setIdUsuario(rs.getInt("idUsuario"));
            r.setIdSala(rs.getInt("idSala"));
            r.setDataReserva(rs.getDate("dataReserva"));

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
                + "    r.idUsuario idUsuario, "
                + "    r.idSala idSala, "
                + "    r.dataReserva dataReserva "
                + "FROM "
                + "    reserva r "
                + "WHERE"
                + "    r.idReserva = ? ");

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            r = new Reserva();

            r.setIdReserva(rs.getInt("idReserva"));
            r.setIdUsuario(rs.getInt("idUsuario"));
            r.setIdSala(rs.getInt("idSala"));
            r.setDataReserva(rs.getDate("dataReserva"));

        }

        rs.close();
        stmt.close();

        return r;

    }

}

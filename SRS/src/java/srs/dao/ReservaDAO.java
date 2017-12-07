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
    public void atualizar(Reserva obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE reserva "
                + "SET"
                + "    cpf = ?, "
                + "    nome = ?, "
                + "    sobrenome = ?, "
                + "    departamento = ?, "
                + "    funcao = ?, "
                + "    senha = ? "
                + "WHERE"
                + "    idReserva = ? ; ");

        stmt.setString(1, obj.getCpf());
        stmt.setString(2, obj.getNome());
        stmt.setString(3, obj.getSobrenome());
        stmt.setString(4, obj.getDepartamento());
        stmt.setString(5, obj.getFuncao());
        stmt.setString(6, obj.getSenha());
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
                + "    u.idReserva idReserva, "
                + "    u.cpf cpfReserva, "
                + "    u.nome nomeReserva, "
                + "    u.sobrenome sobrenomeReserva, "
                + "    u.departamento departamentoReserva, "
                + "    u.funcao funcaoReserva "
                + "FROM "
                + "    reserva u ");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Reserva r = new Reserva();

            r.setIdReserva(rs.getInt("idReserva"));
            r.setCpf(rs.getString("cpfReserva"));
            r.setNome(rs.getString("nomeReserva"));
            r.setSobrenome(rs.getString("sobrenomeReserva"));
            r.setDepartamento(rs.getString("departamentoReserva"));
            r.setFuncao(rs.getString("funcaoReserva"));

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
                + "    r.cpf cpfReserva, "
                + "    r.nome nomeReserva, "
                + "    r.sobrenome sobrenomeReserva, "
                + "    r.departamento departamentoReserva, "
                + "    r.funcao funcaoReserva, "
                + "    r.senha senhaReserva "
                + "FROM "
                + "    reserva r "
                + "WHERE"
                + "    u.idReserva = ? ");

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            r = new Reserva();

            r.setIdReserva(rs.getInt("idReserva"));
            r.setCpf(rs.getString("cpfReserva"));
            r.setNome(rs.getString("nomeReserva"));
            r.setSobrenome(rs.getString("sobrenomeReserva"));
            r.setDepartamento(rs.getString("departamentoReserva"));
            r.setFuncao(rs.getString("funcaoReserva"));
            r.setSenha(rs.getString("senhaReserva"));

        }

        rs.close();
        stmt.close();

        return r;

    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srs.servicos;

import srs.dao.SalaDAO;
import srs.entidades.Sala;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de serviços para a entidade Sala.
 */
public class SalaServices {

    /**
     * Usa o SalaDAO para obter todos as Salas.
     *
     * @return Lista de Salas.
     */
    public List<Sala> getTodos() {

        List<Sala> lista = new ArrayList<Sala>();
        SalaDAO dao = null;

        try {
            dao = new SalaDAO();
            lista = dao.listarTodos();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        return lista;

    }
    public List<Sala> getTodosReserva() {

        List<Sala> lista = new ArrayList<Sala>();
        SalaDAO dao = null;

        try {
            dao = new SalaDAO();
            lista = dao.listarTodosReserva();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        return lista;

    }

}

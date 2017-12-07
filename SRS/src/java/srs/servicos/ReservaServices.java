/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srs.servicos;

import srs.dao.ReservaDAO;
import srs.entidades.Reserva;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de serviços para a entidade Reserva.
 */
public class ReservaServices {

    /**
     * Usa o ReservaDAO para obter todos os Reservas.
     *
     * @return Lista de Reservas.
     */
    public List<Reserva> getTodos() {

        List<Reserva> lista = new ArrayList<Reserva>();
        ReservaDAO dao = null;

        try {
            dao = new ReservaDAO();
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

}

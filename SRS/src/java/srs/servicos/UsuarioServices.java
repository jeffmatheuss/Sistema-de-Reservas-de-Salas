/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srs.servicos;

import srs.dao.UsuarioDAO;
import srs.entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de serviços para a entidade Usuario.
 *
 * @author David Buzatto
 */
public class UsuarioServices {

    /**
     * Usa o UsuarioDAO para obter todos os Usuarios.
     *
     * @return Lista de Usuarios.
     */
    public List<Usuario> getTodos() {

        List<Usuario> lista = new ArrayList<Usuario>();
        UsuarioDAO dao = null;

        try {
            dao = new UsuarioDAO();
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

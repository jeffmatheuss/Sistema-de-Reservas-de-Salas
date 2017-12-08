/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.controladores;

import srs.dao.SalaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import srs.entidades.Sala;

/**
 * Servlet para tratar Usuarios.
 *
 * @author David Buzatto
 */
public class SalasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        SalaDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new SalaDAO();

            if (acao.equals("criar")) {

                String tipoSala = request.getParameter("tipoSala");
                String status = request.getParameter("status");
                String descricao = request.getParameter("descricao");
                String local = request.getParameter("local");
                String estadoConservacao = request.getParameter("estadoConservacao");
                String numero = request.getParameter("numero");

                Sala s = new Sala();

                s.setTipoSala(tipoSala);
                s.setStatus(status);
                s.setDescricao(descricao);
                s.setLocal(local);
                s.setEstadoConservacao(estadoConservacao);
                s.setNumero(numero);

                dao.salvar(s);

                disp = request.getRequestDispatcher(
                        "/formularios/salas/listagem.jsp");

            } else if (acao.equals("alterar")) {

                int id = Integer.parseInt(request.getParameter("idSala"));
                String tipoSala = request.getParameter("tipoSala");
                String status = request.getParameter("status");
                String descricao = request.getParameter("descricao");
                String local = request.getParameter("local");
                String estadoConservacao = request.getParameter("estadoConservacao");
                String numero = request.getParameter("numero");

                Sala s = new Sala();
                
                s.setIdSala(id);
                s.setTipoSala(tipoSala);
                s.setStatus(status);
                s.setDescricao(descricao);
                s.setLocal(local);
                s.setEstadoConservacao(estadoConservacao);
                s.setNumero(numero);

                dao.atualizar(s);

                disp = request.getRequestDispatcher(
                        "/formularios/salas/listagem.jsp");

            } else if (acao.equals("excluir")) {

                int id = Integer.parseInt(request.getParameter("idSala"));

                Sala s = new Sala();
                s.setIdSala(id);

                dao.excluir(s);

                disp = request.getRequestDispatcher(
                        "/formularios/sala/listagem.jsp");

            } else if (acao.equals("prepAlteracao")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Sala s = dao.obterPorId(id);
                request.setAttribute("sala", s);

                disp = request.getRequestDispatcher(
                        "/formularios/salas/alterar.jsp");

            } else if (acao.equals("prepExclusao")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Sala s = dao.obterPorId(id);
                request.setAttribute("sala", s);

                disp = request.getRequestDispatcher(
                        "/formularios/salas/excluir.jsp");

            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
        }

        if (disp != null) {
            disp.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

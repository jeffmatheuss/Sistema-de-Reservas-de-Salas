/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.controladores;

import srs.dao.ReservaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import srs.entidades.Reserva;

/**
 * Servlet para tratar Reservas.
 */
public class ReservasServlet extends HttpServlet {

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
        ReservaDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new ReservaDAO();

            if (acao.equals("criar")) {

                String cpf = request.getParameter("cpf");
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String departamento = request.getParameter("departamento");
                String funcao = request.getParameter("funcao");
                String senha = request.getParameter("senha");

                Reserva r = new Reserva();

                r.setCpf(cpf);
                r.setNome(nome);
                r.setSobrenome(sobrenome);
                r.setDepartamento(departamento);
                r.setFuncao(funcao);
                r.setSenha(senha);

                dao.salvar(r);

                disp = request.getRequestDispatcher(
                        "/formularios/reservas/listagem.jsp");

            } else if (acao.equals("alterar")) {

                int id = Integer.parseInt(request.getParameter("idReserva"));
                String cpf = request.getParameter("cpf");
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String departamento = request.getParameter("departamento");
                String funcao = request.getParameter("funcao");
                String senha = request.getParameter("senha");

                Reserva r = new Reserva();
                r.setIdReserva(id);
                r.setCpf(cpf);
                r.setNome(nome);
                r.setSobrenome(sobrenome);
                r.setDepartamento(departamento);
                r.setFuncao(funcao);
                r.setSenha(senha);

                dao.atualizar(r);

                disp = request.getRequestDispatcher(
                        "/formularios/reservas/listagem.jsp");

            } else if (acao.equals("excluir")) {

                int id = Integer.parseInt(request.getParameter("idReserva"));

                Reserva r = new Reserva();
                r.setIdReserva(id);

                dao.excluir(r);

                disp = request.getRequestDispatcher(
                        "/formularios/reservas/listagem.jsp");

            } else if (acao.equals("prepAlteracao")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Reserva r = dao.obterPorId(id);
                request.setAttribute("reserva", r);

                disp = request.getRequestDispatcher(
                        "/formularios/reservas/alterar.jsp");

            } else if (acao.equals("prepExclusao")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Reserva r = dao.obterPorId(id);
                request.setAttribute("reserva", r);

                disp = request.getRequestDispatcher(
                        "/formularios/reservas/excluir.jsp");

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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.controladores;

import srs.dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import srs.entidades.Usuario;

/**
 * Servlet para tratar Usuarios.
 *
 * @author David Buzatto
 */
public class UsuariosServlet extends HttpServlet {

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
        UsuarioDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new UsuarioDAO();

            if (acao.equals("criar")) {

                String cpf = request.getParameter("cpf");
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String departamento = request.getParameter("departamento");
                String funcao = request.getParameter("funcao");
                String senha = request.getParameter("senha");

                Usuario u = new Usuario();

                u.setCpf(cpf);
                u.setNome(nome);
                u.setSobrenome(sobrenome);
                u.setDepartamento(departamento);
                u.setFuncao(funcao);
                u.setSenha(senha);

                dao.salvar(u);

                disp = request.getRequestDispatcher(
                        "/formularios/usuarios/listagem.jsp");

            } else if (acao.equals("alterar")) {

                int id = Integer.parseInt(request.getParameter("idUsuario"));
                String cpf = request.getParameter("cpf");
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String departamento = request.getParameter("departamento");
                String funcao = request.getParameter("funcao");
                String senha = request.getParameter("senha");

                Usuario u = new Usuario();
                u.setIdUsuario(id);
                u.setCpf(cpf);
                u.setNome(nome);
                u.setSobrenome(sobrenome);
                u.setDepartamento(departamento);
                u.setFuncao(funcao);
                u.setSenha(senha);

                dao.atualizar(u);

                disp = request.getRequestDispatcher(
                        "/formularios/usuarios/listagem.jsp");

            } else if (acao.equals("excluir")) {

                int id = Integer.parseInt(request.getParameter("idUsuario"));

                Usuario u = new Usuario();
                u.setIdUsuario(id);

                dao.excluir(u);

                disp = request.getRequestDispatcher(
                        "/formularios/usuarios/listagem.jsp");

            } else if (acao.equals("prepAlteracao")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Usuario u = dao.obterPorId(id);
                request.setAttribute("usuario", u);

                disp = request.getRequestDispatcher(
                        "/formularios/usuarios/alterar.jsp");

            } else if (acao.equals("prepExclusao")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Usuario u = dao.obterPorId(id);
                request.setAttribute("usuario", u);

                disp = request.getRequestDispatcher(
                        "/formularios/usuarios/excluir.jsp");

            } else if (acao.equals("login")) { //em construção

                String usuarioLogin = request.getParameter("usuarioLogin");
                Usuario u = dao.obterNome(usuarioLogin);

                if (u == null) {
                    disp = request.getRequestDispatcher(
                            "index.jsp");

                    request.setAttribute("msg", "Usuário não encontrado");
                } else {
                    String senhaLogin = request.getParameter("senhaLogin");
                    if (u.getSenha().equals(senhaLogin)) {
                        disp = request.getRequestDispatcher(
                                "menu.jsp");
                        HttpSession sessao = request.getSession(true);
                        sessao.setAttribute("usuarioId", u.getIdUsuario());
                        sessao.setAttribute("nomeUsuario", u.getNome());
                    } else {
                        disp = request.getRequestDispatcher(
                                "index.jsp");
                        request.setAttribute("msg", "Senha inválida!");
                    }
                }
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

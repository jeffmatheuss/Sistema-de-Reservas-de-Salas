/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package srs.dao;

import srs.dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import srs.entidades.Usuario;

/**
 * DAO para a entidade Usuario.
 *
 * @author David Buzatto
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() throws SQLException {
    }

    @Override
    public void salvar( Usuario obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO "
                + "usuario( "
                + "    nome, "
                + "    sobrenome, "
                + "    dataNascimento, "
                + "    cpf, "
                + "    email, "
                + "    logradouro, "
                + "    numero, "
                + "    bairro, "
                + "    cep, "
                + "    cidade_id ) "
                + "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSobrenome() );
        stmt.setDate( 3, obj.getDataNascimento() );
        stmt.setString( 4, obj.getCpf() );
        stmt.setString( 5, obj.getEmail() );
        stmt.setString( 6, obj.getLogradouro() );
        stmt.setString( 7, obj.getNumero() );
        stmt.setString( 8, obj.getBairro() );
        stmt.setString( 9, obj.getCep() );
        stmt.setInt( 10, obj.getCidade().getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar( Usuario obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE usuario "
                + "SET"
                + "    nome = ?, "
                + "    sobrenome = ?,"
                + "    dataNascimento = ?, "
                + "    cpf = ?, "
                + "    email = ?, "
                + "    logradouro = ?, "
                + "    numero = ?, "
                + "    bairro = ?, "
                + "    cep = ?, "
                + "    cidade_id = ? "
                + "WHERE"
                + "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSobrenome() );
        stmt.setDate( 3, obj.getDataNascimento() );
        stmt.setString( 4, obj.getCpf() );
        stmt.setString( 5, obj.getEmail() );
        stmt.setString( 6, obj.getLogradouro() );
        stmt.setString( 7, obj.getNumero() );
        stmt.setString( 8, obj.getBairro() );
        stmt.setString( 9, obj.getCep() );
        stmt.setInt( 10, obj.getCidade().getId() );
        stmt.setInt( 11, obj.getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir( Usuario obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM usuario "
                + "WHERE"
                + "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {

        List<Usuario> lista = new ArrayList<Usuario>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    c.id idUsuario, "
                + "    c.nome nomeUsuario, "
                + "    c.sobreNome sobrenomeUsuario, "
                + "    c.dataNascimento dataNascimentoUsuario, "
                + "    c.cpf cpfUsuario, "
                + "    c.email emailUsuario, "
                + "    c.logradouro logradouroUsuario, "
                + "    c.numero numeroUsuario, "
                + "    c.bairro bairroUsuario, "
                + "    c.cep cepUsuario, "
                + "    ci.id idCidade, "
                + "    ci.nome nomeCidade, "
                + "    e.id idEstado, "
                + "    e.nome nomeEstado, "
                + "    e.sigla siglaEstado "
                + "FROM "
                + "    usuario c, "
                + "    cidade ci, "
                + "    estado e "
                + "WHERE"
                + "    c.cidade_id = ci.id AND "
                + "    ci.estado_id = e.id;" );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Usuario u = new Usuario();

            u.setId( rs.getInt( "idUsuario" ) );
            u.setNome( rs.getString( "nomeUsuario" ) );
            u.setSobrenome( rs.getString( "sobrenomeUsuario" ) );
            u.setDataNascimento( rs.getDate( "dataNascimentoUsuario" ) );
            u.setCpf( rs.getString( "cpfUsuario" ) );
            u.setEmail( rs.getString( "emailUsuario" ) );
            u.setLogradouro( rs.getString( "logradouroUsuario" ) );
            u.setNumero( rs.getString( "numeroUsuario" ) );
            u.setBairro( rs.getString( "bairroUsuario" ) );
            u.setCep( rs.getString( "cepUsuario" ) );
            u.setCidade( ci );

            lista.add( u );

        }

        rs.close();
        stmt.close();

        return lista;

    }

    @Override
    public Usuario obterPorId( int id ) throws SQLException {

        Usuario usuario = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    c.id idUsuario, "
                + "    c.nome nomeUsuario, "
                + "    c.sobreNome sobrenomeUsuario, "
                + "    c.dataNascimento dataNascimentoUsuario, "
                + "    c.cpf cpfUsuario, "
                + "    c.email emailUsuario, "
                + "    c.logradouro logradouroUsuario, "
                + "    c.numero numeroUsuario, "
                + "    c.bairro bairroUsuario, "
                + "    c.cep cepUsuario, "
                + "    ci.id idCidade, "
                + "    ci.nome nomeCidade, "
                + "    e.id idEstado, "
                + "    e.nome nomeEstado, "
                + "    e.sigla siglaEstado "
                + "FROM "
                + "    usuario c, "
                + "    cidade ci, "
                + "    estado e "
                + "WHERE"
                + "    c.id = ? AND "
                + "    c.cidade_id = ci.id AND "
                + "    ci.estado_id = e.id;" );

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            usuario = new Usuario();

            usuario.setIdUsuario(rs.getInt( "idUsuario" ) );
            usuario.setNome( rs.getString( "nomeUsuario" ) );
            usuario.setSobrenome( rs.getString( "sobrenomeUsuario" ) );
            usuario.setDataNascimento( rs.getDate( "dataNascimentoUsuario" ) );
            usuario.setCpf( rs.getString( "cpfUsuario" ) );
            usuario.setEmail( rs.getString( "emailUsuario" ) );
            usuario.setLogradouro( rs.getString( "logradouroUsuario" ) );
            usuario.setNumero( rs.getString( "numeroUsuario" ) );
            usuario.setBairro( rs.getString( "bairroUsuario" ) );
            usuario.setCep( rs.getString( "cepUsuario" ) );
            usuario.setCidade( cidade );

        }

        rs.close();
        stmt.close();

        return usuario;

    }

}

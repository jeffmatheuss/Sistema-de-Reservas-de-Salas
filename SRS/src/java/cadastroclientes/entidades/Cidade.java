/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cadastroclientes.entidades;

/**
 * Entidade Cidade.
 *
 * @author David Buzatto
 */
public class Cidade {

    private int id;
    private String nome;
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado( Estado estado ) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

}

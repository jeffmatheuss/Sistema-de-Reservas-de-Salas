/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.entidades;

import java.sql.Date;

/**
 * Entidade Histórico Reserva
 * Baseado nos códigos de David Buzatto
 * @author Laionel - Jeferson
 */
public class HistoricoReserva {

    public int idHistoricoReserva;
    public Usuario usuario;
    public Sala sala;
    public Date dataReserva;
    public String estadoConservacao;

    public int getIdHistoricoReserva() {
        return idHistoricoReserva;
    }

    public void setIdHistoricoReserva(int idHistoricoReserva) {
        this.idHistoricoReserva = idHistoricoReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

}

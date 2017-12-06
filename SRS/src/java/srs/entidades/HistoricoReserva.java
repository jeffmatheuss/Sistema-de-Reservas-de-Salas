/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.entidades;

import java.sql.Date;

/**
 *
 * @author Laionel
 */
public class HistoricoReserva {
    public int idHistoricoReserva;
    public int idUsuario;
    public int idSala;

    public int getIdHistoricoReserva() {
        return idHistoricoReserva;
    }

    public void setIdHistoricoReserva(int idHistoricoReserva) {
        this.idHistoricoReserva = idHistoricoReserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
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
    public Date dataReserva;
    public String estadoConservacao;
}

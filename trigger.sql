use srs;
DELIMITER //
CREATE TRIGGER tg_gravar_historico
AFTER INSERT ON reserva FOR EACH ROW
BEGIN
    DECLARE varIdHistorico INT;
    DECLARE varEstadoConservacao VARCHAR(255);

    INSERT INTO historicoreservas
        (idUsuario, idSala, dataReserva)
    VALUES
        (NEW.idUsuario, NEW.idSala, NEW.dataReserva);

    SET varIdHistorico = (
        SELECT MAX( idHistoricoReserva )
        FROM   historicoreservas
    );

    SET varEstadoConservacao = (
        SELECT estadoConservacao
        FROM   sala
        WHERE  idSala = NEW.idSala
    );
	
    UPDATE historicoreservas
    SET    estadoConservacao = varEstadoConservacao
    WHERE  idHistoricoReserva = varIdHistorico;
    
    UPDATE sala
    SET	   `status` = "Reservada"
    WHERE idSala = NEW.idSala;
END //;
DELIMITER ;



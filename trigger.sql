
use srs;
drop trigger tg_gravar_historico;
drop trigger tg_alterar_disp_sala;
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

DELIMITER //
CREATE TRIGGER tg_alterar_disp_sala
AFTER DELETE ON reserva FOR EACH ROW
BEGIN
    UPDATE sala
    SET	   `status` = "Disponível"
    WHERE idSala = OLD.idSala;
END //;
DELIMITER ;

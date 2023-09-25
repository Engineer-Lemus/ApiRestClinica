package med.voll.api.dominio.consulta.validaciones.agendamiento.cancelaciones;

import jakarta.validation.ValidationException;
import med.voll.api.dominio.consulta.ConsultaRepository;
import med.voll.api.dominio.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorCancelamientoHorarioAntecedentes implements  ValidadorCancelamientoDeConsulta {
    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DatosCancelamientoConsulta datos) {
        var consulta = repository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferencaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();

        if (diferencaEnHoras < 24) {
            throw new ValidationException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }

}

package med.voll.api.dominio.consulta.validaciones.agendamiento;

import jakarta.validation.ValidationException;
import med.voll.api.dominio.consulta.DatosAgendarConsulta;
import med.voll.api.dominio.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoActivo implements ValidadorDeConsultas {

    @Autowired
    private MedicoRepository repository;
    public void validar(DatosAgendarConsulta datos){

        if(datos.idMedico() == null){
            return;
        }

        var medicoActivo = repository.findActivoById(datos.idMedico());

        if (!(Boolean) medicoActivo) {
            throw new ValidationException("No se puede permitir agendar citas con medicos inactivos en el sistema");
        }

    }
}

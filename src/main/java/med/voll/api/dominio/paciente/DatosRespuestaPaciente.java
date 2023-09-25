package med.voll.api.dominio.paciente;

import med.voll.api.dominio.direccion.Direccion;

public record DatosRespuestaPaciente(String nombre, String email,
                                     String documento,
                                     String telefono,
                                     Direccion direccion) {
    public DatosRespuestaPaciente(Paciente paciente) {
        this(paciente.getNombre(), paciente.getEmail(), paciente.getTelefono()
                , paciente.getDocumento(), paciente.getDireccion());
    }
}
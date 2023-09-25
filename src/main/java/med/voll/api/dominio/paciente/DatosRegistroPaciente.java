package med.voll.api.dominio.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dominio.direccion.DatosDireccion;

public record DatosRegistroPaciente(
        @NotBlank(message = "{nombre.obligatorio}") String nombre,
        @NotBlank(message = "{email.obligatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{telefono.obligatorio}")
        @Pattern(regexp = "\\d{10}", message = "{telefono.invalido}")
        String telefono,
        @NotBlank (message = "{documento.invalido}")
        @Pattern(regexp = "\\d{10}", message = "{documento.invalido}")
        String documento,
        @NotNull (message = "{direccion.obligatorio}")
        @Valid DatosDireccion direccion)
 {
}
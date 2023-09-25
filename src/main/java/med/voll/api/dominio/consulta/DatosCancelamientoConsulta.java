package med.voll.api.dominio.consulta;

import jakarta.validation.constraints.NotNull;

public record DatosCancelamientoConsulta(
         @NotNull
         Long idConsulta,

         @NotNull
         MotivoCancelamiento motivo
) {


}

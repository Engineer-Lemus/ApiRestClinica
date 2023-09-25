package med.voll.api.dominio.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findByActivoTrue(Pageable paginacion);

    @Query("""
    select m.activo
    from Paciente m
    where
    m.id = :idPaciente
    """)
    Boolean findActivoById(Long idPaciente);
}

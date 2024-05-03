package perinity.api.repository;

import perinity.api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Tarefa findByDepartamentoId(Long id);

    List<Tarefa> findAllByPessoaAlocadaIsNullOrderByPrazoAsc();
}

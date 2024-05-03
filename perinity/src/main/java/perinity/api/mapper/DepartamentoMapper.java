package perinity.api.mapper;

import perinity.api.dto.DepartamentoDTO;
import perinity.api.model.Departamento;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class DepartamentoMapper {
    public DepartamentoDTO toDTO(Departamento departamento) {
        var departamentoDTO = new DepartamentoDTO();
        departamentoDTO.setId(departamento.getId());
        departamentoDTO.setNome(departamento.getNome());
        if (departamento.getListaDePessoas() != null) {
            AtomicLong quantidadeDePessoas = new AtomicLong(0L);
            departamento.getListaDePessoas().forEach(pessoa -> {
                quantidadeDePessoas.getAndIncrement();
            });
            departamentoDTO.setQuantidadeDePessoas(quantidadeDePessoas.get());
        }
        if (departamento.getListaDeTarefas() != null) {
            AtomicLong quantidadeDeTarefas = new AtomicLong(0L);
            departamento.getListaDeTarefas().forEach(tarefa -> {
                quantidadeDeTarefas.getAndIncrement();
            });
            departamentoDTO.setQuantidadeDeTarefas(quantidadeDeTarefas.get());
        }
        return departamentoDTO;
    }
}

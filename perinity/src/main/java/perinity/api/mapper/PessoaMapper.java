package perinity.api.mapper;

import perinity.api.dto.PessoaDTO;
import perinity.api.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PessoaMapper {
    public PessoaDTO toDTO(Pessoa pessoa) {
        var pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        if (pessoa.getDepartamento() != null) {
            pessoaDTO.setDepartamento(pessoa.getDepartamento().getNome());
        }
        if (pessoa.getListaDeTarefas() != null) {
            AtomicLong totalHorasTarefa = new AtomicLong(0L);
            pessoa.getListaDeTarefas().forEach(tarefa -> {
                totalHorasTarefa.addAndGet(tarefa.getDuracao());});
            pessoaDTO.setTotalHorasTarefas(totalHorasTarefa.get());
        }

        return pessoaDTO;
    }
}

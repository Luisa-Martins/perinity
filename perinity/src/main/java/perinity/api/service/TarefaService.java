package perinity.api.service;

import perinity.api.model.Tarefa;
import perinity.api.repository.PessoaRepository;
import perinity.api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public void create(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    @Transactional
    public void finishTask(Long id) {
        var tarefa = tarefaRepository.getReferenceById(id);
        tarefa.setFinalizado(true);
        tarefaRepository.save(tarefa);
    }

    @Transactional
    public void allocateTask(Long id) {
        var pessoa = pessoaRepository.getReferenceById(id);
        var departamentoId = pessoa.getDepartamento().getId();
        var tarefa = tarefaRepository.findByDepartamentoId(departamentoId);

        tarefa.setPessoaAlocada(pessoa);
        tarefaRepository.save(tarefa);
    }

    @Transactional
    public List<Tarefa> findOldestWithNoPerson() {
        var tarefas = tarefaRepository.findAllByPessoaAlocadaIsNullOrderByPrazoAsc();
        tarefas = tarefas.subList(0, 3);
        return tarefas;
    }
}

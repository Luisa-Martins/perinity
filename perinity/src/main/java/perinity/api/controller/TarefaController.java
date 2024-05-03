package perinity.api.controller;

import jakarta.validation.Valid;
import perinity.api.model.Tarefa;
import perinity.api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid Tarefa tarefa) {
        tarefaService.create(tarefa);
    }

    @PutMapping("/finalizar/{id}")
    @Transactional
    public void finishTask(@PathVariable Long id) {
        tarefaService.finishTask(id);
    }

    @PutMapping("/alocar/{id}")
    @Transactional
    public void allocate(@PathVariable Long id) {
        tarefaService.allocateTask(id);
    }

    @GetMapping("pendentes")
    @Transactional
    public List<Tarefa> findOldest() {
        return tarefaService.findOldestWithNoPerson();
    }
}

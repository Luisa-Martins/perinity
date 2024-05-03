package perinity.api.controller;

import jakarta.validation.Valid;
import perinity.api.dto.PessoaDTO;
import perinity.api.mapper.PessoaMapper;
import perinity.api.model.Pessoa;
import perinity.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaMapper pessoaMapper;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid Pessoa pessoa) {
        pessoaService.create(pessoa);
    }

    @GetMapping
    @Transactional
    public List<PessoaDTO> findAll() {
        var pessoas = pessoaService.findAll();
        var dto = pessoas.stream()
                .map(pessoa -> pessoaMapper.toDTO(pessoa))
                .collect(Collectors.toList());
        return dto;
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@RequestBody @Valid Pessoa pessoa, @PathVariable Long id) {
        pessoaService.update(pessoa, id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        pessoaService.delete(id);
    }
}

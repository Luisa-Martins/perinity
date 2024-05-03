package perinity.api.service;

import perinity.api.model.Pessoa;
import perinity.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public void create(Pessoa pessoa) {
        repository.save(pessoa);
    }

    public void update(Pessoa pessoa, Long id) {
        pessoa.setId(id);
        repository.save(pessoa);
    }

    public void delete(Long id) {
        var pessoa = repository.getReferenceById(id);
        repository.delete(pessoa);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }
}

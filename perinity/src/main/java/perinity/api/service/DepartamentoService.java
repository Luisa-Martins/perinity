package perinity.api.service;

import perinity.api.model.Departamento;
import perinity.api.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository repository;

    public List<Departamento> findAll() {
        return repository.findAll();
    }
}

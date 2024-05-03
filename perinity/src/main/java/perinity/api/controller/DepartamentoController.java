package perinity.api.controller;

import perinity.api.dto.DepartamentoDTO;
import perinity.api.mapper.DepartamentoMapper;
import perinity.api.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private DepartamentoMapper departamentoMapper;

    @GetMapping
    @Transactional
    public List<DepartamentoDTO> findAll() {
        var departamentos = departamentoService.findAll();
        var dto = departamentos.stream()
                .map(departamento -> departamentoMapper.toDTO(departamento))
                .collect(Collectors.toList());
        return dto;
    }
}

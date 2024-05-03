package perinity.api.controller;

import perinity.api.dto.DepartamentoDTO;
import perinity.api.mapper.DepartamentoMapper;
import perinity.api.model.Departamento;
import perinity.api.service.DepartamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartamentoControllerTest {

    @Mock
    private DepartamentoService departamentoService;

    @Mock
    private DepartamentoMapper departamentoMapper;

    @InjectMocks
    private DepartamentoController departamentoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_ShouldReturnDepartamentoDtoList() {
        // Arrange
        Departamento departamento = new Departamento();
        departamento.setId(1L);
        departamento.setNome("Technology");
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setId(1L);
        dto.setNome("Technology");

        when(departamentoService.findAll()).thenReturn(Arrays.asList(departamento));
        when(departamentoMapper.toDTO(any(Departamento.class))).thenReturn(dto);

        // Act
        List<DepartamentoDTO> result = departamentoController.findAll();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));

        verify(departamentoService).findAll();
        verify(departamentoMapper).toDTO(departamento);
    }
}

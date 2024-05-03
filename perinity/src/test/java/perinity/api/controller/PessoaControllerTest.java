package perinity.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import perinity.api.dto.PessoaDTO;
import perinity.api.mapper.PessoaMapper;
import perinity.api.model.Pessoa;
import perinity.api.service.PessoaService;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PessoaControllerTest {

    @Mock
    private PessoaService pessoaService;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaController pessoaController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_ReturnsPessoaDtoList() {
        // Setup
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(1L);
        pessoaDTO.setNome("João");

        when(pessoaService.findAll()).thenReturn(Arrays.asList(pessoa));
        when(pessoaMapper.toDTO(any(Pessoa.class))).thenReturn(pessoaDTO);

        // Execute
        List<PessoaDTO> result = pessoaController.findAll();

        // Verify
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(pessoaDTO, result.get(0));
        verify(pessoaService).findAll();
        verify(pessoaMapper).toDTO(pessoa);
    }

    @Test
    void create_CallsServiceWithCorrectPessoa() {
        Pessoa newPessoa = new Pessoa();
        newPessoa.setNome("João");
        pessoaController.create(newPessoa);

        ArgumentCaptor<Pessoa> pessoaCaptor = ArgumentCaptor.forClass(Pessoa.class);
        verify(pessoaService).create(pessoaCaptor.capture());
        assertEquals("João", pessoaCaptor.getValue().getNome());
    }

    @Test
    void update_CallsServiceWithCorrectArguments() {
        Pessoa updatedPessoa = new Pessoa();
        updatedPessoa.setNome("João Atualizado");
        Long id = 1L;

        pessoaController.update(updatedPessoa, id);

        ArgumentCaptor<Pessoa> pessoaCaptor = ArgumentCaptor.forClass(Pessoa.class);
        ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);

        verify(pessoaService).update(pessoaCaptor.capture(), idCaptor.capture());
        assertEquals("João Atualizado", pessoaCaptor.getValue().getNome());
        assertEquals(id, idCaptor.getValue());
    }

    @Test
    void delete_CallsServiceWithCorrectId() {
        Long id = 1L;

        pessoaController.delete(id);

        ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
        verify(pessoaService).delete(idCaptor.capture());
        assertEquals(id, idCaptor.getValue());
    }
}


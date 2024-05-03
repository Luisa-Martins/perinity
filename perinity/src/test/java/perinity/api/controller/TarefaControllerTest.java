package perinity.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import perinity.api.model.Tarefa;
import perinity.api.service.TarefaService;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TarefaControllerTest {

    @Mock
    private TarefaService tarefaService;

    @InjectMocks
    private TarefaController tarefaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_ShouldCallCreateServiceMethod() {
        Tarefa tarefa = new Tarefa();
        tarefaController.create(tarefa);
        verify(tarefaService).create(tarefa);
    }

    @Test
    void finishTask_ShouldCallFinishTaskServiceMethod() {
        Long taskId = 1L;
        tarefaController.finishTask(taskId);
        verify(tarefaService).finishTask(taskId);
    }

    @Test
    void allocate_ShouldCallAllocateServiceMethod() {
        Long taskId = 2L;
        tarefaController.allocate(taskId);
        verify(tarefaService).allocateTask(taskId);
    }

    @Test
    void findOldest_ShouldCallFindOldestWithNoPersonServiceMethod() {
        List<Tarefa> expectedTasks = Arrays.asList(new Tarefa(), new Tarefa());
        when(tarefaService.findOldestWithNoPerson()).thenReturn(expectedTasks);

        List<Tarefa> result = tarefaController.findOldest();

        verify(tarefaService).findOldestWithNoPerson();
        assertSame(expectedTasks, result);
    }
}

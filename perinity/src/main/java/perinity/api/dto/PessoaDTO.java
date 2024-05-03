package perinity.api.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private Long id;
    private String nome;
    private String departamento;
    private Long totalHorasTarefas;
}

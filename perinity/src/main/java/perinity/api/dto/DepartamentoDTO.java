package perinity.api.dto;

import lombok.Data;

@Data
public class DepartamentoDTO {
    private Long id;
    private String nome;
    private Long quantidadeDePessoas;
    private Long quantidadeDeTarefas;
}

package perinity.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "tarefas")
@Entity(name = "Tarefa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    private Long duracao;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoaAlocada;

    private boolean finalizado;
}
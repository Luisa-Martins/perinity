package perinity.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "departamentos")
@Entity(name = "Departamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Pessoa> listaDePessoas;

    @OneToMany(mappedBy = "departamento")
    private List<Tarefa> listaDeTarefas;
}

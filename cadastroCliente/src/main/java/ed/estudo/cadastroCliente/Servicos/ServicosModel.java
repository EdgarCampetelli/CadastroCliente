package ed.estudo.cadastroCliente.Servicos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ed.estudo.cadastroCliente.Clientes.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_servicos")
@NoArgsConstructor
@AllArgsConstructor
@Data // Getter an Setters
public class ServicosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dificuldade;

    @OneToMany(mappedBy = "servicos") // Um servico para MUITOS clientes
    @JsonIgnore
    private List<ClienteModel> clientes ;


}

package ed.estudo.cadastroCliente.Clientes;

import ed.estudo.cadastroCliente.Servicos.ServicosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//Transforma uma class em entidade no banco de dados
@Entity
@Table(name = "tb_cadastro_de_clientes")
@NoArgsConstructor
@AllArgsConstructor
@Data // Getter an Setters
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private int idade;

    @ManyToOne // MUITOS clientes para um servico
    @JoinColumn(name = "servicos_id") // Foreing Key
    private ServicosModel servicos;


}

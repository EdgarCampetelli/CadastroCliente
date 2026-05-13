package ed.estudo.cadastroCliente.Servicos;

import ed.estudo.cadastroCliente.Clientes.ClienteModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_servicos")
public class ServicosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "servicos") // Um servico para MUITOS clientes
    private List<ClienteModel> clientes ;

    public ServicosModel() {
    }

    public ServicosModel(Long id, String nome, String dificuldade) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}

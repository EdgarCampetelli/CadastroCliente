package ed.estudo.cadastroCliente.Servicos;

import ed.estudo.cadastroCliente.Clientes.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicosDTO {
    private Long id;
    private String nome;
    private String dificuldade;
    private List<ClienteModel> clientes ;
}

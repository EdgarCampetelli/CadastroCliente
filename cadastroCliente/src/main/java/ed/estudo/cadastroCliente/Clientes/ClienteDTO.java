package ed.estudo.cadastroCliente.Clientes;

import ed.estudo.cadastroCliente.Servicos.ServicosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private Integer phone;
    private ServicosModel servicos;
}

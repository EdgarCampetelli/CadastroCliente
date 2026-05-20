package ed.estudo.cadastroCliente.Clientes;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteModel map(ClienteDTO clienteDTO) {

        ClienteModel clienteModel = new ClienteModel();

        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setEmail(clienteDTO.getEmail());
        clienteModel.setPhone(clienteDTO.getPhone());
        clienteModel.setIdade(clienteDTO.getIdade());
        clienteModel.setServicos(clienteDTO.getServicos());
        return clienteModel;
    }

    public ClienteDTO map(ClienteModel clienteModel) {

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setEmail(clienteModel.getEmail());
        clienteDTO.setPhone(clienteModel.getPhone());
        clienteDTO.setIdade(clienteModel.getIdade());
        clienteDTO.setServicos(clienteModel.getServicos());
        return clienteDTO;
    }

}

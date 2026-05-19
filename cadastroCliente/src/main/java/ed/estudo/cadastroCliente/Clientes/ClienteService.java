package ed.estudo.cadastroCliente.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    //injetando Repository
    private ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Listar Clientes
    public List<ClienteModel> readAllCliente(){
        return clienteRepository.findAll();
    }

    //Listar por ID

}

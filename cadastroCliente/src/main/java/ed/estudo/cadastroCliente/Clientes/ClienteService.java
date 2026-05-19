package ed.estudo.cadastroCliente.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ClienteModel readClienteID(Long id){
        //cliente pode existir ou nao, por isso o Optional
        Optional<ClienteModel> clienteModel = clienteRepository.findById(id);
        return clienteModel.orElse(null);
    }
}

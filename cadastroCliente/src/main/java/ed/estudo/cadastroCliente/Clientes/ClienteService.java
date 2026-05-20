package ed.estudo.cadastroCliente.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    //injetando Repository
    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = mapper;
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

    //Criar Ninja
    public ClienteDTO criateCliente(ClienteDTO clienteDTO){
        ClienteModel clienteModel = clienteMapper.map(clienteDTO);
        clienteModel = clienteRepository.save(clienteModel);
        return clienteMapper.map(clienteModel);
    }

    //Delete
    public void deleteClienteID(Long id){
        clienteRepository.deleteById(id);
    }

    //UPDATE
    public ClienteModel updateClienteId(Long id, ClienteModel clienteModel){
        if (clienteRepository.existsById(id)){
             clienteModel.setId(id);
            return clienteRepository.save(clienteModel);
        }
        return null;
    }
}

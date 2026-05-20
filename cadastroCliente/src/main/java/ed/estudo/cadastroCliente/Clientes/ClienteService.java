package ed.estudo.cadastroCliente.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    //injetando Repository
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = mapper;
    }

    //Listar Clientes
    public List<ClienteDTO> readAllCliente(){
        List<ClienteModel> clienteModel = clienteRepository.findAll();
        return clienteModel.stream()
                .map(clienteMapper::map)
                .collect(Collectors.toList());
    }

    //Listar por ID
    public ClienteDTO readClienteID(Long id){
        //cliente pode existir ou nao, por isso o Optional
        Optional<ClienteModel> clienteModel = clienteRepository.findById(id);
        return clienteModel.map(clienteMapper::map).orElse(null);
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
    public ClienteDTO updateClienteId(Long id, ClienteDTO clienteDTO){
        Optional<ClienteModel> clienteModel = clienteRepository.findById(id);
        if (clienteModel.isPresent()){
            ClienteModel clienteSave = clienteMapper.map(clienteDTO);
            clienteSave.setId(id);
            clienteRepository.save(clienteSave);
            return clienteMapper.map(clienteSave);
        }
        return null;
    }
}

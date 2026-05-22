package ed.estudo.cadastroCliente.Servicos;

import ed.estudo.cadastroCliente.Clientes.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicosService {

    private final ServicosRepository servicosRepository;
    private final ClienteRepository clienteRepository;
    private final ServicosMapper servicosMapper;

    public ServicosService(ServicosRepository servicosRepository, ClienteRepository clienteRepository, ServicosMapper servicosMapper) {
        this.servicosRepository = servicosRepository;
        this.clienteRepository = clienteRepository;
        this.servicosMapper = servicosMapper;
    }

    public List<ServicosDTO> readAllServico(){
        List<ServicosModel> servicosModel = servicosRepository.findAll();
        return servicosModel.stream().map(servicosMapper::map).collect(Collectors.toList());
    }

    public ServicosDTO readServicoID(Long id){
        Optional<ServicosModel> servicosModel = servicosRepository.findById(id);
        return servicosModel.map(servicosMapper::map).orElse(null);

    }

    public ServicosDTO updateServicoID(Long id, ServicosDTO servicosDTO){
        Optional<ServicosModel> servicosModelSearch = servicosRepository.findById(id);
        if (servicosModelSearch.isPresent()){
            ServicosModel servicosModel = servicosMapper.map(servicosDTO);
            servicosModel.setId(id);
            servicosRepository.save(servicosModel);
            return servicosMapper.map(servicosModel);
        }
        return null;
    }

    public ServicosDTO creatServico(ServicosDTO servicosDTO){
        ServicosModel servicosModel = servicosMapper.map(servicosDTO);
        servicosRepository.save(servicosModel);
        return servicosMapper.map(servicosModel);
    }

    public void deleteServicoID(Long id){
        Optional<ServicosModel> servicosModels = servicosRepository.findById(id);
        if (servicosModels.isPresent()){
            for (ClienteModel cliente: servicosModels.get().getClientes()){
                cliente.setServicos(null);
                clienteRepository.save(cliente);
            }
            servicosRepository.deleteById(id);
        }
    }
}

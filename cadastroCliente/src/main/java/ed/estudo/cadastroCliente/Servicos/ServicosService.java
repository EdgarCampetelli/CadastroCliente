package ed.estudo.cadastroCliente.Servicos;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicosService {

    private ServicosRepository servicosRepository;
    private ServicosMapper servicosMapper;

    public ServicosService(ServicosRepository servicosRepository, ServicosMapper servicosMapper) {
        this.servicosRepository = servicosRepository;
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
        servicosRepository.deleteById(id);
    }
}

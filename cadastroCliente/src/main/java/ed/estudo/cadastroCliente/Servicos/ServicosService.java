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

    public ServicosModel readServicoID(Long id){
        Optional<ServicosModel> servicosModel = servicosRepository.findById(id);
        return servicosModel.orElse(null);
    }

    public ServicosModel creatServico(ServicosModel servicosModel){
        return servicosRepository.save(servicosModel);
    }

    public void deleteServicoID(Long id){
        servicosRepository.deleteById(id);
    }
}

package ed.estudo.cadastroCliente.Servicos;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosService {

    private ServicosRepository servicosRepository;
    public ServicosService(ServicosRepository servicosRepository) {
        this.servicosRepository = servicosRepository;
    }

    public List<ServicosModel> readAllServico(){
        return servicosRepository.findAll();
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

package ed.estudo.cadastroCliente.Servicos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosService {

    private ServicosRepository servicosRepository;
    public ServicosService(ServicosRepository servicosRepository) {
        this.servicosRepository = servicosRepository;
    }

    public List<ServicosModel> readAllServico(){
        return servicosRepository.findAll();
    }
}

package ed.estudo.cadastroCliente.Servicos;

import org.springframework.stereotype.Component;

@Component
public class ServicosMapper {

    ServicosModel map(ServicosDTO servicosDTO){
        ServicosModel servicosModel = new ServicosModel();

        servicosModel.setId(servicosDTO.getId());
        servicosModel.setNome(servicosDTO.getNome());
        servicosModel.setClientes(servicosDTO.getClientes());
        servicosModel.setDificuldade(servicosDTO.getDificuldade());

        return servicosModel;
    }

    ServicosDTO map(ServicosModel servicosModel){
        ServicosDTO servicosDTO = new ServicosDTO();

        servicosDTO.setId(servicosModel.getId());
        servicosDTO.setNome(servicosDTO.getNome());
        servicosDTO.setClientes(servicosDTO.getClientes());
        servicosDTO.setDificuldade(servicosModel.getDificuldade());

        return servicosDTO;
    }

}

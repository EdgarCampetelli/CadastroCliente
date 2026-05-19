package ed.estudo.cadastroCliente.Servicos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    private ServicosService servicosService;
    public ServicosController(ServicosService servicosService) {
        this.servicosService = servicosService;
    }

    @GetMapping("/default")
    public String linkDefault(){ return "Page Default"; }

    @PostMapping("/create")
    public ServicosModel creatServico(@RequestBody ServicosModel servicosModel){
        return servicosService.creatServico(servicosModel);
    }

    //READ Servico
    @GetMapping("/readAll")
    public List<ServicosModel> readAllServico(){return servicosService.readAllServico();}

    //UPDATE Servico
    @PutMapping("/updateID")
    public String updateServicoID(){return "Altera Servico por ID";}

    //DELETE Servico
    @DeleteMapping("/delete/{id}")
    public void deleteServicoID(@PathVariable Long id){ servicosService.deleteServicoID(id);}

    //SEARCH Servico
    @GetMapping("/read/{id}")
    public ServicosModel readServicoID(@PathVariable Long id){return servicosService.readServicoID(id);}
}

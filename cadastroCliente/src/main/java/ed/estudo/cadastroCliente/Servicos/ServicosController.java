package ed.estudo.cadastroCliente.Servicos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    private final ServicosService servicosService;
    public ServicosController(ServicosService servicosService) {
        this.servicosService = servicosService;
    }

    @GetMapping("/default")
    public String linkDefault(){ return "Page Default"; }

    @PostMapping("/create")
    public ServicosDTO creatServico(@RequestBody ServicosDTO servicosDTO){
        return servicosService.creatServico(servicosDTO);
    }

    //READ Servico
    @GetMapping("/readAll")
    public List<ServicosDTO> readAllServico(){return servicosService.readAllServico();}

    //UPDATE Servico
    @PutMapping("/update/{id}")
    public ServicosDTO updateServicoID(@PathVariable Long id, @RequestBody ServicosDTO servicosDTO){return servicosService.updateServicoID(id, servicosDTO);}

    //DELETE Servico
    @DeleteMapping("/delete/{id}")
    public void deleteServicoID(@PathVariable Long id){ servicosService.deleteServicoID(id);}

    //SEARCH Servico
    @GetMapping("/read/{id}")
    public ServicosDTO readServicoID(@PathVariable Long id){return servicosService.readServicoID(id);}
}

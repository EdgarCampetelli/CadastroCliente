package ed.estudo.cadastroCliente.Servicos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("servicos")
public class ServicosController {

    @GetMapping("/default")
    public String linkDefault(){ return "Page Default"; }

    @PostMapping("/creat")
    public String creatServico(){return "Servico Criado";}

    //READ Servico
    @GetMapping("/readAll")
    public String readAllServico(){return "Mostrar TODOS os Servico";}

    //UPDATE Servico
    @PutMapping("/updateID")
    public String updateServicoID(){return "Altera Servico por ID";}

    //DELETE Servico
    @DeleteMapping("/deleteID")
    public String deleteServicoID(){return "Deleta Servico por ID";}

    //SEARCH Servico
    @GetMapping("/readID")
    public String readServicoID(){return "Mostrar Servico por ID";}
}

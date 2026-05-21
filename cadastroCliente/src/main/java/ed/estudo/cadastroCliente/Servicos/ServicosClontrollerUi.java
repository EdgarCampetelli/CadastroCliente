package ed.estudo.cadastroCliente.Servicos;

import ed.estudo.cadastroCliente.Clientes.ClienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/servicos/ui")
public class ServicosClontrollerUi {

    private final ServicosService servicosService;
    public ServicosClontrollerUi(ServicosService servicosService) {
        this.servicosService = servicosService;
    }

    @GetMapping("/readAll")
    public String readAllCliente(Model model){
        List<ServicosDTO> servicosDTOS = servicosService.readAllServico();
        model.addAttribute("servicos",servicosDTOS);
        model.addAttribute("titulo","Lista de Servicos");
        return "listaservicos"; // tem que retornar o nome da pag que renderiza
    }

    @GetMapping("/read/{id}")
    public String readClienteID(@PathVariable Long id, Model model){
        ServicosDTO servicosDTOS = servicosService.readServicoID(id);
        if (servicosDTOS != null){
            model.addAttribute("servicos",servicosDTOS);
            return "detalhesservicos";
        }
        model.addAttribute("mensagem","Cliente nao encontrado !!!");
        return "listaservicos";
    }

    @GetMapping("/delete/{id}")
    public String deleteClienteID(@PathVariable Long id){
        servicosService.deleteServicoID(id);
        return "redirect:/servicos/ui/readAll";
    }

    @GetMapping("/pg-create")
    public String criateCliente(Model model){
        model.addAttribute("servicoDTO", new ServicosDTO());
        return "cadastrarservicos";
    }
    @PostMapping("/create")
    public String criateCliente(@ModelAttribute("servicoDTO") ServicosDTO servicosDTO){
        servicosService.creatServico(servicosDTO);
        return "redirect:/servicos/ui/readAll";
    }

    @GetMapping("/update/{id}")
    public String updateClienteID(@PathVariable Long id, Model model){
        ServicosDTO servicosDTO = servicosService.readServicoID(id);
        if (servicosDTO != null){
            model.addAttribute("servicoDTO", servicosDTO);
            return "cadastrarservicos";
        }
        return "redirect:/clientes/ui/readAll";
    }
}

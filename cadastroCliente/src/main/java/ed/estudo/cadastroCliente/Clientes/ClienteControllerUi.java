package ed.estudo.cadastroCliente.Clientes;

import ed.estudo.cadastroCliente.Servicos.ServicosDTO;
import ed.estudo.cadastroCliente.Servicos.ServicosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes/ui")
public class ClienteControllerUi {

    private final ClienteService clienteService;
    private final ServicosService servicosService;

    public ClienteControllerUi(ClienteService clienteService, ServicosService servicosService) {
        this.clienteService = clienteService;
        this.servicosService = servicosService;
    }

    @GetMapping("/readAll")
    public String readAllCliente(Model model){
        List<ClienteDTO> clienteDTOS = clienteService.readAllCliente();
        model.addAttribute("clientes",clienteDTOS);
        return "ListaClientes"; // tem que retornar o nome da pag que renderiza
    }

    @GetMapping("/delete/{id}")
    public String deleteClienteID(@PathVariable Long id){
            clienteService.deleteClienteID(id);
        return "redirect:/clientes/ui/readAll";
    }

    @GetMapping("/read/{id}")
    public String readClienteID(@PathVariable Long id, Model model){
        ClienteDTO clienteDTO = clienteService.readClienteID(id);
        if (clienteDTO != null){
            model.addAttribute("cliente",clienteDTO);
            return "detalhescliente";
        }
        model.addAttribute("mensagem","Cliente nao encontrado !!!");
        return "ListaClientes";
    }

    @GetMapping("/update/{id}")
    public String updateClienteID(@PathVariable Long id, Model model){
        ClienteDTO clienteDTOID = clienteService.readClienteID(id);
        if (clienteDTOID != null){
            model.addAttribute("clienteDTO", clienteDTOID);
            List<ServicosDTO> servicosDTOS = servicosService.readAllServico();
            model.addAttribute("servicos",servicosDTOS);
            return "cadastrarcliente";
        }
        return "redirect:/clientes/ui/readAll";
    }

    @GetMapping("/pg-create")
    public String criateCliente(Model model){
        model.addAttribute("clienteDTO", new ClienteDTO());
        List<ServicosDTO> servicosDTOS = servicosService.readAllServico();
        model.addAttribute("servicos",servicosDTOS);
        return "cadastrarcliente";
    }
    @PostMapping("/create")
    public String criateCliente(@ModelAttribute("clienteDTO") ClienteDTO clienteDTO){
        clienteService.criateCliente(clienteDTO);
        return "redirect:/clientes/ui/readAll";
    }
}

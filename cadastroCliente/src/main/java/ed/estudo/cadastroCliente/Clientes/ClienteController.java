package ed.estudo.cadastroCliente.Clientes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //determina que a funcao e um controller
@RequestMapping("/cliente")
public class ClienteController {

    //injetando Service
    private ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Primeira mensagem";
    }

    //CREATE CLIENTE
    @PostMapping("/creat")
    public String criateCliente(){return "Cliente Criado";}

    //READ CLIENTE
    @GetMapping("/readAll")
    public List<ClienteModel> readAllCliente(){return clienteService.readAllCliente();}

    //UPDATE CLIENTE
    @PutMapping("/updateID")
    public String updateClienteID(){return "Altera Cliente por ID";}

    //DELETE CLIENTE
    @DeleteMapping("/deleteID")
    public String deleteClienteID(){return "Deleta Cliente por ID";}

    //SEARCH CLIENTE
    @GetMapping("/readID")
    public String readClienteID(){return "Mostrar Cliente por ID";}
}

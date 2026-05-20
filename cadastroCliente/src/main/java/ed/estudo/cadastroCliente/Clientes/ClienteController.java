package ed.estudo.cadastroCliente.Clientes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //determina que a funcao e um controller
@RequestMapping("/clientes")
public class ClienteController {

    //injetando Service
    private ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //CREATE CLIENTE
    //@RequestBody anotation que pasa o corpo(conteudo) para a funcao, serealiza o Json para persistir os dados no banco de dados
    @PostMapping("/create")
    public ClienteDTO criateCliente(@RequestBody ClienteDTO cliente){return clienteService.criateCliente(cliente);}

    //READ CLIENTE
    @GetMapping("/readAll")
    public List<ClienteDTO> readAllCliente(){return clienteService.readAllCliente();}

    //UPDATE CLIENTE
    @PutMapping("/update/{id}")
    public ClienteDTO updateClienteID(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO ){return clienteService.updateClienteId(id,clienteDTO);}

    //DELETE CLIENTE
    @DeleteMapping("/delete/{id}")
    public void deleteClienteID(@PathVariable Long id){ clienteService.deleteClienteID(id);}

    //SEARCH CLIENTE
    @GetMapping("/read/{id}")
    public ClienteDTO readClienteID(@PathVariable Long id){return clienteService.readClienteID(id);}
}

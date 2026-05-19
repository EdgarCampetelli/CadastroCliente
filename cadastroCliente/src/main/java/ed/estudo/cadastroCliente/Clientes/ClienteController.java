package ed.estudo.cadastroCliente.Clientes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClienteController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Primeira mensagem";
    }

    //CREATE CLIENTE
    @PostMapping("/createdCliente")
    public String criarCliente(){return "Cliente Criado";}

    //READ CLIENTE
    @GetMapping("/readAllCliente")
    public String readAllCliente(){return "Mostrar TODOS os Clientes";}

    //UPDATE CLIENTE
    @PutMapping("/updateCliente")
    public String updateClienteID(){return "Altera Cliente por ID";}

    //DELETE CLIENTE
    @DeleteMapping("/deleteCliente")
    public String deleteClienteID(){return "Deleta Cliente por ID";}

    //SEARCH CLIENTE
    @GetMapping("/readClienteID")
    public String readClienteID(){return "Mostrar Cliente por ID";}
}

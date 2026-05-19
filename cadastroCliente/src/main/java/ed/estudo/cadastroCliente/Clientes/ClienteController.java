package ed.estudo.cadastroCliente.Clientes;

import org.springframework.web.bind.annotation.*;

@RestController //determina que a funcao e um controller
@RequestMapping("cliente")
public class ClienteController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Primeira mensagem";
    }

    //CREATE CLIENTE
    @PostMapping("/creat")
    public String criarCliente(){return "Cliente Criado";}

    //READ CLIENTE
    @GetMapping("/readAll")
    public String readAllCliente(){return "Mostrar TODOS os Clientes";}

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

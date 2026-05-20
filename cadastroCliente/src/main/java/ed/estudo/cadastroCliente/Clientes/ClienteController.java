package ed.estudo.cadastroCliente.Clientes;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> criateCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.criateCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente "+clienteDTO.getNome()+" criado com sucesso !!!");
    }

    //READ CLIENTE
    @GetMapping("/readAll")
    public ResponseEntity<List<ClienteDTO>> readAllCliente(){
        List<ClienteDTO> clienteDTOS = clienteService.readAllCliente();
        return ResponseEntity.ok(clienteDTOS);
    }

    //UPDATE CLIENTE
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClienteID(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO ){
        ClienteDTO clienteDTOID = clienteService.readClienteID(id);
        if (clienteDTOID != null){
            ClienteDTO newCliente =clienteService.updateClienteId(id,clienteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID="+id+" nao identificado !");
    }

    //DELETE CLIENTE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClienteID(@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.readClienteID(id);
        if (clienteDTO != null){
            clienteService.deleteClienteID(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente "+clienteDTO.getNome()+" deletado com sucesso !!!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID nao identificado !");
    }

    //SEARCH CLIENTE
    @GetMapping("/read/{id}")
    public ResponseEntity<?> readClienteID(@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.readClienteID(id);
        if (clienteDTO != null){
            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente com id="+id+" nao encontrado !");
    }
}

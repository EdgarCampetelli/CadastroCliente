package ed.estudo.cadastroCliente.Clientes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //CREATE CLIENTE
    //@RequestBody anotation que pasa o corpo(conteudo) para a funcao, serealiza o Json para persistir os dados no banco de dados
    @PostMapping("/create")
    @Operation(summary = "Rotute for create a new cliente.")
    public ResponseEntity<String> criateCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.criateCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente "+clienteDTO.getNome()+" criado com sucesso !!!");
    }

    //READ CLIENTE
    @GetMapping("/readAll")
    @Operation(summary = "Rotute for read all clientes.",description = "Return Json mode cliente")
    public ResponseEntity<List<ClienteDTO>> readAllCliente(){
        List<ClienteDTO> clienteDTOS = clienteService.readAllCliente();
        return ResponseEntity.ok(clienteDTOS);
    }

    //UPDATE CLIENTE
    @PutMapping("/update/{id}")
    @Operation(summary = "Rotute for update a cliente.")
    public ResponseEntity<?> updateClienteID(
            @Parameter(description = "User Id in the request route")
            @PathVariable Long id,
            @Parameter(description = "User body in the request route")
            @RequestBody ClienteDTO clienteDTO
    ){
        ClienteDTO clienteDTOID = clienteService.readClienteID(id);
        if (clienteDTOID != null){
            ClienteDTO newCliente =clienteService.updateClienteId(id,clienteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID="+id+" nao identificado !");
    }

    //DELETE CLIENTE
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Rotute for delete a cliente.", description ="This route checks if the client exists; if it exists, it returns HTTP status \"created,\" otherwise status \"not found.\"")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer successfully registered!"),
            @ApiResponse(responseCode = "400", description = "Error in customer registration!")
    })
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
    @Operation(summary = "Rotute for read a cliente for id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer successfully found!"),
            @ApiResponse(responseCode = "400", description = "Customer found, not found!")
    })
    public ResponseEntity<?> readClienteID(@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.readClienteID(id);
        if (clienteDTO != null){
            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente com id="+id+" nao encontrado !");
    }
}

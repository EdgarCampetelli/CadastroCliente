package ed.estudo.cadastroCliente.Servicos;

import ed.estudo.cadastroCliente.Clientes.ClienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    private final ServicosService servicosService;
    public ServicosController(ServicosService servicosService) {
        this.servicosService = servicosService;
    }

    @Operation(summary = "Rotute for create a new servico.")
    @PostMapping("/create")
    public ResponseEntity<String> creatServico(@RequestBody ServicosDTO servicosDTO){
        servicosService.creatServico(servicosDTO);
        return ResponseEntity.ok("Success !");
    }

    //READ Servico
    @GetMapping("/readAll")
    @Operation(summary = "Rotute for read all servicos.",description = "Return Json mode servico.")
    public ResponseEntity<List<ServicosDTO>> readAllServico(){
        List<ServicosDTO> servicosDTOS = servicosService.readAllServico();
        return ResponseEntity.ok(servicosDTOS);
    }

    //UPDATE Servico
    @PutMapping("/update/{id}")
    @Operation(summary = "Rotute for update a servico.")
    public ResponseEntity<?> updateServicoID(@PathVariable Long id, @RequestBody ServicosDTO servicosDTO){
        ServicosDTO servicosDTOID = servicosService.readServicoID(id);
        if (servicosDTOID != null){
            servicosService.updateServicoID(id, servicosDTO);
            return ResponseEntity.ok(servicosDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error registering customer!");
    }

    //DELETE Servico
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Rotute for delete a servico.", description ="This route checks if the servico exists; if it exists, it returns HTTP status \"created,\" otherwise status \"not found.\"")
    public ResponseEntity<String> deleteServicoID(@PathVariable Long id){
        ServicosDTO servicosDTOID = servicosService.readServicoID(id);
        if (servicosDTOID != null){
            servicosService.deleteServicoID(id);
            return ResponseEntity.ok("Service successfully deleted!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting servico");
    }

    //SEARCH Servico
    @GetMapping("/read/{id}")
    @Operation(summary = "Rotute for read a cliente for id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "servico successfully found!"),
            @ApiResponse(responseCode = "400", description = "servico found, not found!")
    })
    public ResponseEntity<ServicosDTO> readServicoID(@PathVariable Long id){
        ServicosDTO servicosDTO = servicosService.readServicoID(id);
        return ResponseEntity.ok(servicosDTO);
    }
}

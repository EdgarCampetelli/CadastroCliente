package ed.estudo.cadastroCliente.Servicos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<ServicosDTO> readAllServico(){return servicosService.readAllServico();}

    //UPDATE Servico
    @PutMapping("/update/{id}")
    @Operation(summary = "Rotute for update a servico.")
    public ServicosDTO updateServicoID(@PathVariable Long id, @RequestBody ServicosDTO servicosDTO){return servicosService.updateServicoID(id, servicosDTO);}

    //DELETE Servico
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Rotute for delete a servico.", description ="This route checks if the servico exists; if it exists, it returns HTTP status \"created,\" otherwise status \"not found.\"")
    public void deleteServicoID(@PathVariable Long id){ servicosService.deleteServicoID(id);}

    //SEARCH Servico
    @GetMapping("/read/{id}")
    @Operation(summary = "Rotute for read a cliente for id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "servico successfully found!"),
            @ApiResponse(responseCode = "400", description = "servico found, not found!")
    })
    public ServicosDTO readServicoID(@PathVariable Long id){return servicosService.readServicoID(id);}
}

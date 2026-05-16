package ed.estudo.cadastroCliente.Servicos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ServicosController {

    @GetMapping("/default")
    public String linkDefault(){ return "Page Default"; }
}

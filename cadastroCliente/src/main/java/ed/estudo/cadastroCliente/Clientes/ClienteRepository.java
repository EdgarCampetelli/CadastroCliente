package ed.estudo.cadastroCliente.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}

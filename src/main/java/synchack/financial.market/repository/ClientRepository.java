package synchack.financial.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import synchack.financial.market.model.user.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
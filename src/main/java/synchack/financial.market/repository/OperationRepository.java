package synchack.financial.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import synchack.financial.market.model.operation.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}

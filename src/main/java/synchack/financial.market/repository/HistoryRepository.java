package synchack.financial.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import synchack.financial.market.model.history.History;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface HistoryRepository extends JpaRepository<History, Long> {

  @Query("SELECT b FROM Balance b WHERE b.clientId=?1")
  List<History> getAllHistory(Long clientId);

}

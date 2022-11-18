package synchack.financial.market.model.operation;

import java.time.OffsetDateTime;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import synchack.financial.market.model.BaseMonetaryEntity;

@Getter
@Setter
@Entity
@Table(name = "operation")
@RequiredArgsConstructor
public class Operation extends BaseMonetaryEntity {

  @NotNull
  @Column(name = "time", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
  private OffsetDateTime operationTime;

  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "operation_type", joinColumns = @JoinColumn(name = "operation_id"), uniqueConstraints = {
    @UniqueConstraint(columnNames = {"operation_id", "type"}, name = "operation_type_unique")})
  @Column(name = "role")
  @JoinColumn(name = "operation_id")
  private OperationType type;
}

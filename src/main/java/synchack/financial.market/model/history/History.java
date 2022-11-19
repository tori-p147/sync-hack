package synchack.financial.market.model.history;

import lombok.*;
import synchack.financial.market.model.BaseMonetaryEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "history")
@RequiredArgsConstructor
public class History extends BaseMonetaryEntity {

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "final_balance")
    private BigDecimal final_balance;
}

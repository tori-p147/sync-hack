package synchack.financial.market.mapper;

import org.mapstruct.Mapper;
import synchack.financial.market.dto.BalanceDto;
import synchack.financial.market.model.balance.Balance;

@Mapper(componentModel = "spring")
public interface BalanceToTotalBalanceMapper {

  Balance fromBalanceDto(BalanceDto dto);
}

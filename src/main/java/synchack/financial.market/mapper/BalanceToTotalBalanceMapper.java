package synchack.financial.market.mapper;

import org.mapstruct.Mapper;
import synchack.financial.market.dto.CreateBalanceDto;
import synchack.financial.market.model.balance.Balance;

@Mapper(componentModel = "spring")
public interface BalanceToTotalBalanceMapper {

  Balance fromBalanceDto(CreateBalanceDto dto);
}

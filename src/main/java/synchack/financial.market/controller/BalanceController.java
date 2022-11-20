package synchack.financial.market.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import synchack.financial.market.dto.CreateBalanceDto;
import synchack.financial.market.mapper.BalanceToTotalBalanceMapper;
import synchack.financial.market.model.balance.Balance;
import synchack.financial.market.service.BalanceService;

@RestController
@RequestMapping(value = BalanceController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BalanceController {
  static final String URL = "/hakaton/v1/account/balance";

  private final BalanceService balanceService;

  private final BalanceToTotalBalanceMapper mapper;

  @Operation(summary = "Get user`s balance by currency")
  @GetMapping("{clientId}/by-currency")
  public Balance getBalance(@PathVariable Long clientId, @RequestParam String currency) {
    return balanceService.getBalance(clientId, currency);
  }

  @Operation(summary = "Get all user`s balances")
  @GetMapping("/{clientId}")
  public List<Balance> getAllBalances(@PathVariable Long clientId) {
    return balanceService.getAllBalances(clientId);
  }

  @Operation(summary = "Create new balance")
  @Transactional
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Balance> createWithLocation(@Valid @RequestBody CreateBalanceDto dto) {
    Balance created = balanceService.create(mapper.fromBalanceDto(dto));
    URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
      .path(URL + "/{id}")
      .buildAndExpand(created.getId()).toUri();

    return ResponseEntity.created(uriOfNewResource).body(created);
  }

  @Operation(summary = "Update balance")
  @Transactional
  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@Valid @RequestBody Balance balance, @RequestParam Long clientId) {
    balanceService.update(balance, clientId);
  }
}

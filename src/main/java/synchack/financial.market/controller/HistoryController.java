package synchack.financial.market.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import synchack.financial.market.model.history.History;
import synchack.financial.market.repository.HistoryRepository;

import java.util.List;

@RestController
@RequestMapping(value = HistoryController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class HistoryController {

    @Autowired
    private final HistoryRepository historyRepository;
    static final String URL = "/hakaton/v1/history/quotation";

    @GetMapping("/{clientId}")
    public List<History> getAllHistory(@PathVariable Long clientId) {
        return historyRepository.getAllHistory(clientId);
    }

}

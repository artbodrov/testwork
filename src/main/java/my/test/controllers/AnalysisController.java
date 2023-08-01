package my.test.controllers;

import my.test.entity.Actual;
import my.test.services.AnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {


    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping("/")
    public List<Actual> getAllActual() {
        return analysisService.getAllActuals();
    }

    @GetMapping("/actuals")
    public List<Actual> getActual(@RequestParam List<String> chainNames,
                                  @RequestParam List<Integer> productsNumbers,
                                  @RequestParam Date date) {
        return analysisService.getActual(chainNames, productsNumbers, date);
    }
}

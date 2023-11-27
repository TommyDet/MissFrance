package fr.missfrance.controller;

import fr.missfrance.dao.Candidates;
import fr.missfrance.service.CandidateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class infosCandidatesController {

    private static final Logger LOGGER = LogManager.getLogger(infosCandidatesController.class);


    private final CandidateService candidateService;

    public infosCandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @GetMapping("/candidate/{region}")
    public List<Candidates> getCandidate(@PathVariable String region) {

        return candidateService.getCandidateByRegion(region);
    }

}


package fr.missfrance.controller;

import fr.missfrance.dao.Candidates;
import fr.missfrance.dao.Classement;
import fr.missfrance.service.CandidateService;
import fr.missfrance.service.ClassementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Controller
public class CandidatesController {

    private static final Logger LOGGER = LogManager.getLogger(CandidatesController.class);

    private final CandidateService candidateService;
    private final ClassementService classementService;

    private final MongoTemplate mongoTemplate;

    public CandidatesController(CandidateService candidateService, ClassementService classementService, MongoTemplate mongoTemplate) {
        this.candidateService = candidateService;
        this.classementService = classementService;
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/addCandidates")
    public String uploadPhoto() {
        return "addCandidates";
    }

    @GetMapping("/candidates")
    public String getCandidates(Model model) {

        List<Candidates> infosCandidates = candidateService.getCandidateByOfficielle();
        List<Classement> classements = classementService.getAllClassements();

        // Passage des URLs d'images comme attributs de modèle à la vue Thymeleaf
        model.addAttribute("infosCandidates", infosCandidates);
        model.addAttribute("classements", classements);

        LOGGER.debug("Récupération de la liste des candidates");
        return "candidates";
    }

    @PostMapping("/uploadCandidate")
    public String uploadCandidates(@RequestParam("region") String region,
                                   @RequestParam(value = "estOfficielle", required = false) Boolean estOfficielle,
                                   @RequestParam("file") MultipartFile file) throws IOException {
        LOGGER.debug("Entrée dans la méthode uploadPhoto - PhotoController");

        Candidates candidate = new Candidates();
        candidate.setRegion(region);
        candidate.setEstOfficielle(estOfficielle);
        candidate.setPhoto(Objects.requireNonNull(Base64.getEncoder().encodeToString(file.getInputStream().readAllBytes())));

        mongoTemplate.save(candidate, "Candidates");

        // Redirection vers la page d'accueil
        LOGGER.debug("Sortie dans la méthode uploadPhoto - PhotoController");
        return "redirect:/";
    }

}


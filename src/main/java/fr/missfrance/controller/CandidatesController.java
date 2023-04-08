package fr.missfrance.controller;

import fr.missfrance.service.PhotoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CandidatesController {

    private static final Logger LOGGER = LogManager.getLogger(CandidatesController.class);

    private final PhotoService photoService;

    public CandidatesController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/candidates")
    public String getCandidates(Model model) {

        String backgroundImage1 = photoService.getImageUrlByname("JPF.jpg");
        String backgroundImage2 = photoService.getImageUrlByname("ST.jpg");

        // Passage des URLs d'images comme attributs de modèle à la vue Thymeleaf
        model.addAttribute("backgroundImage1", backgroundImage1);
        model.addAttribute("backgroundImage2", backgroundImage2);

        LOGGER.debug("Récupération de la liste des candidates");
        return "candidates";
    }


}


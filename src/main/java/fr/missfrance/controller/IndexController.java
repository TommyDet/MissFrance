package fr.missfrance.controller;

import fr.missfrance.dao.UserInfos;
import fr.missfrance.repository.UserRepository;
import fr.missfrance.service.PhotoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private static final Logger LOGGER = LogManager.getLogger(IndexController.class);
    private final UserRepository userRepository;
    private final PhotoService photoService;

    public IndexController(UserRepository userRepository, PhotoService photoService) {
        this.userRepository = userRepository;
        this.photoService = photoService;
    }

    @GetMapping(value = {"/"})
    public String index(Model model) {

        // Récupération des images à partir de la base de données MongoDB
        String backgroundImage1 = photoService.getImageUrlByname("JPF.jpg");
        String backgroundImage2 = photoService.getImageUrlByname("ST.jpg");

        // Passage des URLs d'images comme attributs de modèle à la vue Thymeleaf
        model.addAttribute("backgroundImage1", backgroundImage1);
        model.addAttribute("backgroundImage2", backgroundImage2);

        LOGGER.debug("Affichage de l'index");
        return "index";
    }

    @GetMapping(value = {"/add"})
    public String add() {
        LOGGER.debug("Entrée dans la méthode add - indexController");
        UserInfos userInfos = new UserInfos();
        userInfos.setUsername("Tommy");
        userInfos.setTop1(1);
        userInfos.setTop5(List.of(2, 3, 4, 5));
        userInfos.setTop12(List.of(6, 7, 8, 9, 10, 11, 12));
        userRepository.save(userInfos);
        LOGGER.debug("Sortie de la méthode add - indexController");
        return "index";
    }
}

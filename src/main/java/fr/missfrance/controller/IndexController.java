package fr.missfrance.controller;

import fr.missfrance.dao.UserInfos;
import fr.missfrance.repository.UserRepository;
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

    public IndexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = {"/"})
    public String index(Model model) {
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

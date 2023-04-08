package fr.missfrance.controller;

import fr.missfrance.dao.Photo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Controller
public class PhotoController {

    private static final Logger LOGGER = LogManager.getLogger(PhotoController.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/photo")
    public String uploadPhoto() {
        return "photo";
    }

    @PostMapping("/uploadPhoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException {
        LOGGER.debug("Entrée dans la méthode uploadPhoto - PhotoController");

        Photo photo = new Photo();
        photo.setName(file.getOriginalFilename());
        photo.setData(Objects.requireNonNull(Base64.getEncoder().encodeToString(file.getInputStream().readAllBytes())));

        mongoTemplate.save(photo, "Photo");

        // Redirection vers la page d'accueil
        LOGGER.debug("Sortie dans la méthode uploadPhoto - PhotoController");
        return "redirect:/";
    }
}


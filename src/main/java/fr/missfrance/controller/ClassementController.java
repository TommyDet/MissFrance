package fr.missfrance.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.missfrance.dao.Classement;
import fr.missfrance.service.ClassementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ClassementController {

    private static final Logger LOGGER = LogManager.getLogger(ClassementController.class);

    private final ClassementService classementService;
    private final ObjectMapper objectMapper;

    public ClassementController(ClassementService classementService, ObjectMapper objectMapper) {
        this.classementService = classementService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/classement")
    public void uploadClassement(@RequestBody String jsonString) {
        LOGGER.info("Ajout du classement : {}", jsonString);
        if (LocalDateTime.now().isAfter(LocalDateTime.of(2023, 12, 16, 23, 00))) {
            Classement classement = null;
            try {
                classement = objectMapper.readValue(jsonString, Classement.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            classementService.saveClassement(classement);
        } else {
            LOGGER.error("Trop tard");
        }
    }

    @GetMapping("/classement/{prenom}")
    public Classement downloadClassement(@PathVariable String prenom) {
        LOGGER.info("Récupération du classement de {}", prenom);
        return classementService.getClassements(prenom);
    }

    @GetMapping("/classements")
    public List<Classement> downloadAllClassement() {
        LOGGER.info("Récupération de tous les classements");
        return classementService.getAllClassements();
    }

}


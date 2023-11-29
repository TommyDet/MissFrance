package fr.missfrance.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.missfrance.dao.Classement;
import fr.missfrance.service.ClassementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        Classement classement = null;
        try {
            classement = objectMapper.readValue(jsonString, Classement.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        classementService.saveClassement(classement);
    }

    @GetMapping("/classements")
    public List<Classement> getClassements() {
        LOGGER.info("chargement du classement");
        return classementService.getClassements();
    }

}


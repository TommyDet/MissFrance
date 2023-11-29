package fr.missfrance.service;

import fr.missfrance.dao.Classement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassementService {

    private static final Logger LOGGER = LogManager.getLogger(ClassementService.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveClassement(Classement classement) {
        LOGGER.info("Sauvegarde du classement : {}", classement);
        mongoTemplate.save(classement, "Classement");
    }

    public List<Classement> getClassements() {
        LOGGER.info("récupéraitond des classements");
        Query query = new Query();

        return mongoTemplate.find(query, Classement.class, "Classement");
    }

}

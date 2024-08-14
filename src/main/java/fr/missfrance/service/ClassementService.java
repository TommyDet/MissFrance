package fr.missfrance.service;

import fr.missfrance.dao.Classement;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
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

    public Classement getClassements(String prenom) {
        LOGGER.info("récupération des classements");

        Query query = new Query();
        query.addCriteria(Criteria.where("prenom").is(prenom));
        Classement classement = mongoTemplate.findOne(query, Classement.class, "Classement");

        assert !ObjectUtils.isEmpty(classement);

        return classement;
    }

    public List<Classement> getAllClassements() {
        LOGGER.info("récupéraiton des classements");

        List<Classement> classements = mongoTemplate.findAll(Classement.class, "Classement");

        assert !ObjectUtils.isEmpty(classements);

        return classements;
    }
}

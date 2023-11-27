package fr.missfrance.service;

import fr.missfrance.dao.Candidates;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidateService {

    private static final Logger LOGGER = LogManager.getLogger(CandidateService.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Candidates> getCandidateByRegion(String region) {
        LOGGER.info("Recupération d'une candidate pour la région : {}", region);

        Query query = new Query();
        query.addCriteria(Criteria.where("region").is(region));

        // Récupération de l'URL de l'image à partir de son champ "name" dans la collection "images"

        return mongoTemplate.find(query, Candidates.class, "Candidates");
    }

    public List<Candidates> getCandidateByOfficielle() {
        LOGGER.info("Recupération des candidates par photoOfficielle");

        Query query = new Query();
        query.addCriteria(Criteria.where("estOfficielle").is(true));
        List<Candidates> candidates = mongoTemplate.find(query, Candidates.class, "Candidates");

        assert !candidates.isEmpty();
        return candidates.stream().sorted((o1, o2) -> o1.getRegion().compareTo(o2.getRegion())).toList();

    }
}

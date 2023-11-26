package fr.missfrance.service;

import fr.missfrance.dao.Candidates;
import fr.missfrance.dao.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    UserService candidateService;
    @Autowired
    private MongoTemplate mongoTemplate;

    public User createUser(User user) {

        User userCreated = mongoTemplate.save(user, "Users");

        return userCreated;
    }

    public List<Candidates> checkUser() {
        LOGGER.info("Recupération des candidates par photoOfficielle");

        Query query = new Query();
        query.addCriteria(Criteria.where("estOfficielle").is(true));
        List<Candidates> candidates = mongoTemplate.find(query, Candidates.class, "Candidates");

        assert !candidates.isEmpty();
        return candidates.stream().sorted((o1, o2) -> o1.getRegion().compareTo(o2.getRegion())).toList();

    }
}

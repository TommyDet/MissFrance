package fr.missfrance.repository;

import fr.missfrance.dao.Candidates;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidatesRepository extends MongoRepository<Candidates, String> {
}

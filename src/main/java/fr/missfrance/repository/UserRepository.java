package fr.missfrance.repository;

import fr.missfrance.dao.UserInfos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserInfos, String> {
}

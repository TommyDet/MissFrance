package fr.missfrance.repository;

import fr.missfrance.dao.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {

    public Photo findByName(String name);
}

package fr.missfrance.service;

import fr.missfrance.dao.Photo;
import fr.missfrance.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service
public class PhotoService {

    PhotoRepository photoRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public String getImageUrlByname(String name) {

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        // Récupération de l'URL de l'image à partir de son champ "name" dans la collection "images"
        Photo photo = mongoTemplate.findOne(query, Photo.class, "Photo");

        assert photo != null;
        return photo.getData();
    }
}

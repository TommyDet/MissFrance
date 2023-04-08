package fr.missfrance.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Photo")
public class Photo {

    @Id
    private String name;
    private String data;

}

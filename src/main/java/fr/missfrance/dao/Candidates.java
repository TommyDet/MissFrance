package fr.missfrance.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Candidates")
public class Candidates {

    @Id
    private String id;
    private String region;
    private String photo;
    private Boolean estOfficielle;
}

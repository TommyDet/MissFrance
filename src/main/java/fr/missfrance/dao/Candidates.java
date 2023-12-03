package fr.missfrance.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Candidates")
public class Candidates {

    @Id
    private String id;
    private String region;
    private String photo;
    private Boolean estOfficielle;
    
    private String profession;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getEstOfficielle() {
        return estOfficielle;
    }

    public void setEstOfficielle(Boolean estOfficielle) {
        this.estOfficielle = estOfficielle;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

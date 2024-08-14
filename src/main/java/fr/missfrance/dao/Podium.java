package fr.missfrance.dao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Classement")
public class Podium {

    @Id
    private ObjectId objectId;
    private String top1;
    private String top2;
    private String top3;
    private String top4;
    private String top5;


    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getTop1() {
        return top1;
    }

    public void setTop1(String top1) {
        this.top1 = top1;
    }

    public String getTop2() {
        return top2;
    }

    public void setTop2(String top2) {
        this.top2 = top2;
    }

    public String getTop3() {
        return top3;
    }

    public void setTop3(String top3) {
        this.top3 = top3;
    }

    public String getTop4() {
        return top4;
    }

    public void setTop4(String top4) {
        this.top4 = top4;
    }

    public String getTop5() {
        return top5;
    }

    public void setTop5(String top5) {
        this.top5 = top5;
    }
}

package fr.missfrance.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Classement")
public class Classement {

    @Id
    private String prenom;
    private String top1;
    private String top2;
    private String top3;
    private String top4;
    private String top5;
    private String top6;
    private String top7;
    private String top8;
    private String top9;
    private String top10;
    private String top11;
    private String top12;
    private String top13;
    private String top14;
    private String top15;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getTop6() {
        return top6;
    }

    public void setTop6(String top6) {
        this.top6 = top6;
    }

    public String getTop7() {
        return top7;
    }

    public void setTop7(String top7) {
        this.top7 = top7;
    }

    public String getTop8() {
        return top8;
    }

    public void setTop8(String top8) {
        this.top8 = top8;
    }

    public String getTop9() {
        return top9;
    }

    public void setTop9(String top9) {
        this.top9 = top9;
    }

    public String getTop10() {
        return top10;
    }

    public void setTop10(String top10) {
        this.top10 = top10;
    }

    public String getTop11() {
        return top11;
    }

    public void setTop11(String top11) {
        this.top11 = top11;
    }

    public String getTop12() {
        return top12;
    }

    public void setTop12(String top12) {
        this.top12 = top12;
    }

    public String getTop13() {
        return top13;
    }

    public void setTop13(String top13) {
        this.top13 = top13;
    }

    public String getTop14() {
        return top14;
    }

    public void setTop14(String top14) {
        this.top14 = top14;
    }

    public String getTop15() {
        return top15;
    }

    public void setTop15(String top15) {
        this.top15 = top15;
    }

    @Override
    public String toString() {
        return "Classement{" +
                "prenom='" + prenom + '\'' +
                ", top1='" + top1 + '\'' +
                ", top2='" + top2 + '\'' +
                ", top3='" + top3 + '\'' +
                ", top4='" + top4 + '\'' +
                ", top5='" + top5 + '\'' +
                ", top6='" + top6 + '\'' +
                ", top7='" + top7 + '\'' +
                ", top8='" + top8 + '\'' +
                ", top9='" + top9 + '\'' +
                ", top10='" + top10 + '\'' +
                ", top11='" + top11 + '\'' +
                ", top12='" + top12 + '\'' +
                ", top13='" + top13 + '\'' +
                ", top14='" + top14 + '\'' +
                ", top15='" + top15 + '\'' +
                '}';
    }
}

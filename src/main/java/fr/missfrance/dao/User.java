package fr.missfrance.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Users")
public class User {

    @Id
    private String username;
    private int top1;
    private List<Integer> top5;
    private List<Integer> top12;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTop1() {
        return top1;
    }

    public void setTop1(int top1) {
        this.top1 = top1;
    }

    public List<Integer> getTop5() {
        return top5;
    }

    public void setTop5(List<Integer> top5) {
        this.top5 = top5;
    }

    public List<Integer> getTop12() {
        return top12;
    }

    public void setTop12(List<Integer> top12) {
        this.top12 = top12;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", top1=" + top1 +
                ", top5=" + top5 +
                ", top12=" + top12 +
                '}';
    }
}

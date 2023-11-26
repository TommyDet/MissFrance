package fr.missfrance.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "Users")
public class User {

    @Id
    private String username;
    private int top1;
    private List<Integer> top5;
    private List<Integer> top12;

}

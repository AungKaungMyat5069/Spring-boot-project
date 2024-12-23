package org.example.quest;

import org.example.annotation.QuestAnnotation;
import org.springframework.stereotype.Component;

import static org.example.annotation.QuestAnnotation.QuestType.DRAGON;


//@Component("dragon")
@Component @QuestAnnotation(DRAGON)
public class Dragon implements Quest{
    @Override
    public String doQuest() {
        return "Defeat the Dragon";
    }
}

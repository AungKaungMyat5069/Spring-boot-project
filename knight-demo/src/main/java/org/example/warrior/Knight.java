package org.example.warrior;

import org.example.annotation.QuestAnnotation;
import org.example.quest.Princess;
import org.example.quest.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import static org.example.annotation.QuestAnnotation.*;

@Component
public class Knight {

//    @Primary
//    @Autowired // with primary in the princess
//    Quest quest;

//  @Qualifier
//    @Autowired @Qualifier("dragon")
//    private Quest quest;

//  @Qualifier customer
    @Autowired @QuestAnnotation(QuestType.PRINCESS)
    private Quest quest;

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public String doQuest() {
        return quest.doQuest();
    }
}

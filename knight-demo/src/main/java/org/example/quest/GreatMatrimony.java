package org.example.quest;

import org.example.annotation.QuestAnnotation;
import org.springframework.stereotype.Component;

import static org.example.annotation.QuestAnnotation.QuestType.GREATMATRIMONY;

//@Component("matrimony")
@Component @QuestAnnotation(GREATMATRIMONY)
public class GreatMatrimony implements Quest{
    @Override
    public String doQuest() {
        return "Knight and Princess's Great Matrimony";
    }
}

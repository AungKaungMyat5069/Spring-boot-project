package org.example.quest;

import org.example.annotation.QuestAnnotation;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static org.example.annotation.QuestAnnotation.QuestType.PRINCESS;

//@Component("princess")
//@Primary
@Component @QuestAnnotation(PRINCESS)
public class Princess implements Quest{

    @Override
    public String doQuest() {
        return "Save the Princess";
    }
}

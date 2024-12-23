package org.example.quest;

import org.example.annotation.QuestAnnotation;
import org.springframework.stereotype.Component;

import static org.example.annotation.QuestAnnotation.QuestType.HOME;

//@Component("home")
@Component @QuestAnnotation(HOME)
public class Home implements Quest{
    @Override
    public String doQuest() {
        return "return home and live happy together";
    }
}

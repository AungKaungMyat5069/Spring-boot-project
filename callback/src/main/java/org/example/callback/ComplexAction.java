package org.example.callback;

public class ComplexAction  {

    public void action (ResultRender render, ResultCalculator calculator, int num) {
        render.render(calculator, num);
    }
}

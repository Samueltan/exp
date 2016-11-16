package exp.dp.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<Observer> observers = new ArrayList<Observer>();
    private final String topicName;
    private String content;

    public Subject(final String topicName){
        this(topicName, topicName);
    }

    public Subject(final String topicName, final String content){
        this.topicName = topicName;
        this.content = content;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
        notifyAllObservers();
    }

    protected void attach(final Observer observer){
        observers.add(observer);
        System.out.printf(
            "Observer <%s> has subscribed Topic <%s>\n",
            observer.getName( ),
            topicName);
    }

    protected void detach(final Observer observer){
        observers.remove(observer);
        System.out.printf(
            "Observer <%s> has unsubscribed Topic <%s>\n",
            observer.getName( ),
            topicName);
    }

    public void notifyAllObservers(){
        for (final Observer observer : observers) {
            observer.update();
        }
    }
}
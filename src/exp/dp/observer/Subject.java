package exp.dp.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<Observer> observers = new ArrayList<Observer>();
    private final String topicName;
    private String content;

    public Subject(final String topicName){
        this.topicName = topicName;
        this.content = topicName;
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
        System.out.println( "Observer <" + observer.getName( ) + "> has ");
    }

    protected void detach(final Observer observer){
        observers.remove(observer);
    }

    public void notifyAllObservers(){
        for (final Observer observer : observers) {
            observer.update();
        }
    }
}
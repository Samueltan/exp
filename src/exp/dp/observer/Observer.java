package exp.dp.observer;

public class Observer
{
    protected String name;
    protected Subject subject;

    public Observer(final String name, final Subject subject){
        this.name = name;
        this.subject = subject;
        this.subject.attach(this);
     }

    public void update(){
        System.out.println( "Subject <"+ subject.getTopicName() + "> has changed content to <" + subject.getContent( ) + ">" );
    }

    public String getName(){
        return name;
    }

    public void setSubject(final Subject subject){
        this.subject = subject;
    }

    public void attach(){
        subject.attach( this );
    }

    public void detach(){
        subject.detach( this );
    }

}

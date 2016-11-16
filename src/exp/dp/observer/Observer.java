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
        System.out.printf(
            "Notify <%s>: Subject <%s> has changed content to <%s>\n",
            name,
            subject.getTopicName( ),
            subject.getContent( )
        );
    }

    public String getName(){
        return name;
    }

    @SuppressWarnings( "hiding" )
    public void subscribe(final Subject subject){
        this.subject = subject;
        this.attach( );
    }

    public void unsubscribe(final Subject subject){
        this.detach( );
        this.subject = null;
    }

    private void attach(){
        subject.attach( this );
    }

    private void detach(){
        if(subject != null){
            subject.detach( this );
        }else{
            System.out.println( "The subject is already unsubscribed!" );
        }
    }

}

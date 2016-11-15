package exp.dp.observer;

public class ObserverPatternDemo
{
    public static void main(final String[] args){

        final Subject subA = new Subject("Topic A");
        final Subject subB = new Subject("Topic B");

        final Observer obs1 = new Observer("Observer 1" , subA);
        final Observer obs2 = new Observer("Observer 2" , subA);
        final Observer obs3 = new Observer("Observer 3" , subA);

        subA.setContent("Content 1 in topic A");

        System.out.println(  );

        obs3.detach( );
        subA.setTopicName( "Topic 2" );

        System.out.println(  );

        subB.setTopicName( "Topic 3" );
    }
}

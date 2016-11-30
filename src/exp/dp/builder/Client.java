package exp.dp.builder;

class Client
{
    public  static void main(final String args[])
    {
        ActorBuilder ab; //针对抽象建造者编程
        ab =  new AngelBuilder(); //反射生成具体建造者对象

//        final ActorController ac = new  ActorController();
        Actor actor;
        actor = ActorBuilder.construct(ab); //通过指挥者创建完整的建造者对象

        System.out.println(actor.getType()  + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
        System.out.println("服装：" + actor.getCostume());
        System.out.println("发型：" + actor.getHairstyle());


        actor = ActorBuilder.construct(new HeroBuilder()); //通过指挥者创建完整的建造者对象

        System.out.println(  );
        System.out.println(actor.getType()  + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
        System.out.println("服装：" + actor.getCostume());
        System.out.println("发型：" + actor.getHairstyle());
    }
}
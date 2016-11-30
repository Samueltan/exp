package exp.dp.builder;

//角色建造器：抽象建造者
abstract class ActorBuilder
{
    protected static Actor actor = new Actor();

    public  abstract void buildType();
    public  abstract void buildSex();
    public  abstract void buildFace();
    public  abstract void buildCostume();
    public  abstract void buildHairstyle();

    public static Actor construct(final ActorBuilder ab)
    {
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();

        return actor;
    }
}
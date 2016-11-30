package exp.dp.builder;

//游戏角色创建控制器：指挥者
class ActorController
{
    //逐步构建复杂产品对象
    public Actor construct(final ActorBuilder ab)
    {
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();

        actor=ab.createActor();

        return actor;
    }
}
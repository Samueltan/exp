package exp.dp.observer;

import java.util.ArrayList;

abstract class Subject {
    //定义一个观察者集合用于存储所有观察者对象
    protected ArrayList<Observer> observers = new ArrayList<Observer>();

    //注册方法，用于向观察者集合中增加一个观察者
    public void attach(final Observer observer) {
        observers.add(observer);
    }

    //注销方法，用于在观察者集合中删除一个观察者
    public void detach(final Observer observer) {
        observers.remove(observer);
    }

    //声明抽象通知方法
    @Override
    public abstract void notify(){};
}

//具体目标类ConcreteSubject是实现了抽象目标类Subject的一个具体子类，其典型代码如下所示：
class ConcreteSubject extends Subject {
    //实现通知方法
    @Override
    public void notify() {
        //遍历观察者集合，调用每一个观察者的响应方法
        for(final Object obs:observers) {
            ((Observer)obs).update();
        }
    }
}
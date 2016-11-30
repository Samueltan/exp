package exp.dp.composite;

//抽象文件类：抽象构件
abstract class AbstractFile {
    public void add(final AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public void remove(final AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public AbstractFile getChild(final int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    public abstract void killVirus();
}
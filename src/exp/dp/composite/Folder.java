package exp.dp.composite;

import java.util.ArrayList;

//文件夹类：容器构件
class Folder extends AbstractFile {
    //定义集合fileList，用于存储AbstractFile类型的成员
    private final ArrayList<AbstractFile> fileList=new ArrayList<AbstractFile>();
    private final String name;

    public Folder(final String name) {
        this.name = name;
    }

    @Override
    public void add(final AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(final AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(final int i) {
        return (AbstractFile)fileList.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("****对文件夹'" + name + "'进行杀毒");  //模拟杀毒

        //递归调用成员构件的killVirus()方法
        for(final Object obj : fileList) {
            ((AbstractFile)obj).killVirus();
        }
    }
}
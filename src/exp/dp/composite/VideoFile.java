package exp.dp.composite;

//视频文件类：叶子构件
class VideoFile extends AbstractFile {
    private final String name;

    public VideoFile(final String name) {
        this.name = name;
    }

    @Override
    public void add(final AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public void remove(final AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public AbstractFile getChild(final int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("----对视频文件'" + name + "'进行杀毒");
    }
}
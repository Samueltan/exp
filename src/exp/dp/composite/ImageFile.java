package exp.dp.composite;

//图像文件类：叶子构件
class ImageFile extends AbstractFile {
    private final String name;

    public ImageFile(final String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("----对图像文件'" + name + "'进行杀毒");
    }
}
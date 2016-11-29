package exp.dp.bridge;

//JPG格式图像：扩充抽象类
class JPGImage extends Image {
    @Override
    public void parseFile(final String fileName) {
        //模拟解析JPG文件并获得一个像素矩阵对象m;
        final Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为JPG。");
    }
}
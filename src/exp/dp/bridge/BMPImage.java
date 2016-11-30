package exp.dp.bridge;

//PNG格式图像：扩充抽象类
class PNGImage extends Image {
    @Override
    public void parseFile(final String fileName) {
        //模拟解析PNG文件并获得一个像素矩阵对象m;
        final Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为PNG。");
    }
}
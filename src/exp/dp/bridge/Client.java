package exp.dp.bridge;

class Client {
    public static void main(final String args[]) {
        final Image image = new JPGImage();
        final ImageImp imp = new WindowsImp();

        image.setImageImp(imp);
        image.parseFile("小龙女");

        image.setImageImp(new LinuxImp());
        image.parseFile("小龙女");
    }
}

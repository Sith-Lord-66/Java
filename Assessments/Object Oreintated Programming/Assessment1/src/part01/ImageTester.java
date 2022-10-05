package part01;

public class ImageTester {
    static Image Qub = new Image("QUB Logo", 50, 80, ImageType.JPEG);
    static Image BBC = new Image("BBC Main Headline", 150, 150, ImageType.PNG);

    public static void main(String[] args) {
        System.out.println(Qub);
        System.out.println(BBC);
    }
}

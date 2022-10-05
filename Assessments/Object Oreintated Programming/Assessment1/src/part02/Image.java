package part02;

public class Image {
    private String title;
    private int pixelWidth;
    private int pixelHeight;
    private ImageType info;

    public Image (String title,int pixelHeight,int pixelWidth, ImageType info){
        this.title = title;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.info = info;
    }
    public String getTitle() {
        return title;
    }
    public int getPixelWidth() {
        return pixelWidth;
    }
    public int getPixelHeight() {
        return pixelHeight;
    }
    public ImageType getInfo() {
        return info;
    }
    public String getDetails(){
        String result = new String();
        result += "Title: " + this.title + "\n";
        result += "Width: " + this.pixelWidth + " pixels.\n";
        result += "Height: " + this.pixelHeight + " pixels.\n";
        result += "Format: " + this.info + "\n";
        return result;
    }
    public String toString(){
        return getDetails();
    }
}

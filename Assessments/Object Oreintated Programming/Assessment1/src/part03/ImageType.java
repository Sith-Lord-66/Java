package part03;

public enum ImageType {
    JPEG("Joint Photographic Expert Group", ".jpg"),
    PNG("Portable Network Graphics", ".png"),
    SVG("Scalable Vector Graphics", ".svg"),
    WEBP("Web Picture format", ".webp");

    private String description;
    private String format;

    private ImageType(String str, String str1){
        description = str;
        format = str1;
    }
    public String getFormat(){
        return description;
    }
    public String getDetails(){
        return description + " (" + format + ")";
    }
    public String toString(){
        return  getDetails();
    }
}

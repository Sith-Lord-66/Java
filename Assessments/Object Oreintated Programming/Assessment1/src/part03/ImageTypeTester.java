package part03;

public class ImageTypeTester {

	public static void main(String[] args) {
		ImageType imType1 = ImageType.JPEG;
		ImageType imType2 = ImageType.PNG;
		ImageType imType3 = ImageType.SVG;
		ImageType imType4 = ImageType.WEBP;
		
		System.out.println(imType1.getFormat());
		System.out.println(imType2.getFormat());
		System.out.println(imType3.getFormat());
		System.out.println(imType4.getFormat());
		System.out.println();
		System.out.println(imType1);
		System.out.println(imType2);
		System.out.println(imType3);
		System.out.println(imType4);
	}

}

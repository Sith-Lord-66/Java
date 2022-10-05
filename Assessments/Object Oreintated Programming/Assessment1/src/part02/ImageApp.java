package part02;

import java.util.Scanner;

public class ImageApp {

	private static final int MAX = 5;
	private static Image[] data = new Image[MAX];
	private static int count = 0;
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String[] options = { "Add an Image", "Validate Images", "Quit" };
		Menu sysMenu = new Menu("Image Management App", options);
		int choice;
		do {
			choice = sysMenu.getUserChoice();
			if (choice == options.length) {
				break;
			}
			processChoice(choice);
		} while (true);

		System.out.println("App Terminated.");
	}

	private static void processChoice(int choice) {
		switch (choice) {
		case 1:
			addNewImage();
			break;
		case 2:
			validateImages();
			break;
		default:
			System.out.println("Error - Invalid Option.");
		}
	}
	
	private static void addNewImage() {
		System.out.print("--->Enter Image Title: ");
		String tile = input.nextLine();
		System.out.print("--->Enter Image Height: ");
		int pixelHeight = input.nextInt();
		input.nextLine();
		System.out.print("--->Enter Image Width: ");
		int pixelWidth = input.nextInt();
		input.nextLine();
		System.out.print("--->Enter Image Format: ");
		String format = input.nextLine();
		ImageType ImageFormat = null;
		switch (format){
			case "JPEG":
				ImageFormat = ImageType.JPEG; break;
			case "PNG":
				ImageFormat = ImageType.PNG; break;
			case "SVG":
				ImageFormat = ImageType.SVG; break;
			case "WEBP":
				ImageFormat = ImageType.WEBP; break;
			default:
				break;
		}
		Image image = new Image(tile,pixelHeight,pixelWidth,ImageFormat);
		if (storeImage(image)) System.out.print("Image Successfully Stored.\n\n");
	else System.out.println("There is not enough space to add another image\n\n");
	}

	private static void validateImages() {
		System.out.println("\nAvailable Images");
		for (int index = 0; index < count; index++){
			Image images = data[index];
			boolean valid = images.getPixelWidth() >= 30 && images.getPixelWidth() <= 200
					&& images.getPixelHeight() >= 30 && images.getPixelHeight() <= 200;
			String validString = "(Invalid) ";
			if (valid) validString = "(Valid) ";
			System.out.print("\n" + images.getTitle() + " " + validString + "Width: "
			+ images.getPixelWidth() + " Height: " + images.getPixelHeight() + " Format: "
					+ images.getInfo());
		}
		System.out.print("\n\n");
	}

	private static boolean storeImage(Image img) {
		if ( count < MAX && img != null ) {
			data[count++] = img;
			return true;
		}
		return false;
	}
	
}

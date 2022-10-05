
public class TravelToUni {

	public static void main(String[] args) {
		System.out.println(Train());
	}
	
	public static double Train() {
		
		double singleTicket = 5.5;
		double returnTicket = singleTicket * 2;
		System.out.println("The price to travel up to uni on the train is: £" + String.format("%.2f",returnTicket));
		return returnTicket;
	
	}
	
	public static void Car() {
		 
		double PricePerMile = 5.09;
		double HomeToUni = PricePerMile;
	}

}

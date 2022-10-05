import javax.swing.JOptionPane;

public class DoItYourself {

	public static void main(String[] args) {
		
		DoItYourself1();
		DoItYourself2();
		DoItYourself3();
		DoItYourself4();
		bigM();
		bigO();
		DoItYourself8();
	}

	public static void DoItYourself1() {
		
		JOptionPane.showMessageDialog(null, "Hello World!");
		String name = JOptionPane.showInputDialog("Please enter your name");
		JOptionPane.showMessageDialog(null, "Hello " + name);
	}
	
	public static void DoItYourself2() {
		System.out.println("*     *   ******* "
				+ "\n*     *      *"
				+ "\n*     *      *"
				+ "\n*******      *"
				+ "\n*     *      *"
				+ "\n*     *      *"
				+ "\n*     *   *******");
	}
	
	public static void DoItYourself3() {
		
		System.out.println("           .^."
				+ "\n          -----"
				+ "\n [@ @]    |q p|    [o o] "
				+ "\n~|_ _|~ --[===]-- ~|# #|~"
				+ "\n d   b    d   b    d   b");
	}
	
	public static void DoItYourself4() {
		
		int value = 0;
		int counter = 0;
		
		while(counter < 10){
			counter += 1;
			value = value + counter;
		}
		System.out.println(value);	
	}
	
	/* DoItYourself5
	   public class HelloWorld {
	       public static void main(String[] args) {
		       System.out.println("Hello World!);
	       }
	   }
	*/
	
	/*DoItYourself6
	public class test {
		public static void main (String[] args) {
			System.out.println("Hello" + "world");
			}
		}
   */
	
	//DoItYourself7
	public static void bigM() {
		
		System.out.println("M          M"
				+ "\nM M      M M"
				+ "\nM  M    M  M"
				+ "\nM   M  M   M"
				+ "\nM    M     M");
	}
	
	public static void bigO() {
		
		System.out.println("  OOO"
				+ "\nO     O"
				+ "\nO     O"
				+ "\nO     O"
				+ "\n  OOO");
	}
	
	public static void DoItYourself8() {
		
		System.out.println("+-----------+"
				+ "\n|   James   |"
				+ "\n+-----------+");
	}
	
}

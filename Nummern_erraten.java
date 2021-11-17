import java.util.Random;
import java.util.Scanner;

public class Nummern_erraten {

	public static void main(String[] args) 
	{
		begr();
		name();
		boolean b = start();
		if(b == true)
				game();
		if(b == false)
			System.out.println("Tschüß!");
	}

	
	public static void begr()
	{
		//Randomisierte Begrueßung
		
		String begr = "";							//Initialisieren der Speichermenge
		Random random = new Random();				//random zahlengenerator
		int number = random.nextInt(5);				//generiert eine zahl von 0 bis zu der angegebenen zahl ohne die angegebene Zahl (.nextInt(3) = 0, 1, 2)
		
		switch (number)								//geht für jede andere Nummer in einen anderen Case
		{
		case 0:
			begr = "Willkommen";		//verschiedene cases (Begrueßungen) die an die Speichermenge übergeben werden
			break;
		case 1:
			begr = "Hallo";
			break;
		case 2:
			begr = "Moin";
			break;
		case 3:
			begr = "Was geht?";
			break;
		case 4:
			begr = "EEYOO";
			break;
		case 5:
			begr = "Moinsen";
			break;
		}
		
		System.out.println(begr);					//ausgeben der gespeicherten Begrueßung
	}
	
	public static void name()
	{	
		System.out.println("Wie heißt du?");			//Namensfrage
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		//Eingabescanner
		String name = scanner.next();					
		System.out.println("Hallo " + name);			//Ausgabe einer Benutzerspezifischen Begrueßung
		
	}
	
	public static boolean start()
	{
		System.out.println("Sollen wir ein Spiel spielen?");	//Anweisung an den Nutzer
		System.out.println("Tippe 1 für ja und 2 für nein.");	
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);				//Scanner implementieren
		int s = scanner.nextInt();								//Speichermenge beschreiben
		boolean b = false;										//Speichermenge fuer den Rueckgabewert
		
		switch(s)												//zwei cases ja/nein
		{
		case 1:
			System.out.println("Los geht's! :)");				//verschiedene Rueckmeldungen und Rueckgaben
			b = true;
			break;
		case 2:
			System.out.println("Schade! :(");
			b = false;
			break;
		}
		
		return b;												//Uebergabeparameter
	}
	
	public static void game()
	{
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int number = random.nextInt(11);
		int guess = 0;
		int zaehler = 0;
		int fall = 0;
		
		do 
		{
			System.out.println("An welche Zahl denke ich?");
			guess = scanner.nextInt();
		
			if(guess == number)
			{
				System.out.println("Richtig! Es war die: " + number);
				fall = 1;
				break;
			}
			else
			{
				zaehler++;
				System.out.println("Oweh! Das war leider nicht richtig!");
				System.out.println("Du hast noch " + (5-zaehler) + " Versuche!");
				fall = 2;
			}
		} while(zaehler != 5);
		
		switch(fall)
		{
		case 1:
			System.out.println("Gewonnen! :)");
			break;	
		case 2:
			System.out.println("Du hast leider verloren! :(");
			break;
		}
		scanner.close();
	}
}

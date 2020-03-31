
/*
* Music.java
*/
import java.util.Scanner;

/**
 * Instrument class.
 */
abstract class Instrument {
	String musician;

	/**
	 * constructor pre: none post: A musician has been assigned to the
	 * instrument.
	 */
	public Instrument(String name) {
		musician = name;
	}

	/**
	 * Returns the name of the musician pre: none post: The name of the musician
	 * playing the instrument has been returned.
	 */
	public String getMusician() {
		return (musician);
	}

	/**
	 * Should return the sound of the instrument. pre: none post: The sound made
	 * by the instrument is returned.
	 */
	abstract String makeSound();
}

/**
 * Performance class.
 */
class Performance {
	private String arrangement;
	private Instrument solo;
	private Instrument duet_1, duet_2;
	private Instrument trio_1, trio_2, trio_3;

	/**
	 * constructor pre: none post: A soloist has been selected.
	 */
	public Performance(Instrument s) {
		solo = s;
		arrangement = solo.makeSound();
	}

	/**
	 * constructor pre: none post: The members of a duet have been selected.
	 */
	public Performance(Instrument d1, Instrument d2) {
		duet_1 = d1;
		duet_2 = d2;
		arrangement = duet_1.makeSound() + duet_2.makeSound();
	}

	/**
	 * constructor pre: none post: The members of a trio have been selected.
	 */
	public Performance(Instrument t1, Instrument t2, Instrument t3) {
		trio_1 = t1;
		trio_2 = t2;
		trio_3 = t3;
		arrangement = trio_1.makeSound() + trio_2.makeSound() + trio_3.makeSound();
	}

	/**
	 * Begins the performance. pre: none post: The performance has been played.
	 */
	public void begin() {
		System.out.println(arrangement);
	}

	/**
	 * Returns a String that represents the performers. pre: none post: A string
	 * representing the performers has been returned.
	 */
	public String toString() {
		String program = "The performance includes ";
		program += arrangement;
		return (program);
	}
}

/**
 * Vocal class.
 */
class Vocal extends Instrument {
	/**
	 * constructor pre: none post: A singer has been created.
	 */
	public Vocal(String singerName) {
		super(singerName);
	}

	/**
	 * Returns the sound of the instrument. pre: none post: The sound made by
	 * the singer.
	 */
	public String makeSound() {
		return ("LaLaLa");
	}

	/**
	 * Returns a String that represents the instrument. pre: none post: A string
	 * representing the singer.
	 */
	public String toString() {
		return (super.getMusician() + " sings " + makeSound() + ".");
	}
}

/**
 * Woodwind class.
 */
abstract class Woodwind extends Instrument {
	/**
	 * constructor pre: none post: A woodwind instrument has been created.
	 */
	public Woodwind(String player) {
		super(player);
	}

	/**
	 * Returns the sound of the instrument. pre: none post: The sound made by
	 * the instrument is returned.
	 */
	public String makeSound() {
		return ("toot");
	}
}

/**
 * Piccolo class.
 */
class Piccolo extends Woodwind {
	/**
	 * constructor pre: none post: A piccolo has been created.
	 */
	public Piccolo(String piccoloist) {
		super(piccoloist);
	}

	/**
	 * Returns the sound of the instrument. pre: none post: The sound made by
	 * the instrument is returned.
	 */
	public String makeSound() {
		return ("peep");
	}

	/**
	 * Returns a String that represents the instrument. pre: none post: A string
	 * representing the instrument has been returned.
	 */
	public String toString() {
		return (super.getMusician() + " plays " + makeSound() + ".");
	}
}

/**
 * Clarinet class.
 */
class Clarinet extends Woodwind {
	/**
	 * constructor pre: none post: A clarinet has been created.
	 */
	public Clarinet(String clarinetist) {
		super(clarinetist);
	}

	/**
	 * Returns the sound of the instrument. pre: none post: The sound made by
	 * the instrument is returned.
	 */
	public String makeSound() {
		return ("squawk");
	}

	/**
	 * Returns a String that represents the instrument. pre: none post: A string
	 * representing the instrument has been returned.
	 */
	public String toString() {
		return (super.getMusician() + " plays " + makeSound() + ".");
	}
}

abstract class Percussion extends Instrument {

	public Percussion(String player) {
		super(player);
	}

	public String makeSound() {
		return ("Bam");
	}
}

class Drum extends Percussion {

	public Drum(String drummer) {
		super(drummer);
	}

	public String makeSound() {
		return ("Ba Dum");
	}

	public String toString() {
		return (super.getMusician() + " plays " + makeSound() + ".");
	}
}

class Cymbal extends Percussion {

	public Cymbal(String cymbalist) {
		super(cymbalist);
	}

	public String makeSound() {
		return ("Tsss");
	}

	public String toString() {
		return (super.getMusician() + " plays " + makeSound() + ".");
	}
}

public class Music {
	/*
	 * Returns a selected instrument. pre: none post: An instrument object has
	 * been returned.
	 */
	public static Instrument assignInstrument() {
		String instrumentChoice;
		String name;

		Scanner input = new Scanner(System.in);
		System.out.println("Select an instrument for the band member. ");
		System.out.print("Vocals, Piccolo, Clarinet, Drum or Cymbal : ");
		instrumentChoice = input.nextLine();

		System.out.print("Enter the band member's name: ");
		name = input.nextLine();

		if (instrumentChoice.equalsIgnoreCase("V")) {
			return (new Vocal(name));
		} else if (instrumentChoice.equalsIgnoreCase("P")) {
			return (new Piccolo(name));
		} else { // if (instrumentChoice.equalsIgnoreCase("C")) {
			return (new Clarinet(name));
		}
	}

	public static void main(String[] args) {
		Performance band;
		Instrument bandMember1, bandMember2, bandMember3;
		Scanner input = new Scanner(System.in);
		String performanceChoice;

		/* assign instruments */
		bandMember1 = assignInstrument();
		bandMember2 = assignInstrument();
		bandMember3 = assignInstrument();
		System.out.println(bandMember1 + " " + bandMember2 + " " + bandMember3 + "\n");
		System.out.print("Would you like to hear a Solo, a Duet, a Trio, or Leave? ");
		performanceChoice = input.nextLine();
		while (!performanceChoice.equalsIgnoreCase("L")) {
			if (performanceChoice.equalsIgnoreCase("S")) {
				band = new Performance(bandMember1);
			} else if (performanceChoice.equalsIgnoreCase("D")) {
				band = new Performance(bandMember1, bandMember2);
			} else { // default to trio
				band = new Performance(bandMember1, bandMember2, bandMember3);
			}
			band.begin();
			System.out.print("\nWould you like to hear a Solo, a Duet, a Trio, or Leave? ");
			;
			performanceChoice = input.nextLine();
		}
	}
}

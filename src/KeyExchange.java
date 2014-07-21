import java.util.Random;

public class KeyExchange {
	static int prime = 2;
	static int base = 5;
	static int appSecret = 0;
	static int cardSecret = 0;

	public static int computeAliceSecret() {
		int receivedByAlice = keySentByBob();
		double power = Math.pow(receivedByAlice, appSecret);
		return (int) (power % prime);
	}

	public static int computeBobSecret() {
		int receivedByBob = keySentByAlice();
		double power = Math.pow(receivedByBob, cardSecret);
		return (int) (power % prime);
	}

	public static int keySentByBob() {
		double power = Math.pow(base, cardSecret);
		return (int) (power % prime);
	}

	public static int keySentByAlice() {
		double power = Math.pow(base, appSecret);
		return (int) (power % prime);
	}

	public static void main(String args[]) {
		//Scanner in = new Scanner(System.in);
		System.out.println("Hello");
		System.out.println("Enter Alice's Secret");
		appSecret = new Random().nextInt(100);
		System.out.println("Enter Bob's Secret");
		cardSecret = new Random().nextInt(100);
		System.out.println("Alice's Secret is : " + computeAliceSecret());
		System.out.println("Bob's Secret is : " + computeBobSecret());
	}
}
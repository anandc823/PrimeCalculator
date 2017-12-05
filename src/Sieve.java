import java.util.Scanner;
public class Sieve {
	
	public Sieve() {
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter upper bound");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		sc.close();
		Sieve s = new Sieve();
		s.primesTo(num);
		}

	public void primesTo(int n) throws IllegalArgumentException{
		if(n>2) {
			ArrayQueue<Integer> numbers = new ArrayQueue<Integer>(n);
			ArrayQueue<Integer> primes = new ArrayQueue<Integer>(n);
			for(int i=2; i<n; i++) {
				numbers.enqueue(i);
			}
			int p = numbers.first();
			while(p<=Math.sqrt(n)) {
				primes.enqueue(numbers.dequeue());
				ArrayQueue<Integer> noDivQ = new ArrayQueue<Integer>();
				while(!numbers.isEmpty()) {
					int del = numbers.dequeue();
					if(!(del%p==0)) {
						noDivQ.enqueue(del);
					}
				}
				numbers=noDivQ;
				p = numbers.first();
			}
			while(!numbers.isEmpty()) {
				primes.enqueue(numbers.dequeue());
			}
			System.out.print("Primes up to " + n + " are: " + primes.toString().substring(1,primes.toString().length()-1));
		}
		else if(n==2) {
			System.out.println("Primes up to 2 are: ");
		}
		else {
			throw new IllegalArgumentException("Error: Input must be a number greater 2.");
		}
	}
}

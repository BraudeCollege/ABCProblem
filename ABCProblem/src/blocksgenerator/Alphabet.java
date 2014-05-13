/*
 * Set of Blocks. Alphabet is used by AlphaBlocksGenerator to ensure
 * that 
 */

package blocksgenerator;

import java.util.ArrayList;
import java.util.Iterator;

public class Alphabet {
	private static ArrayList<Character> _alphabet;
	
	private Alphabet() {}
	
	public static ArrayList<Character> getAlphabet() {
		if (_alphabet != null) {
			return _alphabet;
		} else {
			populate();
			return _alphabet;
		}
	}
	
	private static void populate() {
		_alphabet = new ArrayList<Character>();
		//97
		
		for (int i = 97; i <= 122; i++) {
			Character ch = (char) i; 
			_alphabet.add(ch);
		}
	}
	
	public static void display() {
		if (_alphabet != null) {
			Iterator<Character> iterator = _alphabet.iterator();
			
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} else {
			_alphabet = getAlphabet();
			display();
		}
	}
}

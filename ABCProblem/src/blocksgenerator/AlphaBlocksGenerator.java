/*
 * Generate blocks for the ABC Problem.
 * 20 is the default, but you can do more if you'd like.
 */

package blocksgenerator;

import java.util.ArrayList;
import java.util.Random;

public class AlphaBlocksGenerator {
	private static final ArrayList<Character> ALPHABET = Alphabet.getAlphabet(); 
	
	private ArrayList<Block <Character, Character>> _alphaBlocks;
	private int _maxBlocks = 20;
	
	public AlphaBlocksGenerator(int maxBlocks) {
		_maxBlocks = maxBlocks;
		_alphaBlocks = new ArrayList<Block <Character, Character>>();
	}
	
	public void generateBlocks() {
		Block<Character, Character> temp;
		int firstRandNum;
		int secRandNum;
		
		for (int i = 1; i <= _maxBlocks; i++) {
			firstRandNum = generateRand();
			secRandNum = firstRandNum;
			while (secRandNum == firstRandNum) {
				secRandNum = generateRand();
			}
			temp = new Block<Character, Character>(ALPHABET.get(firstRandNum), ALPHABET.get(secRandNum));
			_alphaBlocks.add(temp);
		}
	}
	
	//do not use if you're using generateBlocks!
	//designed to test the original inputs found in the Rosetta Code wiki
	public void forceGeneration() {
		_alphaBlocks.add(new Block<Character, Character>('b', 'o'));
		_alphaBlocks.add(new Block<Character, Character>('x', 'k'));
		_alphaBlocks.add(new Block<Character, Character>('d', 'q'));
		_alphaBlocks.add(new Block<Character, Character>('c', 'p'));
		_alphaBlocks.add(new Block<Character, Character>('n', 'a'));
		_alphaBlocks.add(new Block<Character, Character>('g', 't'));
		_alphaBlocks.add(new Block<Character, Character>('r', 'e'));
		_alphaBlocks.add(new Block<Character, Character>('t', 'g'));
		_alphaBlocks.add(new Block<Character, Character>('q', 'd'));
		_alphaBlocks.add(new Block<Character, Character>('f', 's'));
		_alphaBlocks.add(new Block<Character, Character>('j', 'w'));
		_alphaBlocks.add(new Block<Character, Character>('h', 'u'));
		_alphaBlocks.add(new Block<Character, Character>('v', 'i'));
		_alphaBlocks.add(new Block<Character, Character>('a', 'n'));
		_alphaBlocks.add(new Block<Character, Character>('o', 'b'));
		_alphaBlocks.add(new Block<Character, Character>('e', 'r'));
		_alphaBlocks.add(new Block<Character, Character>('f', 's'));
		_alphaBlocks.add(new Block<Character, Character>('l', 'y'));
		_alphaBlocks.add(new Block<Character, Character>('p', 'c'));
		_alphaBlocks.add(new Block<Character, Character>('z', 'm'));
	}
	
	private int generateRand() {
		Random rand = new Random();
		int randNum = rand.nextInt(ALPHABET.size());
		return randNum;
	}
	
	public void display() {
		for (int i = 0; i < _alphaBlocks.size(); i++) {
			System.out.println("Index: " + i + "    " + "[" + _alphaBlocks.get(i).getA() + ", " + _alphaBlocks.get(i).getB() + "]");
		}
	}
	
	public static void main(String[] args) {
		AlphaBlocksGenerator abg = new AlphaBlocksGenerator(20);
		abg.generateBlocks();
		abg.display();
	}
}

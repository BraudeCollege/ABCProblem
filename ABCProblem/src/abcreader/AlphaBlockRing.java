/*
 * A circular array of Blocks
 * 
 * The default size of the array is 20, 
 * but this can be changed.
 */

package abcreader;

import java.util.ArrayList;

import blocksgenerator.AlphaBlocksGenerator;
import blocksgenerator.Block;

public class AlphaBlockRing {
	private AlphaBlocksGenerator _abGen = new AlphaBlocksGenerator();
	private ArrayList<Block <Character, Character>> _blocks;
	
	private int _size = 20;
	
	private int _head = 0;
	private int _tail = _head;
	
	public AlphaBlockRing() {
		initBlocks();
	}
	
	public AlphaBlockRing(int size) {
		_size = size;
		initBlocks();
	}
	
	private void initBlocks() {
		_abGen.forceGeneration();
		_blocks = _abGen.getBlocks();
	}
	
	public void visitBlocks() {
		int counter = 0;
		int index = _head;
		int wordIndex = 0;
		String word = "box";
		
		
		while (true) {
			if (index == _blocks.size()) {
				index = 0; //wrap back to the beginning
			}
			
			/*
			 * Check for matching character
			 * 		If doesn't match, break immediately
			 * 		else
			 * 		continue
			 */
			
			Character a = _blocks.get(index).getA();
			Character b = _blocks.get(index).getB();
			
			//test if the letters for the test word are present consecutively
			if (a == word.charAt(wordIndex)) {
				System.out.println("Good match at " + a);
				
				if (wordIndex == word.length() - 1) {
					break;
				} else {
					wordIndex++;
				}
			} 
			
			if (b == word.charAt(wordIndex)) {
				System.out.println("Good match at " + b);
				
				if (wordIndex == word.length() - 1) {
					break;
				} else {
					wordIndex++;
				}
			}
			
			//check if the letters aren't present consecutively
			
			
			//System.out.println("Block: " + index + " " + _blocks.get(index).toString());
			
			index++;
			counter++;
		}
	}
	
	public static void main(String[] args) {
		AlphaBlockRing abr = new AlphaBlockRing();
		abr.visitBlocks();
	}
}

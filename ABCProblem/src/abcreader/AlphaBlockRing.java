/*
 * An array of blocks based loosely off a circular array.
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
		int index = _head;
		int wordIndex = 0;
		String word = "soap"; //match, try "bxo" to see no match
		
		
		while (true) {
			Block<Character, Character> block = _blocks.get(index);
			
			if (word.charAt(wordIndex) == block.getA()) {
				if (indexIsInBounds(wordIndex, word)) {
					wordIndex++;
				} else {
					System.out.println("No match");
					break;
				}
				
				if (word.charAt(wordIndex) == block.getB()) {
					if (indexIsInBounds(wordIndex, word)) {
						wordIndex++;
					}
				} else {
					System.out.println("No match");
					break;
				}
			} else {
				//keep moving until you find the first letter
				//we know the first letter will always match
				//because the blocks are guaranteed to have all letters of the alphabet
				index++;
				
				if (indexIsInBounds(wordIndex, word)) {
					wordIndex++;
				}
			}
			
				if (wordIndex == word.length() - 1) {
					System.out.println("Match");
					break;
				}
				
				if (index == _size - 1) {
					index = 0; //wraparound
				}
				
				index++;
				block = _blocks.get(index);
		}
	}
	
	private boolean indexIsInBounds(int currLength, String word) {
		return (currLength != word.length() - 1);
	}
	
	public static void main(String[] args) {
		AlphaBlockRing abr = new AlphaBlockRing();
		abr.visitBlocks();
	}
}

package blocksgenerator;

public class Block<CharA, CharB> {
	private Character _a;
	private Character _b;
	
	public Block(Character a, Character b) {
		_a = a;
		_b = b;
	}
	
	public Character getA() {
		return _a;
	}
	
	public Character getB() {
		return _b;
	}
}

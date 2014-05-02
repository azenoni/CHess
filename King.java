public class King extends Piece {
	private Color color;
	private Image white;
	private Image black;
	public King(Color color) {
		this.color = color;
		if (color = Color.BLACK) {
			this.black = Piece.loadImage("king_black");
		} else {
			this.white = Piece.loadImage("king_white");
		}
		
	}
}
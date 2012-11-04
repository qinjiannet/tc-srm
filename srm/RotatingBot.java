public class RotatingBot {

	private boolean isVisited[][] = null;
	public int minArea(int[] moves) {
		int hw[] = getHeightAndWidth(moves);
		int height = hw[0];
		int width = hw[1];
		int sxy[] = getStartPoint(moves, height, width);
		int startX = sxy[0];
		int startY = sxy[1];
		System.out.println("hw:" + height + " " + width);
		boolean isValid = checkPath(moves, height, width, startX, startY);
		return isValid ? (height * width) : -1;
	}

	public int[] getHeightAndWidth(int[] moves) {
		int height = 0, width = 0;
		for (int i = 0; i < moves.length; i++) {
			int val = i % 4;
			if (val == 0 || val == 2) {
				width = Math.max(width, moves[i]);
			} else {
				height = Math.max(height, moves[i]);
			}
		}
		height++;
		width++;
		return new int[] { height, width };
	}

	public int[] getStartPoint(int[] moves, int height, int width) {
		int startX = width - moves[0] - 1;
		int startY = height - 1;
		if (moves.length > 1)
			startY = height - moves[1] - 1;
		return new int[] { startX, startY };
	}
	
	public boolean checkPath(int []moves, int height, int width, int startX, int startY) {
		boolean isValid = true;
		isVisited = new boolean[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				isVisited[i][j] = false;
			}
		}
		isVisited[startX][startY] = true;
		char curDir = 'e';
		int curX = startX;
		int curY = startY;
		int curPoint[] = {curX, curY};
		for (int i = 0; i < moves.length; i++) {
			int nextPoint[] = getNextPoint(curPoint, curDir, height, width);
			System.out.println(curDir + " " + curPoint[0] + " " + curPoint[1] + " " + nextPoint[0] + " " + nextPoint[1]);
			int dist = getDistance(curPoint, nextPoint);
			if (dist != moves[i]) {
				if (dist < moves[i] || i != moves.length - 1) {
					System.out.println("dist: " + dist + " " + "moves[" + i + "]:" + moves[i]);
					isValid = false;
					break;
				}
			}
			curDir = getNextDirection(curDir);
			curPoint = nextPoint;
		}
		return isValid;
	}
	
	public int[] getNextPoint(int curPoint[], char dir, int height, int width) {
		int curX = curPoint[0];
		int curY = curPoint[1];
		int gap = -1;
		if (dir == 'e' || dir == 'n') {
			gap = 1;
		}
		if (dir == 'e' || dir == 'w') {
			int i;
			for (i = curX; i + gap < width && i + gap >= 0; i+= gap) {
				if (!isVisited[i + gap][curY]) {
					isVisited[i + gap][curY] = true;
				} else {
					break;
				}
				curX = i + gap;
			}
		} else {
			int i;
			for (i = curY; i + gap < height && i + gap >= 0; i += gap) {
				if (!isVisited[curX][i + gap]) {
					isVisited[curX][i + gap] = true;
				} else {
					break;
				}
				curY = i + gap;
			}
		}
		return new int[]{curX, curY};
	}
	
	public int getDistance(int []pointA, int []pointB) {
		return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
	}
	
	public char getNextDirection(char dir) {
		switch (dir) {
			case 'e' : return 'n';
			case 'n' : return 'w';
			case 'w' : return 's';
			case 's' : return 'e';
		}
		return 0;
	}

	public static void main(String args[]) {
		System.out.println(new RotatingBot().minArea(new int[] { 1 }));
	}

}

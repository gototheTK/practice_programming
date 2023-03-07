

public class MazeProblem {
  // TODO : 미로 배열
    private final int[][] mazeArray = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
    };

    // TODO : 방문 체크 배열
    private final boolean[][] mazeVisitArray = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false}
    };

    private boolean isFinished = false;
    private static final int DEST_X = 7; // 도착 X
    private static final int DEST_Y = 3; // 도착 Y
    private static final int START_X = 0; // 시작 X
    private static final int START_Y = 1; // 시작 Y
    private static final int WALL = 1; // 벽


    public void escape() {
        move(START_X, START_Y);
    }

    private void visit(int x, int y) {
        mazeVisitArray[y][x] = true;
        System.out.printf("(%d,%d) ", x, y);
    }

    private void move(int x, int y) {

      if(isFinished) {
        return;
      }else if(DEST_X==x&&DEST_Y==y) {
        visit(x,y);
        isFinished = true;
        return;
      } else if(0 > x || y > 0 || x >mazeArray.length-1 || y > mazeArray.length-1) {
        return;
      } else if(WALL == mazeArray[x][y]) {
        return;
      } else if(mazeVisitArray[x][y]) {
        return;
      }

      visit(x,y);
      move(x+1, y);
      move(x-1, y);
      move(x, y+1);
      move(x, y-1);
      
    }
  
}
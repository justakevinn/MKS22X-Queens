public class QueenBoard{

  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    board[r][c] = -1;
    for (int x = 0; x < board[r].length; x++){
      if (x != c) board[r][x] += 1;
      if (x != r) board[x][c] += 1;

    }
  }


  public String toString(){
    String s = "";
    for (int i = 0; i < board.length; i++){
      s += "\n";
      for (int x = 0; x < board[i].length; x++){
        if (board[i][x] == -1){
          s += "Q ";
        }
        else{
          s += "_ ";
        }
      }
    }
    s += "\n";
    return s;
  }

  public static void main(String[] args){
    QueenBoard test = new QueenBoard(4);
    System.out.println(test);

  }



}

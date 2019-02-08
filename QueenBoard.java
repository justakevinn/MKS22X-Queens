public class QueenBoard{

  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    board[r][c] = -1;
    for (int x = c+1; x < board[r].length; x++){
      board[r][x] += 1;
    }
    for (int i = 1; r+i < board.length && c+i < board[0].length; i++ ){
      board[r+i][c+i] += 1;
    }
    for (int i = 1; r-i >= 0 && c+i < board.length; i++ ){
      board[r-i][c+i] += 1;
    }
    return true;
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
          if (board[i][x] != 0){
            s = s + board[i][x] + " ";
          }
          else{
            s+= "_ ";
          }
        }
      }
    }
    s += "\n";
    return s;
  }

  public static void main(String[] args){
    QueenBoard test = new QueenBoard(4);
    test.addQueen(1, 0);
    System.out.println(test);

  }



}

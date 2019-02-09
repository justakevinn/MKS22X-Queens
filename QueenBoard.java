public class QueenBoard{

  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      return false;
    }
    else{
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
  }

  private boolean removeQueen(int r, int c){
    if (board[r][c] != -1) return false;
    else{
      board[r][c] = 0;
      for (int x = c+1; x < board[r].length; x++){
        board[r][x] -= 1;
      }
      for (int i = 1; r+i < board.length && c+i < board[0].length; i++ ){
        board[r+i][c+i] -= 1;
      }
      for (int i = 1; r-i >= 0 && c+i < board.length; i++ ){
        board[r-i][c+i] -= 1;
      }
      return true;
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

    public boolean solve(){
      for (int i = 0 ; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
          if (board[i][j] != 0) {
            throw new IllegalStateException();
          }
        }
      }
      return false;
    }

    public static void main(String[] args){
      QueenBoard test = new QueenBoard(4);
      test.addQueen(1, 0);
      System.out.println(test);
      System.out.println(test.addQueen(0,1));
      System.out.println(test);
      test.addQueen(3, 1);
      System.out.println(test);
      System.out.println(test.removeQueen(2,1));
      System.out.println(test);
      test.removeQueen(1, 0);
      System.out.println(test);

    }



  }

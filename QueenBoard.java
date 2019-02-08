public class QueenBoard{

  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
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

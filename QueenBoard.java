public class QueenBoard{

  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private void clear(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[0].length; j++){
        board[i][j] = 0;
      }
    }
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


  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    for (int i = 0 ; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    return solveH(this,0);
  }



  private boolean solveH(QueenBoard Q, int col) {
    //  System.out.println(Text.go(1,1));
    //  System.out.println(this);Text.wait(50); //adjust this delay
    if (col >= board.length) {
      return true;
    }
    for (int i = 0; i < board.length; i ++) {
      if (Q.addQueen(i, col)) {
        System.out.println(Text.go(1,1));
        System.out.println(this);Text.wait(50); //adjust this delay

        if (solveH(Q,col+1)) {
          //System.out.println(toString());
          return true;
        }
        else {
          Q.removeQueen(i,col);
        }
      }
    }
    return false;
  }




  public int countSolutions(){
    for (int i = 0 ; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    return countSolutionsH(this,0);
  }


  private int countSolutionsH(QueenBoard Q, int col){
    int total = 0;
    if (col >= board.length) {
      return 1;
    }
    for (int i = 0; i < board.length; i++) {
      if (Q.addQueen(i,col)) {
        total += countSolutionsH(Q,col+1);
        Q.removeQueen(i,col);
        //System.out.println(toString());
      }
    }
    return total;
  }

/*  public static void runTest(int i){
    QueenBoard b;
    int[]tests =   {1,2,3,4,5,8};
    int[]answers = {1,0,0,2,10,92};
    if(i >= 0 && i < tests.length ){
      int size = tests[i];
      int correct = answers[i];
      b = new QueenBoard(size);
      int ans  = b.countSolutions();

      if(correct==ans){
        System.out.println("PASS board size: "+tests[i]+" "+ans);
      }else{
        System.out.println("FAIL board size: "+tests[i]+" "+ans+" vs "+correct);
      }
    }
  }
  */

  public static void main(String[] args){
    //QueenBoard test = new QueenBoard(16);
    /*test.addQueen(1, 0);
    System.out.println(test);
    System.out.println(test.addQueen(0,1));
    System.out.println(test);
    test.addQueen(3, 1);
    System.out.println(test);
    System.out.println(test.removeQueen(2,1));
    System.out.println(test);
    test.removeQueen(1, 0);
    System.out.println(test);*/
    //System.out.println(test);
    //System.out.println(test.solve());
    //runTest(0);
    //runTest(1);
    //runTest(2);
    //runTest(3);
    //runTest(4);
    //runTest(5);

  }



}

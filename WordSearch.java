public class WordSearch{
    private char[][]data;
    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
      clear();
       }
    private void clear(){
      for (int c = 0; c < data.length; c ++){
        for (int t = 0; t < data[c].length; t ++){
          data[c][t] = '-';
        }
      }
    }
    public String toString(){
      String ans = "";
      for (int c = 0; c < data.length; c ++){
        for (int t = 0; t < data[c].length; t ++){
          ans = ans + data[c][t] + " ";
        }
        ans = ans + "\n";
      }
      return ans;
    }
    public boolean addWordHorizontal(String word,int row, int col){
      int leng = word.length();
      if (row < 0 || row >= data.length){
        return false;
      }
      if (col + leng > data[row].length){
        return false;
      }
      for (int c = 0; c < leng; c++){
        if (data[row][col + c] == '-')
        {}
        else {
          if (data[row][col+c] != word.charAt(c)){
            return false;
          }
        }
      }
      for (int c = 0; c < leng; c++){
        data[row][col + c] = word.charAt(c);
      }
      return true;
    }
    public boolean addWordVertical(String word,int row, int col){
      int leng = word.length();
      if (col < 0 || col >= data.length){
        return false;
      }
      if (row + leng > data[row].length){
        return false;
      }
      for (int c = 0; c < leng; c++){
        if (data[row + c][col] == '-')
        {}
        else {
          if (data[row+ c][col] != word.charAt(c)){
            return false;
          }
        }
      }
      for (int c = 0; c < leng; c++){
        data[row +c ][col] = word.charAt(c);
      }
      return true;
    }

  }

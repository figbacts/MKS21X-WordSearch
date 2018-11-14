import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.util.Random;
public class WordSearch{
    private char[][]data;
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> wordsadded = new ArrayList<>();
    private Random rng = new Random();
    private int seed = rng.nextInt() & 1000;
    public WordSearch(int rows,int cols, String filename){
      data = new char[rows][cols];
      clear();
      try{
        File f = new File(filename);
        Scanner in = new Scanner(f);
        while (in.hasNext()){
          words.add(in.next());
        }
        addAllWords();
      }
      catch(FileNotFoundException e){
        System.out.println ("File not found: " + filename);
        System.exit(1);
      }
       }
       public WordSearch(int rows,int cols, String filename, int randSeed){
         seed = randSeed;
         data = new char[rows][cols];
         clear();
         try{
           File f = new File(filename);
           Scanner in = new Scanner(f);
           while (in.hasNext()){
             words.add(in.next());
           }
           addAllWords();
         }
         catch(FileNotFoundException e){
           System.out.println ("File not found: " + filename);
           System.exit(1);
         }
          }
    private void addAllWords(){
      Random fake = new Random(seed);
      int index = fake.nextInt() % words.size();
      int rinc = fake.nextInt() % 2;
      int cinc = fake.nextInt() % 2;
      for (int i = 0; i < 40; i ++){
        if (words.size() != 0){
        index = fake.nextInt() % words.size();}
        index = abval(index);
        rinc = fake.nextInt() % 2;
        cinc = fake.nextInt() % 2;
        for (int c = 0; c < 10; c ++){
          if (addWord(words.get(index), abval(fake.nextInt() % data.length), abval(fake.nextInt() % data[0].length),rinc,cinc)){
            wordsadded.add(words.remove(index));
            c = 10;
          }
        }
        if (words.size() == 0) {
          i = 40;
        }
      }

System.out.println (seed);
    }

    private int abval(int num){
      if (num < 0){
      return num * -1;}
      return num;
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
          if (t == 0){
            ans = ans + "|";
          }
          if (t == data[c].length){
            ans = ans + "|";
          }
          if (t == data[c].length -1){
            ans = ans + data[c][t];
          }
          else {
          ans = ans + data[c][t] + " ";
        }
          if (t == data[c].length -1 ){
            ans = ans + "|";
          }
        }
        ans = ans + "\n";
      }
      ans = ans + "Words: " + wordsadded;
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
      if (col < 0 || col > data[row].length){
        System.out.println("1");
        return false;
      }
      if (row + leng > data.length ){
        System.out.println("2");
        return false;
      }
      for (int c = 0; c < leng; c++){
        if (data[row + c][col] == '-')
        {}
        else {
          if (data[row + c][col] != word.charAt(c)){
            System.out.println("3");
            return false;
          }
        }
      }
      for (int c = 0; c < leng; c++){
        data[row +c ][col] = word.charAt(c);
      }
      return true;
    }
    public boolean addWordDiagonal(String word,int row, int col){
      int leng = word.length();
      if (row < 0 || row >= data.length){
        return false;
      }
      if (col + leng > data[row].length){
        return false;
      }
      if (col < 0 || col >= data[row].length){
        return false;
      }
      if (row + leng > data.length){
        return false;
      }
      for (int c = 0; c < leng; c++){
        if (data[row + c][col + c] == '-')
        {}
        else {
          if (data[row+ c][col + c] != word.charAt(c)){
            return false;
          }
        }
      }
      for (int c = 0; c < leng; c++){
        data[row + c ][col +c ] = word.charAt(c);
      }
      return true;
    }
    private boolean addWord (String word, int r, int c, int rowIncrement, int colIncrement){
      if (rowIncrement == 0 && colIncrement == 0){
        return false;}
      int leng = word.length();
      if (colIncrement > 0){
      if (c + leng > data[r].length){
        return false;
      }
    }
    if (colIncrement < 0){
    if (c - leng < 0){
      return false;
    }
  }
  if (rowIncrement > 0){
  if (r + leng > data.length){
    return false;
  }
}
if (rowIncrement < 0){
if (r - leng < 0){
  return false;
}
}
      for (int i = 0; i < leng; i++){
        if (data[r + (rowIncrement * i)][c + (colIncrement * i)] == '-')
        {}
        else {
          if (data[r + (rowIncrement * i)][c + (colIncrement * i)] != word.charAt(i)){
            return false;
          }
        }
      }
      for (int i = 0; i < leng; i++){
        data[r + (rowIncrement * i)][c + (colIncrement * i)] = word.charAt(i);
      }
      return true;
      }

    }

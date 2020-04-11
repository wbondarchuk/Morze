package TmpPack;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Coder coder = null;
        File Source = null;
        File Out = null;
        Scanner scan = new Scanner(System.in);
        if(scan.nextInt() == 1){
            coder = new En2Morze();
            Source = new File("E:\\Proga\\untitled\\EnglishIn.txt");
            Out = new File("E:\\Proga\\untitled\\MorzeOut.txt");
        } else {
            coder = new Morze2En();
            Source = new File("E:\\Proga\\untitled\\MorzeIn.txt");
            Out = new File("E:\\Proga\\untitled\\EnglishOut.txt");
        }
        StringBuilder CodedString = coder.handle(Source);
        FileOutputStream WriteToFile = new FileOutputStream(Out);
        WriteToFile.write(CodedString.toString().getBytes());
    }
}



//2я часть задачи - статистика использования букв
//use HashSet  - набор неповторяющихся элементов
//class SecondPart{
//    HashSet<Integer> hs = new HashSet();
//    hs.add(new Statistics('a'));
//    hs.add(new Statistics('a'));
//map.put(e, null_elem);
//hash(e);
//e.equals(key);
//HashSet - обертка вокруг map
//}

//class Statistics{
//    int counter = 0;
//    char ch;
//    Statistics (char ch){this.ch = ch;}
//    public int hashCode(){
//        return ch;
//    }
//    public boolean equals(Object o){
//       counter++;
//        return true;
//    }
//}
package TmpPack;

import java.util.HashSet;


class SecondPart{
    static HashSet<Statistics> hs = new HashSet<Statistics>();
    static void add(char ch){
        Statistics tmp = new Statistics(ch);
        hs.add(tmp);
    }
    static HashSet<Statistics> getStatistics(){
        return hs;
    }
    static void printStatistics(){
        for (Statistics tmp : hs) {
            System.out.println(tmp.print());
        }
    }
}

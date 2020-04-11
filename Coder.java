package TmpPack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract class Coder
{
    //translate str to str
    abstract StringBuilder handle(File InputFileName);//метод ктр преобразует текст
}

class En2Morze extends Coder{
    @Override//перегрузка
    StringBuilder handle(File InputFileName) {//класс стринг не изменяемый, билдер наследован от изменяемого интерфейса, позволяет изменять строку
        Scanner EnTxt = null;
        try {
            EnTxt = new Scanner(InputFileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder EngStr = new StringBuilder("");
        if (EnTxt != null) {
            while(EnTxt.hasNext()){
                EngStr.append(EnTxt.nextLine()).append("\n");
            }
        }
        System.out.println(EngStr);
        int i = 0;
        StringBuilder ReturnedStr = new StringBuilder("");

        while(i < EngStr.length()){
            if(EngStr.substring(i,i+1).equals(Alphabet.terminator)){
                ReturnedStr.append(Alphabet.terminator).append(Alphabet.terminator);//добавка пробела
            } else if(EngStr.substring(i,i+1).equals("\n")){
                ReturnedStr.append("\n");
            }else {
                ReturnedStr.append(Alphabet.E2M.getProperty(EngStr.substring(i,i+1)));
                SecondPart.add(EngStr.charAt(i));
            }
            i++;
        }
        System.out.println("ReturnedStr:\n" + ReturnedStr);
        SecondPart.printStatistics();
        return ReturnedStr;
    }
}

class Morze2En extends Coder{
    @Override
    StringBuilder handle(File InputFileName) {
        Scanner MTxt = null;
        try {
            MTxt = new Scanner(InputFileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder MStr = new StringBuilder("");
        if (MTxt != null) {
            while(MTxt.hasNext()){
                MStr.append(MTxt.nextLine()).append("\n");
            }
        }
        System.out.println(MStr);
        int start = 0;
        int end = 0;
        StringBuilder ReturnedStr = new StringBuilder("");
        while(end< MStr.length()){
            while(!Alphabet.terminator.equals(Character.toString(MStr.charAt(end)))){
                if((end + 1) == MStr.length()) break;
                end++;
            }
            if(start != end){
                ReturnedStr.append(Alphabet.M2E.getProperty(MStr.substring(start,end)));
                if(Alphabet.M2E.getProperty(MStr.substring(start,end))!=null) {
                    SecondPart.add(Alphabet.M2E.getProperty(MStr.substring(start, end)).charAt(0));
                }
                start = end;
            }
            while(Alphabet.terminator.equals(Character.toString(MStr.charAt(end)))){
                if((end + 1) == MStr.length()) break;
                end++;
            }
            if((end - start) > 2){
                ReturnedStr.append(" ");
            }
            if("\n".equals(Character.toString(MStr.charAt(end)))){
                ReturnedStr.append("\n");
                end++;
            }
            start = end;
            end++;
        }
        System.out.println("ReturnedStr:\n" + ReturnedStr);
        SecondPart.printStatistics();
        return ReturnedStr;
    }
}
package TmpPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

abstract class Alphabet
{
    static String terminator = " ";
    static Properties E2M = new Properties();
    static Properties M2E = new Properties();
    static {
        FileInputStream in_d = null;
        FileInputStream in_c = null;
        try {
            in_d = new FileInputStream("E:\\Proga\\untitled\\src\\TmpPack\\Decode.properties");
            in_c = new FileInputStream("E:\\Proga\\untitled\\src\\TmpPack\\Code.properties");
            E2M.load(in_c);//загрузка в класс
            M2E.load(in_d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Start {
    private static final int ROT = 2;
    private static final String SYMBOLS_ARRAY = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    private static final String NAME_PATH_RESULT="F:\\Text\\result.TXT";
    private static final String LOCALE_PATH_START="F:\\Text\\Test_One.TXT";
    private static final String LOCALE_PATH_DECOD="F:\\Text\\Test_Two.TXT";


    public static void main(String[] args) {
        String s = "Это один из самых простых и известных методов шифрования";
        createFileCipher(parse(LOCALE_PATH_START),NAME_PATH_RESULT);
        createFileDecoding(parse(NAME_PATH_RESULT),LOCALE_PATH_DECOD);
        String test1=cipher(s);
        System.out.println(test1);
        System.out.println(bruteForce(test1,ROT));
    }

    public static String cipher(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] textArrGoodString = SYMBOLS_ARRAY.toCharArray();
        char[] textArr = text.toLowerCase().toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            char sr = textArr[i];
            for (int j = 0; j < textArrGoodString.length; j++) {
                if (sr == textArrGoodString[j]) {
                    try {
                        textArr[i] = textArrGoodString[j + ROT];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }
                }
            }
        }
        stringBuilder.append(textArr);
        return stringBuilder.toString();
    }

    protected static List<String> parse(String localePathStart) {
        List<String> stringsArraylocalePathStart = new ArrayList<>();
        Path pathlocalePathStart = Path.of(localePathStart);
        if (Files.exists(Path.of(localePathStart))) {
            try {
                stringsArraylocalePathStart = Files.readAllLines(pathlocalePathStart);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //сделать окно с надписью такого файла нет
        }
        return stringsArraylocalePathStart;
    }

    protected static void createFileCipher(List<String> arrayParse, String namePath) {
        Path pathName = Path.of(namePath);
       if (!Files.exists(pathName)){
        try {
            Files.createFile(pathName);
        } catch (IOException e) {
            e.printStackTrace();
        }
       }
        if (Files.exists(pathName)) {
            try {
                OutputStream outputStream = Files.newOutputStream(pathName);
                for (String oneParse : arrayParse) {
                    outputStream.write(cipher(oneParse).getBytes(StandardCharsets.UTF_8));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    protected static String bruteForce(String cipherText,int rot){
        StringBuilder stringBuilder = new StringBuilder();
        char[] arraysCipherText=cipherText.toLowerCase().toCharArray();
        char[] textArrGoodString = SYMBOLS_ARRAY.toCharArray();
        for (int i = 0; i < arraysCipherText.length; i++) {
            char symbolOne=arraysCipherText[i];
            for (int j = 0; j < textArrGoodString.length; j++) {
                if (symbolOne==textArrGoodString[j]){
                    try {
                        if (symbolOne==' '){
                            break;
                        }
                        arraysCipherText[i]=textArrGoodString[j-rot];
                    }catch (ArrayIndexOutOfBoundsException e){
                        break;
                    }

                }
            }
        }
        stringBuilder.append(arraysCipherText);
        return stringBuilder.toString();
    }
    protected static void createFileDecoding(List<String> arrayParse, String namePath) {
        Path pathName = Path.of(namePath);
        if (!Files.exists(pathName)){
            try {
                Files.createFile(pathName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Files.exists(pathName)) {
            try {
                OutputStream outputStream = Files.newOutputStream(pathName);
                for (String oneParse : arrayParse) {
                    outputStream.write(bruteForce(oneParse,ROT).getBytes(StandardCharsets.UTF_8));


                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

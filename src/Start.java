import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Start {
    private static int ROT;
    private static final String SYMBOLS_ARRAY = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    private static final int MAX = SYMBOLS_ARRAY.length();
    private static final String NAME_PATH_RESULT = "F:\\Text\\result.TXT";
    private static final String LOCALE_PATH_START = "F:\\Text\\Test_One.TXT";
    private static final String LOCALE_PATH_DECOD = "F:\\Text\\Test_Two.TXT";


    public static void main(String[] args) {
        сhoiceRot(6);
        createFileCipher(parse(LOCALE_PATH_START), NAME_PATH_RESULT);
        createFileDecoding(parse(NAME_PATH_RESULT), LOCALE_PATH_DECOD);

    }

    public static String cipher(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] textArrGoodString = SYMBOLS_ARRAY.toCharArray();
        char[] textArr = text.toLowerCase().toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            char sr = textArr[i];
            for (int j = 0; j <= textArrGoodString.length; j++) {
                try {
                    if (sr == textArrGoodString[j]) {
                        textArr[i] = textArrGoodString[j + ROT];

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
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
            System.out.println("no file");
            //сделать окно с надписью такого файла нет
        }
        return stringsArraylocalePathStart;
    }

    protected static void createFileCipher(List<String> arrayParse, String namePath) {
        Path pathName = Path.of(namePath);
        if (!Files.exists(pathName)) {
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

    protected static String bruteForce(String cipherText) {
        StringBuilder stringBuilder1 = new StringBuilder();//сделать список стрингбилдеров

        char[] arraysCipherText = cipherText.toLowerCase().toCharArray();
        char[] textArrGoodString = SYMBOLS_ARRAY.toCharArray();

        for (int i = 0; i < arraysCipherText.length; i++) {
            char symbolOne = arraysCipherText[i];
            for (int j = 0; j < textArrGoodString.length; j++) {
                if (symbolOne == textArrGoodString[j]) {
                    try {
                        //абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,":-!?
                            if (cipherText.endsWith(".")) {
                                arraysCipherText[i] = textArrGoodString[j];
                                stringBuilder1.append(arraysCipherText[i]);
                            }
                            if (cipherText.endsWith(",")) {
                                arraysCipherText[i] = textArrGoodString[j - 1];
                                stringBuilder1.append(arraysCipherText[i]);
                            }
                            if (cipherText.endsWith("\"")) {
                                arraysCipherText[i] = textArrGoodString[j - 2];
                                stringBuilder1.append(arraysCipherText[i]);
                            }
                            if (cipherText.endsWith(":")) {
                                arraysCipherText[i] = textArrGoodString[j - 3];
                                stringBuilder1.append(arraysCipherText[i]);
                            }
                            if (cipherText.endsWith("-")) {
                                arraysCipherText[i] = textArrGoodString[j - 4];
                                stringBuilder1.append(arraysCipherText[i]);
                            }
                            if (cipherText.endsWith("!")) {
                                arraysCipherText[i] = textArrGoodString[j -5];
                                stringBuilder1.append(arraysCipherText[i]);
                            }
                            if (cipherText.endsWith("?")) {
                                arraysCipherText[i] = textArrGoodString[j - 6];
                                stringBuilder1.append(arraysCipherText[i]);
                            }
                            if (cipherText.endsWith(" ")) {
                                arraysCipherText[i] = textArrGoodString[j - 7];
                                stringBuilder1.append(arraysCipherText[i]);
                            }


                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }

                }
            }

        }

        return stringBuilder1.toString().replace('-',' ');
    }



    protected static void createFileDecoding(List<String> arrayParse, String namePath) {
        Path pathName = Path.of(namePath);
        if (!Files.exists(pathName)) {
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
                    outputStream.write(bruteForce(oneParse).getBytes(StandardCharsets.UTF_8));


                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static void сhoiceRot(int num) {
        if (num <= MAX) {
            switch (num) {
                case 1:
                    ROT = Rot.ROT1.getRot();
                    break;
                case 2:
                    ROT = Rot.ROT2.getRot();
                    break;
                case 3:
                    ROT = Rot.ROT3.getRot();
                    break;
                case 4:
                    ROT = Rot.ROT4.getRot();
                    break;
                case 5:
                    ROT = Rot.ROT5.getRot();
                    break;
                case 6:
                    ROT = Rot.ROT6.getRot();
                    break;
                case 7:
                    ROT = Rot.ROT7.getRot();
                    break;
                default:
                    System.out.println("Такого числа нет");

            }
        } else {
            try {
                throw new ExceptionnChoice();
            } catch (ExceptionnChoice e) {
                e.printStackTrace();
            }
        }

    }
}

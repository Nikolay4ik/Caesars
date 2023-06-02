public class WorkCipher {
    private static int ROT;
    public static String cipher(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] textArrGoodString = WorkResources.SYMBOLS_ARRAY.toCharArray();
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
   public static String bruteForce(String cipherText) {
        StringBuilder stringBuilder1 = new StringBuilder();

        char[] arraysCipherText = cipherText.toLowerCase().toCharArray();
        char[] textArrGoodString = WorkResources.SYMBOLS_ARRAY.toCharArray();

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





    public static void сhoiceRot(int num) {
        if (num <= WorkResources.MAX) {
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

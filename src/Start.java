public class Start {
    public static void main(String[] args) {
        String s = "Это один из самых простых и известных методов шифрования";
        System.out.println(shifr(s));
    }

    static String shifr(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        String goodString = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
        char[] textArrGoodString = goodString.toCharArray();
        char[] textArr = text.toCharArray();
        int a = 2;
        for (int i = 0; i < textArr.length; i++) {
            char sr=textArr[i];
            for (int j = 0; j < textArrGoodString.length; j++) {
                if (sr==textArrGoodString[j]){
                  try {
                      textArr[i]=textArrGoodString[j+a];
                  }catch (ArrayIndexOutOfBoundsException e){
                      break;
                  }

                }
            }
        }
        stringBuilder.append(textArr);

        return stringBuilder.toString();
    }
}

package Function;

import Function.WorkCipher;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WorksFiles {
   private WorkCipher workCipher;
   public static WorksFiles WORKS_FILES =new WorksFiles();

    public WorksFiles(WorkCipher workCipher) {
        this.workCipher = workCipher;
    }

    public WorksFiles() {
        workCipher= new WorkCipher();
    }

    public static List<String> parse(String localePathStart) {
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


    public  void createFileCipher(List<String> arrayParse, String namePath) {
        Path pathName = Path.of(namePath);
        if (!Files.exists(pathName)) {
            try {
                Files.createFile(pathName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Files.exists(pathName)) {
            try(OutputStream outputStream = Files.newOutputStream(pathName)) {
                for (String oneParse : arrayParse) {
                    outputStream.write(workCipher.cipher(oneParse).getBytes(StandardCharsets.UTF_8));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public static void createFileDecoding(List<String> arrayParse, String namePath) {
        Path pathName = Path.of(namePath);
        if (!Files.exists(pathName)) {
            try {
                Files.createFile(pathName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Files.exists(pathName)) {
            try(OutputStream outputStream = Files.newOutputStream(pathName)) {
                for (String oneParse : arrayParse) {
                    outputStream.write(WorkCipher.bruteForce(oneParse).getBytes(StandardCharsets.UTF_8));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Start {
    private static final String NAME_PATH_RESULT = "FileTxt\\result.TXT";
    private static final String LOCALE_PATH_START = "FileTxt\\Test_One.TXT";
    private static final String LOCALE_PATH_DECOD = "FileTxt\\Test_Two.TXT";

    public Start() {
       WorkResources workResources= new WorkResources();
       workResources.setStepsCode(6);
       WorkCipher.сhoiceRot(workResources.getStepsCode());
       workResources.setLocalePathStart(LOCALE_PATH_START);
       workResources.setNamePathResult(NAME_PATH_RESULT);
       workResources.setLocalePathDecod(LOCALE_PATH_DECOD);
       WorksFiles.createFileCipher(WorksFiles.parse(workResources.getLocalePathStart()), workResources.getNamePathResult());
       WorksFiles.createFileDecoding(WorksFiles.parse(workResources.getNamePathResult()), workResources.getLocalePathDecod());
    }

    public static void main(String[] args) {
        new Start();

    }


}

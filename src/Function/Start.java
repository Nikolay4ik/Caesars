package Function;

public class Start {
    private static final String NAME_PATH_RESULT = "FileTxt\\result.TXT";
    private static final String LOCALE_PATH_START = "FileTxt\\Test_One.TXT";
    private static final String LOCALE_PATH_DECOD = "FileTxt\\Test_Two.TXT";

    public Start() {
       WorkResources workResources= new WorkResources();
       WorkCipher workCipher = new WorkCipher();
       WorksFiles worksFiles= new WorksFiles();
       workResources.setStepsCode(6);

       workCipher.сhoiceRot(workResources.getStepsCode());
       workResources.setLocalePathStart(LOCALE_PATH_START);
       workResources.setNamePathResult(NAME_PATH_RESULT);
       workResources.setLocalePathDecod(LOCALE_PATH_DECOD);
       worksFiles.createFileCipher(WorksFiles.parse(workResources.getLocalePathStart()), workResources.getNamePathResult());
       WorksFiles.createFileDecoding(WorksFiles.parse(workResources.getNamePathResult()), workResources.getLocalePathDecod());
    }

}

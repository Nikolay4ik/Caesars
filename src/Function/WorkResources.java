package Function;

public class WorkResources {
    private int stepsCode;
    public static String SYMBOLS_ARRAY = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    public static int MAX = SYMBOLS_ARRAY.length();
    private String namePathResult; // "FileTxt\\result.TXT";
    private String localePathStart;// = "FileTxt\\Test_One.TXT";
    private String localePathDecod;// = "FileTxt\\Test_Two.TXT";
    public static WorkResources WORK_RESOURCES=new WorkResources();

    public int getStepsCode() {
        return stepsCode;
    }

    public void setStepsCode(int stepsCode) {
        this.stepsCode = stepsCode;
    }

    public WorkResources() {
    }

    public WorkResources(String namePathResult, String localePathStart, String localePathDecod) {
        this.namePathResult = namePathResult;
        this.localePathStart = localePathStart;
        this.localePathDecod = localePathDecod;
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
    }

    public String getNamePathResult() {
        return namePathResult;
    }

    public void setNamePathResult(String namePathResult) {
        this.namePathResult = namePathResult;
    }

    public String getLocalePathStart() {
        return localePathStart;
    }

    public void setLocalePathStart(String localePathStart) {
        this.localePathStart = localePathStart;
    }

    public String getLocalePathDecod() {
        return localePathDecod;
    }

    public void setLocalePathDecod(String localePathDecod) {
        this.localePathDecod = localePathDecod;
    }
}

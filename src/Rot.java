public enum Rot  {
    ROT1(1),
    ROT2(2),
    ROT3(3),
    ROT4(4),
    ROT5(5),
    ROT6(6),
    ROT7(7),
    ;
private int rot;
    Rot(int i) {
        this.rot=i;
    }

    public int getRot() {
        return rot;
    }
}

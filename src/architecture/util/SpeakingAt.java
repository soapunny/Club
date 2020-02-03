package architecture.util;

public enum SpeakingAt {
    //
    Left(0),
    Middle(3),
    Right(6);

    private int tabCount;

    SpeakingAt(int tabCount){
        this.tabCount = tabCount;
    }

    public void setTabCount(byte tabCount){this.tabCount = tabCount;}
    public int getTabCount(){return tabCount;}
}

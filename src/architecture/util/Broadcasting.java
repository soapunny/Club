package architecture.util;

public class Broadcasting {
    //
    private int tabCount;
    private String className;
    private boolean formatted;
    private boolean etiquetteMode;

    public Broadcasting(SpeakingAt speakingAt, Object object){
        this.tabCount = speakingAt.getTabCount();
        this.className = object.getClass().getSimpleName();
    }

    public void broadcast(String message){
        //
        System.out.print(appendTabs().append(formatMessage(message)));
    }

    public void broadcastln(String message){
        //
        System.out.println(appendTabs().append(formatMessage(message)));
    }

    private StringBuilder appendTabs(){
        //
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0 ;i<tabCount;i++)
            stringBuilder.append("\t");

        return stringBuilder;
    }

    private String formatMessage(String message){
        //
        if(formatted){
            return String.format("[%s] : %s", className, checkEtiquetteMode(message));
        }

        return checkEtiquetteMode(message);
    }

    private String checkEtiquetteMode(String message){
        //
        if(etiquetteMode){
            return "...";
        }

        return message;
    }

    public void sleep(int seconds){
        //
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isFormatted() {
        return formatted;
    }
    public void setFormatted(boolean formatted) {
        this.formatted = formatted;
    }
    public boolean isEtiquetteMode() {
        return etiquetteMode;
    }
    public void setEtiquetteMode(boolean etiquetteMode) {
        this.etiquetteMode = etiquetteMode;
    }
}

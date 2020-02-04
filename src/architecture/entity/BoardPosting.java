package architecture.entity;

import architecture.entity.blueprint.AutoId;
import architecture.util.DateUtil;

public class BoardPosting implements AutoId {
    //
    private String id;// key : (boardId:sequence)
    private String writerEmail;
    private String title;
    private String contents;
    private String writtenDate;

    private BoardPosting(){
        //
        this.writtenDate = new DateUtil().getCurrentDate();
    }

    public BoardPosting(String writerEmail, String title, String contents){
        //
        this();
        this.writerEmail = writerEmail;
        this.title = title;
        this.contents = contents;
    }

    public String getWriterEmail() {
        return writerEmail;
    }
    public void setWriterEmail(String writerEmail) {
        this.writerEmail = writerEmail;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
    public String getWrittenDate() {
        return writtenDate;
    }
    public void setWrittenDate(String writtenDate) {
        this.writtenDate = writtenDate;
    }
    @Override
    public String getAutoId() {
        //
        return id;
    }
    @Override
    public void setAutoId(String autoId) {
        //
        this.id = autoId;
    }
}

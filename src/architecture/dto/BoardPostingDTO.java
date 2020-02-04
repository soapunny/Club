package architecture.dto;

import architecture.entity.BoardPosting;
import architecture.util.DateUtil;

public class BoardPostingDTO {
    //
    private String id;// key : (boardId-sequence)
    private String writerEmail;
    private String title;
    private String contents;
    private String writtenDate;

    private BoardPostingDTO(){
        //
        this.writtenDate = new DateUtil().getCurrentDate();
    }

    public BoardPostingDTO(String title, String contents){
        //
        this();
        this.title = title;
        this.contents = contents;
        this.writtenDate = new DateUtil().getCurrentDate();
    }

    public BoardPostingDTO(String writerEmail, String title, String contents){
        //
        this();
        this.writerEmail = writerEmail;
        this.title = title;
        this.contents = contents;
        this.writtenDate = new DateUtil().getCurrentDate();
    }

    public BoardPostingDTO(BoardPosting boardPosting){
        //
        this.id = boardPosting.getAutoId();
        this.writerEmail = boardPosting.getWriterEmail();
        this.title = boardPosting.getTitle();
        this.contents = boardPosting.getContents();
        this.writtenDate = boardPosting.getWrittenDate();
    }

    public BoardPosting toBoardPosting(){
        //
        BoardPosting boardPosting = new BoardPosting(writerEmail, title, contents);
        boardPosting.setAutoId(id);
        boardPosting.setWrittenDate(writtenDate);

        return boardPosting;
    }

    @Override
    public String toString(){
        //
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("["+id+"]")
                     .append(" Writer's email : "+writerEmail)
                     .append(", Title : "+title)
                     .append(", Contents : "+contents)
                     .append(", Written Date : "+writtenDate);

        return stringBuilder.toString();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
}

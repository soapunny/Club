package architecture.layer.ui.console;

import architecture.dto.BoardDTO;
import architecture.dto.BoardPostingDTO;
import architecture.layer.logic.BusinessLogicDistributor;
import architecture.layer.logic.blueprint.BoardPostingBusiness;
import architecture.util.Broadcasting;
import architecture.util.InputUtil;
import architecture.util.SpeakingAt;

import java.util.List;
import java.util.Scanner;

public class BoardPostingConsole {
    //
    private Broadcasting broadcasting;
    private InputUtil inputUtil;

    private BoardDTO currentBoard;
    private BoardPostingBusiness boardPostingBusiness;

    public BoardPostingConsole(Scanner scanner) {
        //
        broadcasting = new Broadcasting(SpeakingAt.Left, this);
        inputUtil = new InputUtil(broadcasting, scanner);

        boardPostingBusiness = BusinessLogicDistributor.getInstance().getBoardPostingBusiness();
    }

    public boolean hasCurrentBoard() {
        //
        if(currentBoard == null){
            return false;
        }
        return true;
    }

    public void findBoard(){
        //
        String name = inputUtil.getValueOf("Board name to find(0. Board Posting Menu)");
        if(name.equals("0"))
            return;

        try {
            currentBoard = boardPostingBusiness.findBoard(name);
            broadcasting.broadcastln("Found board : "+currentBoard);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void register() {
        //
        if(!hasCurrentBoard()){
            broadcasting.broadcastln("Fine the board first!!");
            return;
        }

        String writerEmail = inputUtil.getValueOf("Writer's email(0. Board Posting Menu)");
        if(writerEmail.isEmpty() || writerEmail.equals("0"))
            return;
        String title = inputUtil.getValueOf("Title(0. Board Posting Menu)");
        if(title.isEmpty() || title.equals("0"))
            return;
        String contents = inputUtil.getValueOf("Contents(0. Board Posting Menu)");
        if(contents.isEmpty() || contents.equals("0"))
            return;

        try {
            BoardPostingDTO boardPostingDTO = new BoardPostingDTO(writerEmail, title, contents);
            BoardPostingDTO registeredPosting = boardPostingBusiness.register(currentBoard.getId(), boardPostingDTO);
            broadcasting.broadcastln("Register Success -> "+registeredPosting);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void findByTitle() {
        //
        if(!hasCurrentBoard()){
            broadcasting.broadcastln("Fine the board first!!");
            return;
        }

        String title = inputUtil.getValueOf("Title(0. Board Posting Menu)");
        if(title.isEmpty() || title.equals("0"))
            return;

        try {
            List<BoardPostingDTO> boardPostingDTOList = boardPostingBusiness.findByTitle(currentBoard.getId(), title);
            if (boardPostingDTOList.size() > 0) {
                broadcasting.broadcastln(boardPostingDTOList.size()+" rows are found!!");

                for (BoardPostingDTO postingDTO : boardPostingDTOList)
                    broadcasting.broadcastln(postingDTO.toString());
            }
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void findByEmail() {
        //
        if(!hasCurrentBoard()){
            broadcasting.broadcastln("Fine the board first!!");
            return;
        }

        String email = inputUtil.getValueOf("Writer's Email(0. Board Posting Menu)");
        if(email.isEmpty() || email.equals("0"))
            return;

        try {
            List<BoardPostingDTO> boardPostingDTOList = boardPostingBusiness.findByEmail(currentBoard.getId(), email);
            if (boardPostingDTOList.size() > 0) {
                broadcasting.broadcastln(boardPostingDTOList.size()+" rows are found!!");
                int cnt = 0;
                for (BoardPostingDTO postingDTO : boardPostingDTOList)
                    broadcasting.broadcastln(postingDTO.toString());
            }
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void showFindMenu(){
        //
        Outer:while(true) {
            broadcasting.broadcastln("");
            broadcasting.broadcastln("\t1. Find by title");
            broadcasting.broadcastln("\t2. Find by email");
            broadcasting.broadcastln("\t0. back to the Board Posting Menu");
            char number = inputUtil.getValueOf("\tChoose one").trim().charAt(0);
            switch (number){
                case '1': findByTitle();
                    break Outer;
                case '2': findByEmail();
                    break Outer;
                case '0':
                    return;
            }
        }
    }

    public void modify() {
        //
        if(!hasCurrentBoard()){
            broadcasting.broadcastln("Fine the board first!!");
            return;
        }

        showFindMenu();

        String sequence = inputUtil.getValueOf("Choose the posting's sequence(0. Board Posting Menu)").trim();
        if(sequence.isEmpty() || sequence.equals(0))
            return;
        String title = inputUtil.getValueOf("Title to modify(0. Board Posting Menu, Enter. No change)").trim();
        if(title.equals("0"))
            return;
        String contents = inputUtil.getValueOf("Contents to modify(0. Board Posting Menu, Enter. No change)").trim();
        if(title.equals("0"))
            return;

        try {
            BoardPostingDTO boardPostingDTO = new BoardPostingDTO(title, contents);
            boardPostingDTO.setId(sequence);
            boardPostingBusiness.modify(boardPostingDTO);
            broadcasting.broadcastln("Modify Success");
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void remove() {
        //
        if(!hasCurrentBoard()){
            broadcasting.broadcastln("Fine the board first!!");
            return;
        }

        showFindMenu();

        String sequence = inputUtil.getValueOf("Choose the posting's sequence(0. Board Posting Menu)").trim();
        if(sequence.isEmpty() || sequence.equals(0))
            return;

        String confirmStr = inputUtil.getValueOf("Do you really want to erase the posting data?(Y:yes, N:no)").trim().toLowerCase();
        if(confirmStr.equals("y") || confirmStr.equals("yes")){
            try{
                String removePostingName = boardPostingBusiness.remove(sequence);
                broadcasting.broadcastln("Remove Success -> "+removePostingName);
            }catch (Exception e){
                broadcasting.broadcastln(e.getMessage());
            }
        }
    }

    public BoardDTO getCurrentBoard() { return currentBoard;}
    public void setCurrentBoard(BoardDTO currentBoard) { this.currentBoard = currentBoard;}
}

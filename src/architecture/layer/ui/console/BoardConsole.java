package architecture.layer.ui.console;

import architecture.dto.BoardDTO;
import architecture.layer.logic.BusinessLogicDistributor;
import architecture.layer.logic.blueprint.BoardBusiness;
import architecture.util.Broadcasting;
import architecture.util.InputUtil;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class BoardConsole {
    //
    private Broadcasting broadcasting;
    private InputUtil inputUtil;

    private BoardBusiness boardBusiness;

    public BoardConsole(Scanner scanner) {
        //
        broadcasting = new Broadcasting(SpeakingAt.Left, this);
        inputUtil = new InputUtil(broadcasting, scanner);

        boardBusiness = BusinessLogicDistributor.getInstance().getBoardBusiness();
    }

    public void register() {
        //
        String clubName = inputUtil.getValueOf("Select your club(0. Board menu)").trim();//club 이름 확인
        if(clubName.isEmpty() || clubName.equals("0"))
            return;
        String boardName = inputUtil.getValueOf("Board name to register(0. Board menu)").trim();//board 이름은 중복확인
        if(boardName.isEmpty() || boardName.equals("0"))
            return;
        String adminEmail = inputUtil.getValueOf("Admin email to register(0. Board menu)").trim();//Admin email은 ClubMember에 포함되어 있는지 확인
        if(adminEmail.isEmpty() || adminEmail.equals("0"))
            return;

        try{
            BoardDTO registeredBoard = boardBusiness.register(clubName, boardName, adminEmail);
            broadcasting.broadcastln("Register success -> "+registeredBoard);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void findByName() {
        //
        String name = inputUtil.getValueOf("Board name to find a board(0. Board menu)").trim();
        if(name.equals("0"))
            return;

        try {
            BoardDTO foundBoard = boardBusiness.findByName(name);
            broadcasting.broadcastln("Found board -> "+foundBoard);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void modify() {
        //
        String name = inputUtil.getValueOf("Board name you want to modify(0. Board menu)").trim();
        if(name.equals("0"))
            return;

        String adminEmail = inputUtil.getValueOf("Board admin email to modify(0. Board menu, Enter. No change)").trim();
        if(adminEmail.equals("0"))
            return;
        String foundationDate = inputUtil.getValueOf("Foundation date to modify(0. Board menu, Enter. No change)").trim();
        if(foundationDate.equals("0"))
            return;

        BoardDTO boardDTO = new BoardDTO(name, adminEmail);
        boardDTO.setFoundationDay(foundationDate);

        try {
            boardBusiness.modify(boardDTO);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void remove() {
        //
        String name = inputUtil.getValueOf("Board name you want to remove(0. Board menu)").trim();
        if(name.equals("0"))
            return;

        String confirmStr = inputUtil.getValueOf("Your data will be removed. Do you want to progress(Y:yes, N:no)").trim().toLowerCase();
        if(confirmStr.equals("y") || confirmStr.equals("yes")){
            try {
                String removedBoardName = boardBusiness.remove(name);
                broadcasting.broadcastln(removedBoardName+" board is removed!!");
            }catch (Exception e){
                broadcasting.broadcastln(e.getMessage());
            }
        }
    }
}

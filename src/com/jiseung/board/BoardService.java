package com.jiseung.board;

import java.util.ArrayList;

public class BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public ArrayList<BoardDTO> BoardList() throws Exception {
		
		ArrayList<BoardDTO> ar = boardDAO.boardList();
		
		return ar;
		
	}

}

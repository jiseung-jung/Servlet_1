package com.jiseung.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jiseung.util.DBConnector;

public class BoardDAO {
	
	private DBConnector dbConnector;
	
	public BoardDAO() {
			dbConnector = new DBConnector();
	}
	
	public ArrayList<BoardDTO> boardList() throws Exception {
		
		Connection con = dbConnector.getConnect();
		
		String sql ="select * from board order by num desc";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<BoardDTO> ar = new ArrayList<>();
		
		while(rs.next()) {
			
			BoardDTO boardDTO = new BoardDTO();
			
			boardDTO.setNum(rs.getLong("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setRegdate(rs.getDate("regdate"));
			boardDTO.setHit(rs.getLong("hit"));
			
			ar.add(boardDTO);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	
	

}

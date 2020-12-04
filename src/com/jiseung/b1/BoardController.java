package com.jiseung.b1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiseung.board.BoardDTO;
import com.jiseung.board.BoardService;

/**
 * Servlet implementation class boardController
 */
@WebServlet("/boardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        boardService = new BoardService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		String path = request.getRequestURI();
		System.out.println(path);
		
		path = path.substring(path.lastIndexOf("/"));
		String info = "";
		
		if(path.equals("/boardList.board")) {
			info = "./boardList.jsp";
		}
		
		ArrayList<BoardDTO> ar = null;
		
		try {
			ar = boardService.BoardList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", ar);

		
		RequestDispatcher view = request.getRequestDispatcher(info);
		view.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

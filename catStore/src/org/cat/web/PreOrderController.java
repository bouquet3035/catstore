package org.cat.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cat.domain.PreOrderDTO;

/**
 * Servlet implementation class PreOrderController
 */
@WebServlet("/preOrder")
public class PreOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("preOrder...........");
		
		System.out.println(Arrays.toString(request.getParameterValues("ino")));
		System.out.println(Arrays.toString(request.getParameterValues("amount")));
		
		String[] arr1 = request.getParameterValues("ino");
		String[] arr2 = request.getParameterValues("amount");

		List<PreOrderDTO> list = new ArrayList<>();
		
		for(int i = 0; i <arr1.length; i++ ) {
			if(arr2[i].equals("0")) {
				continue;
			}
			list.add(new PreOrderDTO(arr1[i],Integer.parseInt(arr2[i])));
			
		}
		
		request.setAttribute("preOrder", list);
		
		request.getRequestDispatcher("/WEB-INF/preOrder.jsp")
		.forward(request, response);
	}

}

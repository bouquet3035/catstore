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

import org.cat.dao.OrderDAO;
import org.cat.domain.PreOrderDTO;


/**
 * Servlet implementation class FixOrderController
 */
@WebServlet("/fixOrder")
public class FixOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FixOrderController() {
        super();
        dao = new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] inoArr = request.getParameterValues("ino");
		String[] amountArr = request.getParameterValues("amount");

		System.out.println(Arrays.toString(inoArr));
		System.out.println(Arrays.toString(amountArr));
		

		List<PreOrderDTO> list = new ArrayList<>();

		for (int i = 0; i < inoArr.length; i++) {
			list.add(new PreOrderDTO(inoArr[i], Integer.parseInt(amountArr[i])));
		}

		try {
			int orderNo = dao.insert(list);

			request.setAttribute("orderNo", orderNo);
			request.setAttribute("orderList", list);

			request.getRequestDispatcher("/WEB-INF/orderResult.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}

package org.cat.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.cat.dao.ItemDAO;
import org.cat.domain.ItemDTO;

/**
 * Application Lifecycle Listener implementation class StoreItemListener
 *
 */
@WebListener
public class StoreItemListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public StoreItemListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 

    	ServletContext ctx = sce.getServletContext();
    	
    	ctx.setAttribute("storeName",  "기동전사 유니콘 냥이");
    	
    	ItemDAO dao = new ItemDAO();
    	
    	try {
    		List<ItemDTO> list = dao.getList();
			ctx.setAttribute("itemList", list);
			
			
			
			Map<String, ItemDTO> map = new HashMap<>();
			
			list.forEach(Item -> map.put(""+Item.getIno(), Item));
			
			ctx.setAttribute("itemMap", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
 
	
}

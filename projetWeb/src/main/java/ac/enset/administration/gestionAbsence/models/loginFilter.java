package ac.enset.administration.gestionAbsence.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ac.enset.administration.gestionAbsence.bean;

public class loginFilter implements Filter {

	

	@Override
	public void doFilter(ServletRequest reqe, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) reqe;
		HttpServletResponse resp= (HttpServletResponse) res;
		bean session = (bean) req.getSession().getAttribute("bean1");
		String url = req.getRequestURI();
		
		if(session != null){
			
			if(session.isLogin){
				arg2.doFilter(reqe, res);
			}else {
				req.getSession().removeAttribute("bean1");
				req.getRequestDispatcher( "/login.xhtml" ).forward( reqe, res );
			}
			
		}else {
				req.getSession().removeAttribute("bean1");
				req.getRequestDispatcher( "/login.xhtml" ).forward( reqe, res );
			
		}
      
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

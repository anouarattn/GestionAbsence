package ac.enset.administration.gestionAbsence.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.sasl.AuthenticationException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.omnifaces.util.Faces;

import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;

/**
 *
 * @author user
 */
@SessionScoped
@Named
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IAbsenceLocal metier;

	@PostConstruct
	public void init() {
		// DefaultPasswordService passService = new DefaultPasswordService();
		// String pass = new String("stud");
		// // DefaultHashService service = new DefaultHashService();
		// // Builder b =new HashRequest.Builder();
		// // b.setSource(pass);
		//
		// // Hash hash = service.computeHash(b.build());
		// User user = new User();
		// user.setName("stud");
		// user.setPassword(passService.encryptPassword(pass));
		// user.setUsername("stud");
		// metier.add(user);
	}

	private static final String HOME_URL = "index.xhtml";

	private String username;
	private String password;
	private boolean remember;

	public void submit() throws IOException {
		try {

			SecurityUtils.getSubject().login(
					new UsernamePasswordToken(username, password, remember));
			SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces
					.getRequest());
			Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl()
					: HOME_URL);

		} catch (AuthenticationException | IncorrectCredentialsException
				| UnknownAccountException e) {
			e.printStackTrace();
			// Messages.addGlobalError("Invalid Username/Password");

		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public void loggout() {
		if (SecurityUtils.getSubject().isAuthenticated()) {
			SecurityUtils.getSubject().logout();
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
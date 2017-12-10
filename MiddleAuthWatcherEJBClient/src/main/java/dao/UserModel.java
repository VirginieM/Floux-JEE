package dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "user")
public class UserModel implements Serializable {

	private static final long serialVersionUID = -7504807414809447803L;
	
	@Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String lastName;
	
    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String firstName;
	
    @NotNull
    @Size(min = 1, max = 25)
	private String login;
	
    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String pwd;
	
    @NotNull
	private Role role;
	
	private Boolean validAuth;

	public Boolean getValidAuth() {
		return validAuth;
	}

	public void setValidAuth(Boolean validAuth) {
		this.validAuth = validAuth;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserModel() {
	
	}

    public UserModel(String userLogin, boolean validAuth, Role role) {
        this.login = userLogin;
        this.validAuth = validAuth;
        this.role = role;
    }

	public UserModel(String login, String mdp) {
		  this.login = login;
	      this.validAuth = true;
	      this.role = null;
	      this.firstName = null;
	      this.lastName = null;
	}
	
	
	
}

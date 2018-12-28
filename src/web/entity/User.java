package web.entity;


/**
* @ClassName: User
* @Description: 用户实体类
* @author 李勇超
* @date 2018年12月27日下午5:20:43
*
*/
public class User {
	private int id;
	private String username;
	private String pwd;
	private String nickname;
	private String email;
	
	public User() {}

	public User(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}
	
	public User(String username, String pwd, String nickname, String email) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.nickname = nickname;
		this.email = email;
	}

	public User(int id, String username, String pwd, String nickname, String email) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.nickname = nickname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}

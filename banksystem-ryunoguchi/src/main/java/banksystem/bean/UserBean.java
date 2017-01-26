package banksystem.bean;

public class UserBean {
	private String userid;
	private String username;
	private String userpassword;

	public UserBean(){

	}

	public UserBean(String userid, String username,String userpassword){
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
	}

	public String getUserId(){
		return userid;
	}
	public void setUserId(String userid){
		this.userid = userid;
	}
	public String getUserName(){
		return username;
	}
	public void setUserName(String username){
		this.username = username;
	}
	public String getUserpassword(){
		return userpassword;
	}
	public void setUserpassword(String userpassword){
		this.userpassword = userpassword;
	}

	@Override
	public int hashCode(){
		return this.userid.hashCode();
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof UserBean){
			return this.equals((UserBean)obj);
		}
		else
		{
			return false;
		}
	}

	public boolean equals(UserBean obj){
		if(this == obj){
			return true;
		}
		else
		{
			if(this.userid.equals(obj.userid) && this.username.equals(obj.username)
					&& this.userpassword.equals(obj.userpassword))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
}

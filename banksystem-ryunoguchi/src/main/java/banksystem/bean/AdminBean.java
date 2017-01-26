package banksystem.bean;

public class AdminBean {
	private String adminid;
	private String adminname;
	private String adminpassword;

	public AdminBean(){

	}

	public AdminBean(String adminid, String adminname, String adminpassword){
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}

	public String getAdminId(){
		return adminid;
	}
	public void setAdminId(String adminid){
		this.adminid = adminid;
	}
	public String getAdminName(){
		return adminname;
	}
	public void setAdminName(String adminname){
		this.adminname = adminname;
	}
	public String getAdminPassword(){
		return adminpassword;
	}
	public void setAdminPassword(String adminpassword){
		this.adminpassword = adminpassword;
	}

	@Override
	public int hashCode()
	{
		return this.adminid.hashCode();
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof AdminBean)
		{
			return obj.equals((AdminBean)obj);
		}
		else
		{
			return false;
		}
	}

	public boolean equals(AdminBean obj){
		if(this == obj){
			return true;
		}
		else
		{
			if(this.adminid.equals(obj.adminid) && this.adminname.equals(obj.adminname)
					&& this.adminpassword.equals(obj.adminpassword))
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

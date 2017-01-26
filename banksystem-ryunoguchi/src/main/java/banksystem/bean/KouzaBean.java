package banksystem.bean;

public class KouzaBean {
	private String userid;
	private String kouzasyubetsu;
	private String kouzanumber;
	private String kouzazandaka;

	public KouzaBean(){

	}

	public KouzaBean(String userid, String kouzasyubetsu, String kouzanumber,
			String kouzazandaka){
		this.userid = userid;
		this.kouzasyubetsu = kouzasyubetsu;
		this.kouzanumber = kouzanumber;
		this.kouzazandaka = kouzazandaka;
	}

	public String getUserId(){
		return userid;
	}
	public void setUserId(String userid){
		this.userid = userid;
	}
	public String getKouzaSyubetsu(){
		return kouzasyubetsu;
	}

	public void setKouzaSyubetsu(String kouzasyubetsu){
		this.kouzasyubetsu = kouzasyubetsu;
	}

	public String getKouzaNumber(){
		return kouzanumber;
	}
	public void setKouzaNumber(String kouzanumber){
		this.kouzanumber = kouzanumber;
	}
	public String getKouzaZandaka(){
		return kouzazandaka;
	}
	public void setKouzaZandaka(String kouzazandaka){
		this.kouzazandaka = kouzazandaka;
	}

	@Override
	public int hashCode(){
		return userid.hashCode();
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof KouzaBean){
			return obj.equals((KouzaBean)obj);
		}
		else
		{
			return false;
		}
	}

	public boolean equals(KouzaBean obj)
	{
		if(this == obj){
			return true;
		}
		else
		{
			if(this.userid.equals(obj.userid) && this.kouzasyubetsu.equals(obj.kouzasyubetsu)
					&& this.kouzanumber.equals(obj.kouzanumber) && this.kouzazandaka.equals(obj.kouzazandaka))
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

package model;

import java.io.Serializable;
import java.util.HashMap;

public class LoginNameAndPassword implements Serializable {
	private static final long serialVersionUID = 1L;

	//so if you put an id of the employee you can find the user id and password easly as well as if i have an id i can find the employee easly 
	private HashMap<String,String>loginInfo=new HashMap<String,String>();//hashmap that has all the user name and password
	private HashMap<String,String>connectID_UserId=new HashMap<String,String>();//connect between id ->USER id 
	private HashMap<String,String>connectUserId_Id=new HashMap<String,String>();//connect between USER id -> id 


	public LoginNameAndPassword() {
		this.loginInfo.put("admin", "admin");

		//just so we cannot put a new userid by admin
		this.connectID_UserId.put("admin", "admin");
		this.connectUserId_Id.put("admin", "admin");
	}

	//
	public HashMap<String, String> getLoginInfo() {
		return loginInfo;
	}

	//sets new user name and password 
	public boolean setLoginInfo(String userId,String password,String Id) {
		if(userId==null)
			return false ;
		
		if(!loginInfo.containsKey(userId))
		{
			this.loginInfo.put(userId, password);
			this.connectID_UserId.put(Id,userId);
			this.connectUserId_Id.put(userId, Id);
			return true ;

		}
		return false ;		
	}
	
	//if we have only the user id
	
	public boolean removeLoginInfoByUserId(String userId) {
		if(userId==null)
			return false ;
		if (!userId.equals("admin"))
		{
			if(loginInfo.containsKey(userId))
			{
				this.loginInfo.remove(userId);
				String Id=connectUserId_Id.get(userId);
				this.connectUserId_Id.remove(userId);
				this.connectID_UserId.remove(Id);
				return true;
			}
		}
		return false;
	}

	//if we have the Id of the employee 
	public boolean removeLoginInfoByID(String Id) {
		if(Id==null)
			return false ;
		if (!Id.equals("admin"))
		{
			if(connectID_UserId.containsKey(Id))
			{
				String userId=connectID_UserId.get(Id);//find the user id
				this.loginInfo.remove(userId);//remove the user id from the log info
				this.connectID_UserId.remove(Id);//remove it from the id->user id
				this.connectUserId_Id.remove(userId);//and from the user id->id
				return true;
			}
		return false;//if the id does not exist
		}
		return false;//if its admin
	}

	
	public String findEmployeeOfUserId(String userId) {
		if(userId==null)
			return "";//if the user id is null
		if (!userId.equals("admin"))
		{
			if(loginInfo.containsKey(userId))
			{
				
				return this.connectUserId_Id.get(userId);

			}
			else return "";//if the user id does not exsit 
		}
		return "";//if its admin
				
	} 
	
	//we have the id of the employee we need to find the user id 
	public String findUserIdOfId(String id) {
		if(id==null)
			return "";//if the user id is null
		if (!id.equals("admin"))
		{
			if(connectID_UserId.containsKey(id))
			{
				
				return this.connectID_UserId.get(id);//return user id 

			}
			else return "";//if the id does not exsit 
		}
		return "";//if its admin
				
	} 
	
	

}

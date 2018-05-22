package Hostel;

public class Room{
	private int room_id;
	protected String room_name;
	protected String room_img;
	protected String room_describe;	
	protected int room_peoplenum;
	private int room_weekdayprice;
	private int room_holidayprice;

public Room(){
		
	}
public Room(int room_id,String room_name,String room_img,String room_describe,int room_peoplenum,int room_weekdayprice,int room_holidayprice){
		this.room_id = room_id;
		this.room_name = room_name;
		this.room_img = room_img;
		this.room_describe = room_describe;
		this.room_weekdayprice = room_weekdayprice;
		this.room_holidayprice = room_holidayprice;
		this.room_peoplenum = room_peoplenum;
	}

		public int getroom_id(){
			return room_id;
		}
		public void setroom_id(int room_id)
	    {
	         this.room_id = room_id;
	    }
		public int getroom_weekdayprice(){
			return room_weekdayprice;
		}
		public void setroom_weekdayprice(int room_weekdayprice)
	    {
	         this.room_weekdayprice = room_weekdayprice;
	    }
		public int getroom_holidayprice(){
			return room_holidayprice;
		}
		public void setroom_holidayprice(int room_holidayprice)
	    {
	         this.room_holidayprice = room_holidayprice;
	    }
		public int getroom_peoplenum(){
			return room_peoplenum;
		}
		public void setroom_peoplenum(int room_peoplenum)
	    {
	         this.room_peoplenum = room_peoplenum;
	    }
		public String getroom_name(){
			return room_name;
		}
		public void setroom_name(String room_name)
	    {
	         this.room_name = room_name;
	    }
		public String getroom_img(){
			return room_img;
		}
		public String getroom_describe(){
			return room_describe;
		}
		
		public Object get(int attr){
	    	switch(attr){
	    	case 0:
	    		return room_id;
	    	case 1:
	    		return room_name;	
	    	case 2:
	    		return room_img;
	    	case 3:
	    		return room_describe;
	    	case 4:
	    		return room_peoplenum;
	    	case 5:
	    		return room_weekdayprice;
	    	case 6:
	    		return room_holidayprice;	
	    	default:
	    		return "";
	    	}
	    }
}

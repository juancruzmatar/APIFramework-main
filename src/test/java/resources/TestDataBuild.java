package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	
	
	public AddPlace addPlacePayLoad(String name, String language, String address)
	{
		AddPlace p =new AddPlace();
		p.setUserId(34);
		p.setBody("This is test");
		p.setTitle("This tiltle test");

		return p;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}

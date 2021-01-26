package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	AddPlaceAPI("/Posts"),
	getPlaceAPI("/Posts"),
	deletePlaceAPI("/Posts");
//	updatePlaceAPI("/Posts");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}

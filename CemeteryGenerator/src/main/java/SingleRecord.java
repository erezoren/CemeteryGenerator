public class SingleRecord {
	
	private String fullName;
	private String tumbImage;
	private String faceImage;
	private int id;
	
	public SingleRecord(int id, String fullName, String tumbImage, String faceImage) {
		super();
		this.fullName = fullName;
		this.tumbImage = tumbImage;
		this.faceImage = faceImage;
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getTumbImage() {
		return tumbImage;
	}
	
	public void setTumbImage(String tumbImage) {
		this.tumbImage = tumbImage;
	}
	
	public String getFaceImage() {
		return faceImage;
	}
	
	public void setFaceImage(String faceImage) {
		this.faceImage = faceImage;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "SingleRecord [fullName=" + fullName + ", tumbImage=" + tumbImage + ", faceImage=" + faceImage + "]";
	}
	
}

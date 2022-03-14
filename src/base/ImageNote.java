package base;

import java.io.File;

public class ImageNote extends Note {
	File image;
	
	private static final long serialVersionUID = 1L;
	
	public ImageNote(String title) {
		super(title);
//		this.image = new File(title);
	}

}

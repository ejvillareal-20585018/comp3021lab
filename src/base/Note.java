package base;

import java.util.Objects;
import java.util.Date;

public class Note {
	@SuppressWarnings("unused")
	private Date date;
	private String title;

	public Note(String title) {
		this.title = title;
		date = new Date(System.currentTimeMillis());

	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Note other = (Note) obj;
		return Objects.equals(title, other.title);
	}

}

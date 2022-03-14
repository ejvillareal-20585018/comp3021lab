package base;

import java.util.Objects;
import java.util.Date;

public class Note implements Comparable<Note>, java.io.Serializable{
	private Date date;
	private String title;
	
	private static final long serialVersionUID = 1L;
	
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
		if (!(obj instanceof Note))
			return false;
		Note other = (Note) obj;
		return Objects.equals(title, other.title);
	}
	
	@Override
	public int compareTo(Note o) {
		if (date.compareTo(o.date) < 0)
			return 1;
		else if (date.compareTo(o.date) > 0)
			return -1;
		else
			return 0;
	}
	
	public String toString() {
		return date.toString() + "\t" + title;
	}

}

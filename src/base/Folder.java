package base;

import java.util.ArrayList;

public class Folder {
	private ArrayList<Note> notes;
	private String name;

	public Folder(String name) {
		this.name = new String(name);
		notes = new ArrayList<Note>();
	}

	public void addNote(Note note) {
		notes.add(note);
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

	public String toString() {
		int nText = 0;
		int nImage = 0;
		for (Note i : notes) {
			if (i instanceof ImageNote) {
				nImage++;
			}

			else {
				nText++;
			}
		}

		// TODO
		return this.getName() + ":" + nText + ":" + nImage;

	}

	public boolean equals(Folder folder) {
		return (this.getName().equals(folder.getName()));
	}
}

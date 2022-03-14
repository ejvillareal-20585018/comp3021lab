package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Folder implements Comparable<Folder>, java.io.Serializable {
	private ArrayList<Note> notes;
	private String name;
	
	private static final long serialVersionUID = 1L;

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
	
	@Override
	public int compareTo(Folder o) {
		if (name.compareTo(o.getName()) > 0)
			return 1;
		else if (name.compareTo(o.getName()) < 0)
			return -1;
		else
			return 0;
		
	}
	
	public void sortNotes() {
		Collections.sort(notes);
	}
	
	public List<Note> searchNotes(String keywords){
		List<Note> noteArray = new ArrayList<Note>();
		
		ArrayList<ArrayList<String>> doubleArray = new ArrayList<ArrayList<String>>();
		String[] keys = keywords.toLowerCase().split(" ",0);
		
		for(int i = 0; i < keys.length ; i++) {
			if(keys[i].compareTo("or") == 0) {
				i++;
				doubleArray.get(doubleArray.size()-1).add(keys[i]);
			}
			
			else {
				ArrayList<String> single = new ArrayList<String>();
				single.add(keys[i]);
				doubleArray.add(single);
			}
		}
			
		for(Note note : notes) {
			String comparison = note.getTitle();
			if(note instanceof TextNote) {
				comparison += " "; 
				comparison += ((TextNote)note).content;
			}
			comparison = comparison.toLowerCase();
			
			boolean allExists = true;
			for(ArrayList<String> array : doubleArray) {
				boolean exists = false;
				for(String keyWord : array) {
					if(comparison.contains(keyWord)) {
						exists = true;
					}
				}
				
				if(exists == false) {
					allExists = false;
					break;
				}
			}
			
			if (allExists == true) {
				noteArray.add(note);
			}
		}
			
		return noteArray;
	}
}
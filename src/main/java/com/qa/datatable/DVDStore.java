package com.qa.datatable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qa.datatable.models.DVD;

public class DVDStore{

	private Map<Integer, DVD> store;

	public DVDStore(){
		this.store = new HashMap<Integer, DVD>();
	}

	public void addDVD(int id, String title, int year, String actor){}

	public void addDVD(String title, int year, String actor){}

	public void addDVD(DVD DVD){}

	public DVD getDVD(int id){
		return null;
	}

	public List<String> getDVDs(){
		return null;
	}

	public void updateDVD(int id, String title, int year, String actor){}

	public void deleteDVD(int id){}

}

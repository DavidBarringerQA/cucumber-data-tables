package com.qa.datatable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import com.qa.datatable.models.DVD;

public class DVDStore{

	private Map<Integer, DVD> store;

	public DVDStore(){
		this.store = new HashMap<Integer, DVD>();
	}

	public void addDVD(int id, String title, int year, String actor){
		if(!store.containsKey(id)){
			store.put(id, new DVD(id, title, year, actor));
		}
	}

	public void addDVD(String title, int year, String actor){
		OptionalInt idOpt = store.keySet()
			.stream()
			.mapToInt(x -> (int)x)
			.max();
		if(idOpt.isEmpty()){
			store.put(1, new DVD(1, title, year, actor));
		} else {
			store.put(idOpt.getAsInt() + 1, new DVD(idOpt.getAsInt(), title, year, actor));
		}
	}

	public void addDVD(DVD DVD){
		if (DVD.getId() == 0){
			addDVD(DVD.getTitle(), DVD.getYear(), DVD.getActor());
		}else if(!store.containsKey(DVD.getId())){
			store.put(DVD.getId(), DVD);
		}
	}

	public DVD getDVD(int id){
		return store.get(id);
	}

	public List<String> getDVDs(){
	  return store.values()
			.stream()
			.map(x -> x.toString())
			.collect(Collectors.toList());
	}

	public void updateDVD(int id, String title, int year, String actor){
		if(store.containsKey(id)){
			store.put(id, new DVD(id, title, year, actor));
		}
	}

	public void deleteDVD(int id){
		if(store.containsKey(id)){
			store.remove(id);
		}
	}

}

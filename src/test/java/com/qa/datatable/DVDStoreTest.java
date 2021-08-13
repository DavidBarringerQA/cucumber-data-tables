package com.qa.datatable;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import com.qa.datatable.models.DVD;
import org.junit.Before;
import org.junit.Test;

public class DVDStoreTest{

	private DVDStore store;
	private final String expectedNew = "New Test - 2021 - Bactor";

	@Before
	public void setup(){
		store = new DVDStore();
		store.addDVD(1, "Test DVD", 2012, "Actor");
	}

	@Test
	public void addDVDWithIDTest(){
		store.addDVD(2, "New Test", 2021, "Bactor");
		String actual = store.getDVD(2).toString();
		assertEquals(expectedNew, actual);
	}

	@Test
	public void addDVDNoIDTest(){
		store.addDVD("New Test", 2021, "Bactor");
		String actual = store.getDVD(2).toString();
		assertEquals(expectedNew, actual);
	}

	@Test
	public void addDVDObjectIDTest(){
		store.addDVD(new DVD(2, "New Test", 2021, "Bactor"));
		String actual = store.getDVD(2).toString();
		assertEquals(expectedNew, actual);
	}

	@Test
	public void getDVDsTest(){
		List<String> expected = new ArrayList<>();
		expected.add("Test DVD - 2012 - Actor");
		assertEquals(expected, store.getDVDs());
	}

	@Test
	public void updateDVDTest(){
		store.updateDVD(1, "Updated DVD", 2000, "Actor");
		String expected = "Updated DVD - 2000 - Actor";
		String actual = store.getDVD(1).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void deleteDVDIDTest(){
		store.deleteDVD(1);
		List<String> expected = new ArrayList<>();
		List<String> actual = store.getDVDs();
		assertEquals(expected, actual);
	}
}

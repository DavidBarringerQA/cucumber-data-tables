package com.qa.datatable;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Map;
import com.qa.datatable.models.DVD;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DVDStoreStepDefinitions{

	DVDStore store;
	List<DVD> DVDs;
	List<String> expectedResults;
	int id;
	
	@Given("a dvd store")
	public void aDvdStore() {
		store = new DVDStore();	
	}

	@DataTableType
	public DVD toDVD(Map<String, String> row) {
		return new DVD(row.get("Title"), Integer.valueOf(row.get("Year")), row.get("Actor"));
	}

	@Given("the following new DVDs")
	public void theFollowingNewDVDs(List<DVD> input) {
		DVDs = input;
	}

	@Given("the expected outputs")
	public void theExpectedOutputs(List<String> input) {
		expectedResults = input;
	}

	@When("the new DVDs are added to the store")
	public void theNewDVDsAreAddedToTheStore() {
		for(DVD DVD : DVDs){
			store.addDVD(DVD);
		}
	}

	@Then("the get dvd list request should return the expected outputs")
	public void theGetDvdListRequestShouldReturnTheExpectedOutput() {
    assertEquals(expectedResults, store.getDVDs());
	}
	
	@Given("the following DVDs in the store")
	public void theFollowingDVDsInTheStore(List<DVD> input) {
    DVDs = input;
	}

	@Given("the dvd to remove with the id {int}")
	public void theDvdToRemoveWithTheId(int id) {
		this.id = id;
	}

	@When("the dvd is removed")
	public void theDvdIsRemoved() {
		store.deleteDVD(id);
	}
}

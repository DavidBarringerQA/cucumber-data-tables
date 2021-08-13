package com.qa.datatable.models;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DVDTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(DVD.class).verify();
	}
}

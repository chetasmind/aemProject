package com.chetasmind.tutor.core.models.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.chetasmind.tutor.core.models.Author;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class AuthorImplTest {

	private final AemContext aemContext = new AemContext();
	
	private Author author;
	
	@BeforeEach
	void setUp() {
		 
		aemContext.addModelsForClasses(AuthorImpl.class);
		aemContext.load().json("/com/chetasmind/tutor/core/models/impl/Author.json","/myComp");
 
	}
	
	@Test
	void testGetBooks() {

		aemContext.currentResource("/myComp/author");
		author = aemContext.request().adaptTo(Author.class);
		String exp="AEM";
		String actual = author.getFirstName();
		assertEquals(exp, actual);
		
	}

//	@Test
//	void testGetFirstName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetLastName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetIsProfessor() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetPageTitle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetRequestAttribute() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetHomePageName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetLastModifiedBy() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAuthorName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetBookDetailsWithMap() {
//		fail("Not yet implemented");
//	}

}

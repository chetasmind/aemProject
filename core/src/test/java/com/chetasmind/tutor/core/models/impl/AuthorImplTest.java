package com.chetasmind.tutor.core.models.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.sling.api.resource.Resource;

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
		aemContext.load().json("/com/chetasmind/tutor/core/models/impl/Page.json","/page");
		aemContext.load().json("/com/chetasmind/tutor/core/models/impl/Resource.json","/resource");
 
	}
	
	@Test
	void testGetBooks() {

		aemContext.currentResource("/myComp/author");
        author=aemContext.request().adaptTo(Author.class);
        assertEquals(4,author.getBooks().size());
        assertEquals("JAVA",author.getBooks().get(0));
        assertEquals("DS",author.getBooks().get(2));
		 
	}
	
	 @Test
	 void getBooksWithNull() {
	        aemContext.currentResource("/myComp/author-empty-books");
	        author=aemContext.request().adaptTo(Author.class);
	        assertEquals(0,author.getBooks().size());
	 }
	 
	 @Test
	    void getFirstName() {
	        aemContext.currentResource("/myComp/author");
	        author=aemContext.request().adaptTo(Author.class);
	        final String expected="AEM";
	        String actual=author.getFirstName();
	        assertEquals(expected,actual);
	    }

	    @Test
	    void getLastName() {
	        aemContext.currentResource("/myComp/author");
	        author=aemContext.request().adaptTo(Author.class);
	        final String expected="GEEKS";
	        String actual=author.getLastName();
	        assertEquals(expected,actual);
	    }
	    
	   @Test
	   void testGetPageTitle() {
		   aemContext.currentPage("/page/currentPage");
	        author=aemContext.request().adaptTo(Author.class);
	        assertEquals("Author Bio",author.getPageTitle());
		}
	   
	 @Test
	 void testGetRequestAttribute() {
		 
		 aemContext.request().setAttribute("rAttribute","TestAttribute");
	     author=aemContext.request().adaptTo(Author.class);
	     assertEquals("TestAttribute",author.getRequestAttribute());
		}   
	 
	 @Test
	  void testGetHomePageName() {
		 
		 Resource resource=aemContext.currentResource("/resource/resourcePage");
	        AuthorImpl authorImpl=aemContext.registerService(new AuthorImpl());
	        authorImpl.resourcePage=resource;
	        assertEquals("resourcePage",authorImpl.getHomePageName());
	  } 
	 
	 @Test
	  void testAuthorName() {
		 
		 assertEquals("AEM GEEKS", aemContext.registerService(new AuthorImpl()).authorName());
		 //Reason: authorName method is not declared in interface.
		}	
	 
	 @Test
	  void testGetLastModifiedBy() {
			 aemContext.currentResource("/myComp/author");
		     author=aemContext.request().adaptTo(Author.class);
		     assertEquals("admin",author.getLastModifiedBy());
		}
	 
	 @Test
	    void getBookDetailsWithMap() {
	        aemContext.currentResource("/myComp/author");
	        author=aemContext.request().adaptTo(Author.class);
	        assertEquals(2,author.getBookDetailsWithMap().size());
	        assertEquals("2000",author.getBookDetailsWithMap().get(0).get("publishyear"));
	        assertEquals("Subject 1",author.getBookDetailsWithMap().get(0).get("booksubject"));
	    }
	 
	 @Test
	    void getIsProfessor() {
	        aemContext.currentResource("/myComp/author");
	        author=aemContext.request().adaptTo(Author.class);
	        assertEquals(true,author.getIsProfessor());
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

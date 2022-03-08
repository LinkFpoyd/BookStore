package pOhjelmointi.BookstoreLeevi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import pOhjelmointi.BookstoreLeevi.web.BookController;
import pOhjelmointi.BookstoreLeevi.web.RestBookController;

@SpringBootTest
class BookstoreLeeviApplicationTests {
	
	@Autowired 
	private BookController bcontroller;
	
	@Autowired
	private RestBookController rbcontroller;

	@Test
	void contextLoads() throws Exception {
		assertThat(bcontroller).isNotNull();
		assertThat(rbcontroller).isNotNull();
	}
	
	

}

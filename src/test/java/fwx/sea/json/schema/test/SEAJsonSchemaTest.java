package fwx.sea.json.schema.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.ValidationException;
import net.jimblackler.jsonschemafriend.Validator;

class SEAJsonSchemaTest {
	
	private SchemaStore schemaStore;
	
	private Schema schema;
	
	private Validator validator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		schemaStore = new SchemaStore();
//	   schema = schemaStore.loadSchema(SEAJsonSchemaTest.class.getResource("/Filter.json"));
	   schema = schemaStore.loadSchema(SEAJsonSchemaTest.class.getResource("/SingleFilter.json"));
//	   schemaStore.loadSchema(SEAJsonSchemaTest.class.getResource("/GroupFilter.json"));
	   validator = new Validator();
	   
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		try {
			validator.validate(schema, SEAJsonSchemaTest.class.getResourceAsStream("/test2.json"));
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

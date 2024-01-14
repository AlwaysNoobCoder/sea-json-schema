package fwx.sea.json.schema.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;

class SEAJsonSchemaTest extends BaseTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		try {
//			JsonNode schemaNode = super.getJsonNodeFromClasspath("/Filter.json");
			JsonSchema schema = super.getJsonSchemaFromClasspath("/Filter.json");
			JsonNode sampleNode = super.getJsonNodeFromClasspath("/test2.json");
			schema.initializeValidators(); 
			Set<ValidationMessage> errors = schema.validate(sampleNode);
			assertEquals(errors.size(), 1);
			errors.forEach(vm -> {
				System.out.println(vm.getMessage());
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

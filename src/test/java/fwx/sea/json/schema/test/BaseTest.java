package fwx.sea.json.schema.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.SpecVersionDetector;
import com.networknt.schema.JsonSchemaFactory;

public class BaseTest {

	private ObjectMapper mapper = new ObjectMapper();

	protected JsonNode getJsonNodeFromClasspath(String name) throws IOException {
		InputStream is1 = BaseTest.class.getResourceAsStream(name);
		return mapper.readTree(is1);
	}

	protected JsonNode getJsonNodeFromStringContent(String content) throws IOException {
		return mapper.readTree(content);
	}

	protected JsonNode getJsonNodeFromUrl(String url) throws IOException {
		return mapper.readTree(new URL(url));
	}

	protected JsonSchema getJsonSchemaFromClasspath(String name) {
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
		InputStream is = BaseTest.class.getResourceAsStream(name);
		return factory.getSchema(is);
	}

	protected JsonSchema getJsonSchemaFromStringContent(String schemaContent) {
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
		return factory.getSchema(schemaContent);
	}

	protected JsonSchema getJsonSchemaFromUrl(String uri) throws URISyntaxException {
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
		return factory.getSchema(new URI(uri));
	}

	protected JsonSchema getJsonSchemaFromJsonNode(JsonNode jsonNode) {
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
		return factory.getSchema(jsonNode);
	}

	// Automatically detect version for given JsonNode
	protected JsonSchema getJsonSchemaFromJsonNodeAutomaticVersion(JsonNode jsonNode) {
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersionDetector.detect(jsonNode));
		return factory.getSchema(jsonNode);
	}

}

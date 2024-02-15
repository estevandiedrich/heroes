package com.example.demo;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

public class HeroDeserializer extends JsonDeserializer<Hero> {
	@Override
	public Hero deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		JsonNode node = p.getCodec().readTree(p);
		JsonNode idNode = node.findValue("id");
		Integer id = 0;
		if(idNode != null) {
			id = (Integer) ((IntNode) idNode).numberValue();
		}
		String nameStr = node.get("name").asText();
		String powerStr = node.get("power").asText();
		Hero hero = null;
		if(id != 0l) {
			hero = new Hero(Long.valueOf(id),nameStr,powerStr);
		} else {
			hero = new Hero(nameStr,powerStr);
		}
		return hero;
	}
}

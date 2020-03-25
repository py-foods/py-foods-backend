package com.py.util;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtil {

	private JsonUtil() {
	}

	public static ObjectNode emptyNode() {
		return JsonNodeFactory.instance.objectNode();
	}

	public static ArrayNode emptyArray() {
		return JsonNodeFactory.instance.arrayNode();
	}
}

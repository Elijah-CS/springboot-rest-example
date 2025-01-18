package com.example.serialization;

import java.io.IOException;

import com.example.objects.inheritance.ObjectType;
import com.example.objects.inheritance.Parent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class ParentDeserializer extends StdDeserializer<Parent> {

    public ParentDeserializer() {
        this(null);
    }

    public ParentDeserializer(Class<Parent> t) {
        super(t);
    }

    public Parent deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
        System.out.println("Custom Deserializer called");

        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        Parent deserializedParent = null;

        DeserializationConfig config = context.getConfig();

        for (ObjectType objectType : ObjectType.values()) {

            JavaType type = TypeFactory.defaultInstance().constructType(objectType.getClazz());
            JsonDeserializer<Object> defaultDeserializer = BeanDeserializerFactory.instance.buildBeanDeserializer(context, type, config.introspect(type));

            if (defaultDeserializer instanceof ResolvableDeserializer) {
                ((ResolvableDeserializer) defaultDeserializer).resolve(context);
            }

            JsonParser treeParser = oc.treeAsTokens(node);
            config.initialize(treeParser);

            if (treeParser.getCurrentToken() == null) {
                treeParser.nextToken();
            }

            deserializedParent = (Parent) defaultDeserializer.deserialize(treeParser, context);

            if (!deserializedParent.validate()) {
                continue;
            }

            return deserializedParent;
        }

        throw JsonMappingException.from(jp, "Failed to derive type from content");
    }
    
}

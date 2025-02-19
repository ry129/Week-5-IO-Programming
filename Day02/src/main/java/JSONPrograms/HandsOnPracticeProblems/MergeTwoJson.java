package JSONPrograms.HandsOnPracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

 class MergeTwoJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Read JSON files into JsonNode objects
            JsonNode json1 = mapper.readTree(new File("file1.json"));
            JsonNode json2 = mapper.readTree(new File("file2.json"));

            // Merge JSON nodes
            JsonNode mergedJson = merge(json1, json2);

            // Print the merged JSON
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Merge two JsonNode objects
    public static JsonNode merge(JsonNode mainNode, JsonNode updateNode) {
        mainNode.fields().forEachRemaining(entry -> {
            String fieldName = entry.getKey();
            JsonNode value = entry.getValue();

            if (updateNode.has(fieldName)) {
                ((com.fasterxml.jackson.databind.node.ObjectNode) mainNode).set(fieldName, updateNode.get(fieldName));
            }
        });

        // Add fields from updateNode that are not present in mainNode
        updateNode.fields().forEachRemaining(entry -> {
            String fieldName = entry.getKey();
            if (!mainNode.has(fieldName)) {
                ((com.fasterxml.jackson.databind.node.ObjectNode) mainNode).set(fieldName, entry.getValue());
            }
        });

        return mainNode;
    }
}

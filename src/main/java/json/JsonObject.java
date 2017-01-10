package json;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    public HashMap<String, Json> jsonData;


    public JsonObject(JsonPair... jsonPairs) {
        jsonData = new HashMap<>();
        for (int i = 0; i < jsonPairs.length; ++i) {
            //if(!jsonData.containsKey(jsonPairs[i].key))
            jsonData.put(jsonPairs[i].key, jsonPairs[i].value);

        }
        //  System.out.println(jsonData.keySet());
    }

    @Override
    public String toJson() {
        String res = "{";
        int count = 0;
        for (String k : jsonData.keySet()) {
            count++;
            res += new JsonString(k).toJson();
            res += ":";
            res += jsonData.get(k).toJson();
            if (!(count == jsonData.keySet().size())) {
                res += ",";
            }
        }

        res += "}";
        System.out.println(res);
        return res;
    }

    public void add(JsonPair jsonPair) {
        jsonData.put(jsonPair.key, jsonPair.value);

    }

    public Json find(String name) {
        if (jsonData.containsKey(name))
            return jsonData.get(name);
        else
            return null;
    }

    public JsonObject projection(String... names) {
        JsonObject ans = new JsonObject();
        for (int i = 0 ; i < names.length; ++i){
            if (jsonData.containsKey(names[i]))
                ans.add(new JsonPair(names[i], jsonData.get(names[i])));
        }

        return ans;
    }
}

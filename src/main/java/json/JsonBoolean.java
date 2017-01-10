package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private Boolean myBool;


    public JsonBoolean(Boolean bool) {
        this.myBool = bool;
    }

    @Override
    public String toJson() {
        return Boolean.toString(myBool);
        //return new JsonString(Boolean.toString(myBool)).toJson();
    }
}

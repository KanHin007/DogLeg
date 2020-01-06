package abc.rpc.dubbo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class R<T> extends HashMap<String,T> implements Serializable {


    public static <T> R ok(T object){
        R r = new R();
        r.put("data",object);
        return r;
    }



}

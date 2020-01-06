package abc.serialized.json;

import abc.serialized.model.Car;
import abc.serialized.model.enums.Color;
import com.alibaba.fastjson.JSON;

public class FastJsonSerialized {


    /**
     * 编码
     * @param car
     * @return
     */
    public static String serialized(Car car){
        return JSON.toJSONString(car);
    }

    /**
     * 解码
     * @return
     */
    public static Car deserialized(String json){
        return JSON.parseObject(json,Car.class);
    }


    public static void main(String[] args) {
        Car car = new Car(1L,"BMW", Color.RED);
        String result = serialized(car);
        System.out.println(result);
        Car car1 = deserialized(result);
        System.out.println(car1);
    }



}

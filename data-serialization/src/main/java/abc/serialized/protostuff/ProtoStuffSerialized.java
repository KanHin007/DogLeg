package abc.serialized.protostuff;

import abc.serialized.model.Car;
import abc.serialized.model.enums.Color;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

public class ProtoStuffSerialized {


    private static Schema<Car> schema = null;

    static {
        schema = RuntimeSchema.createFrom(Car.class);
    }

    public static byte[] serialized(Car car){
        byte[] bytes = null;
        if(car != null) {
            LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
            bytes = ProtostuffIOUtil.toByteArray(car, schema, buffer);
        }
        return bytes;
    }

    public static Car deserialized(byte[] bytes){
        Car car1 = null;
        if(bytes != null) {
            LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
            car1 = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(bytes, car1, schema);
        }
        return car1;
    }


    public static void main(String[] args) {
        Car car = new Car(1L,"BENZ", Color.BLUE);
        byte[] bytes = serialized(car);
        System.out.println(bytes);
        car = deserialized(bytes);
        System.out.println(car);
    }




}

package abc.serialized.protobuf;

import abc.serialized.model.Car;
import abc.serialized.model.enums.Color;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import java.io.IOException;

public class ProtoBufSerialized {

    public static Codec<Car> simpleTypeCodec = null;

    static {
        simpleTypeCodec = ProtobufProxy
                .create(Car.class);
    }


    public static byte[] serialized(Car car){
        byte[] bytes = null;
        if(car !=null){
            try {
                bytes = simpleTypeCodec.encode(car);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    public static Car deserialized(byte[] bytes){
        Car car = null;
        if(bytes != null){
            try {
                car = simpleTypeCodec.decode(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return car;
    }

    public static void main(String[] args) {
        Car car = new Car(1L,"BMW", Color.RED);
        byte[] result = serialized(car);
        System.out.println(result);
        Car car1 = deserialized(result);
        System.out.println(car1);
    }



}

package abc.serialized.jdk;

import abc.serialized.model.Car;
import abc.serialized.model.enums.Color;

import java.io.*;


public class JdkSerialized {


    /**
     * 序列化称二进制编码
     * @param car
     * @return
     */
    public static byte[] serialized(Car car) {
        byte[] result = null;
        if (car != null) {

            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){
                objectOutputStream.writeObject(car);
                result = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 序列化称二进制编码
     * @param bytes
     * @return
     */
    public static Car deserialized(byte[] bytes) {
        Car result = null;
        if (bytes != null) {
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)){
                result = (Car) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Car car = new Car(1L,"BMW", Color.RED);
        byte[] result = JdkSerialized.serialized(car);
        System.out.println(result);
        Car car1 = deserialized(result);
        System.out.println(car1);
    }




}

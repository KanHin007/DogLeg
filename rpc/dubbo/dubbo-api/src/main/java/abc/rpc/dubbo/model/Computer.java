package abc.rpc.dubbo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer implements Serializable {


    Long id;

    String name;

    Integer size;

    String color;
}

package abc.serialized.model;

import abc.serialized.model.enums.Color;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Lawrence
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car implements Serializable {

    @Protobuf(fieldType = FieldType.INT64, order = 1, required = true)
    private Long id;

    @Protobuf(fieldType = FieldType.STRING, order = 2, required = false)
    private String name;

    @Protobuf(fieldType = FieldType.ENUM, order = 3, required = false)
    private Color color;

}

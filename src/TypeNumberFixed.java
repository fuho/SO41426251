import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import java.math.BigDecimal;

@Root(name = "TypeNumberFixed")
@Order(attributes = {"name"})
@Convert(TypeNumberFixed.FixConverter.class)
class TypeNumberFixed {
    @Attribute(required = false)
    protected String name;

    @Element(required = false, name = "value")
    protected BigDecimal value;


    public static class FixConverter implements Converter<TypeNumberFixed> {

        @Override
        public TypeNumberFixed read(InputNode inputNode) throws Exception {
            //Implement your own deConverter
            return null;
        }

        @Override
        public void write(OutputNode node, TypeNumberFixed value) throws Exception {
            node.setAttribute("name", value.name);
            OutputNode valueNode = node.getChild("value");
            if (value.value != null) {
                valueNode.setValue(value.value.toPlainString());
            } else {
                valueNode.setAttribute("xsi:nil", "true");
            }
        }
    }
}

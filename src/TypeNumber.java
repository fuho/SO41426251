import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import java.math.BigDecimal;

@Order(attributes = {"name"})
public class TypeNumber {
    @Attribute(required = false)
    protected String name;

    @Element(required = false)
    @Attribute(empty = "xsi:nil=\"true\"")
    protected BigDecimal value;

    //getter setter methods goes here
}
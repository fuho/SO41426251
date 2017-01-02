import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        TypeNumber tn1 = new TypeNumber();
        tn1.name = "original";
        tn1.value = new BigDecimal(10);
        File f1 = new File(tn1.name + ".xml");

        TypeNumber tn2 = new TypeNumber();
        tn2.name = "original_empty";
        File f2 = new File(tn2.name + ".xml");

        TypeNumberFixed tnf1 = new TypeNumberFixed();
        tnf1.name = "new";
        tnf1.value = new BigDecimal(30);
        File ftnf1 = new File(tnf1.name + ".xml");

        TypeNumberFixed tnf2 = new TypeNumberFixed();
        tnf2.name = "new_empty";
        File ftnf2 = new File(tnf2.name + ".xml");

        try {
            Serializer serializer = new Persister(new AnnotationStrategy());
            serializer.write(tn1, f1);
            serializer.write(tn2, f2);
            serializer.write(tnf1, ftnf1);
            serializer.write(tnf2, ftnf2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

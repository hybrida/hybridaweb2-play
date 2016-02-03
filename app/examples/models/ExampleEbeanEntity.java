package examples.models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Ivar on 30.09.2014.
 */
@Entity
public class ExampleEbeanEntity extends Model {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public static Finder<String, ExampleEbeanEntity> find = new Finder<String, ExampleEbeanEntity> (
            String.class, ExampleEbeanEntity.class
    );

    public ExampleEbeanEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
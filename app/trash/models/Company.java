package trash.models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Company extends Model {
    @Id
    public Long id;

    public String name;

    public static Finder<Long, Company> find = new Finder<Long, Company>(Long.class, Company.class);

    public static List<Company> all() {
        return find.all();
    }
}
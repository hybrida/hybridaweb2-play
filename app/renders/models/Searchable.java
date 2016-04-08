package renders.models;

public interface Searchable extends Renderable {
	String getMatchString();
	String getSearchHandle();
}

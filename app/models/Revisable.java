package models;

import com.avaje.ebean.Model;

/**
 * Created by ivar on 24.11.2015.
 */
public interface Revisable<T extends CRUDable> extends CRUDable {
	void    setPrevious(T previous);
	T       getPrevious();
	boolean hasPrevious();
	Long    getId();
	Long    getPreviousId();
}

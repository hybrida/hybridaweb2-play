package models;

import play.db.ebean.Model;

public interface Revisable<T extends CRUDable> extends CRUDable {
	void    setPrevious(T previous);
	T       getPrevious();
	boolean hasPrevious();
	Long    getId();
	Long    getPreviousId();
}

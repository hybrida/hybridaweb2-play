package models;

import play.mvc.Call;

/**
 * Created by ivar on 24.11.2015.
 */
public interface CRUDable {
	Call getCreateCall();
	Call getReadCall();
	Call getUpdateCall();
	Call getDeleteCall();
}

package models;

import play.mvc.Call;

public interface CRUDable {
	Call getCreateCall();
	Call getReadCall();
	Call getUpdateCall();
	Call getDeleteCall();
}

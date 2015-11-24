package profile.models;

import play.mvc.Call;

import java.sql.Timestamp;

public interface ImmutableUser {

	Long getId();
	String getUsername();
	String getFirstName();
	String getLastName();
	String getMiddleName();
	String getName();
	String getFullName();
	String getEmail();
	String getWebsiteUrl();
	String getPhone();
	String getTitle();
	Integer getGraduationYear();
	Specialization getSpecialization();
	String getProfileImageFileName();
	Call getProfileImageCall();
	Timestamp getLastLoginTime();
	char getGender();
	boolean hasMiddleName();
	boolean hasEmail();
	boolean hasWebsiteUrl();
	boolean hasPhone();
	boolean hasTitle();
	boolean hasGraduationYear();
	boolean hasSpecialization();
	boolean hasProfileImage();
	boolean isInBedkom();
	boolean isInArrkom();
	boolean isInVevkom();
	boolean isInJentekom();
	boolean isInRedaksjonen();
	User.Access[] getMemberships();
	boolean isAdmin();
	boolean isRoot();
	boolean hasAccess(boolean inAll, User.Access... accessList);
	boolean isDefault();
	boolean canCreateNewArticle();
	int calculateClass();
	String toString();

}

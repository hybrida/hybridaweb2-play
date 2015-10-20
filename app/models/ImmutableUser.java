package models;

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
	Timestamp getLastLoginTime();
	char getGender();
	Double getProfileImagePos();
	boolean hasMiddleName();
	boolean hasEmail();
	boolean hasWebsiteUrl();
	boolean hasPhone();
	boolean hasTitle();
	boolean hasGraduationYear();
	boolean hasSpecialization();
	boolean hasProfileImage();
	boolean hasProfileImagePos();
	boolean isRoot();
	boolean isDefault();
	boolean canCreateNewArticle();
	int calculateClass();
	String toString();

}

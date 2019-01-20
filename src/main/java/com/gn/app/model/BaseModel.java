package com.gn.app.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;


@MappedSuperclass
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = -5356423279919704668L;

/*	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	protected User createdUser;



	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "modified_by", nullable = true)
	protected User updatedUser;*/
@Column(name = "created_date", nullable = false)
protected Date createdDate;
	@Column(name = "modified_date", nullable = true)
	protected Date updatedDate;

	@Column(name = "is_deleted", nullable = false)
	protected Boolean isDeleted;

	@Version
	@Column(name = "version")
	protected Integer version;

/*
	@PrePersist
	public void prePersist() {
		createdDate = new Date();
		try {
			createdUser = AuthenticationUtil.getAuthenticatedUser();
		} catch (final Exception e) {
			createdUser = AuthenticationUtil.TRIGGER_USER;
		}
	}

	@PreUpdate
	public void preUpdate() {
		updatedDate = new Date();
		try {
			updatedUser = AuthenticationUtil.getAuthenticatedUser();
		} catch (final Exception e) {
			updatedUser = AuthenticationUtil.TRIGGER_USER;
		}
	}
*/

/*	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(final User createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(final User updatedUser) {
		this.updatedUser = updatedUser;
	}*/

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(final Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(final Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@SuppressWarnings("unchecked")
	public <T> void updateCollection(final String varName, final List<T> updatedList) {
		try {

			final Field field = this.getClass().getDeclaredField(varName);
			field.setAccessible(true);
			final List<T> currentList = (List<T>) field.get(this);

			if (currentList == null) {
				if (updatedList != null) {
					field.set(this, updatedList);
				} else {
					field.set(this, new ArrayList<T>());
				}
			} else {
				currentList.clear();
				if (updatedList != null) {
					currentList.addAll(updatedList);
				} else {
					currentList.addAll(new ArrayList<T>());
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> void updateCollection(final String varName, final Set<T> updatedList) {
		try {

			final Field field = this.getClass().getDeclaredField(varName);
			field.setAccessible(true);
			final Set<T> currentList = (Set<T>) field.get(this);

			if (currentList == null) {
				if (updatedList != null) {
					field.set(this, updatedList);
				} else {
					field.set(this, new HashSet<T>());
				}
			} else {
				currentList.clear();
				if (updatedList != null) {
					currentList.addAll(updatedList);
				} else {
					currentList.addAll(new HashSet<T>());
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}

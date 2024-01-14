package com.example.testJPAFK;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "POINTS")
public class Points {

	@Id
	@SequenceGenerator(name = "POINTSEQUENCE" , sequenceName = "POINTSEQUENCE" , allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "POINTSEQUENCE" , strategy = GenerationType.SEQUENCE)
	@Column(name = "POINTID")
	private int pointId;
	@Column(name = "POINT")
	private int point;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USERID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user ;



	public int getPointId() {
		return pointId;
	}



	public void setPointId(int pointId) {
		this.pointId = pointId;
	}



	public int getPoint() {
		return point;
	}



	public void setPoint(int point) {
		this.point = point;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Points [pointId=" + pointId + ", point=" + point + ", user=" + user + "]";
	}



	public Points(int pointId, int point, User user) {
		super();
		this.pointId = pointId;
		this.point = point;
		this.user = user;
	}



	public Points() {}
}

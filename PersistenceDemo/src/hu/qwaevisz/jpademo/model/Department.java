package hu.qwaevisz.jpademo.model;

import hu.qwaevisz.jpademo.model.trunk.Trunkable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the persontypes database table.
 * 
 */
@Entity
@Table(name = "departments")
public class Department implements Serializable, Trunkable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEP_ID")
	private int id;

	@Column(name = "DEP_NAME")
	private String name;

	public Department() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
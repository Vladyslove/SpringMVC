package com.testtask.springmvc.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Numbers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer numbA;
  private Integer numbB;
  private Integer numbC;
  private Double rootX1;
  private Double rootX2;

}

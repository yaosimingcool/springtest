package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_product")
public class Product {
   @Id
   private Integer id;
   private String name;
   private Double price;
   private String description;
   //private String path;
   private Integer state;
   //private Date bir;
   private String  address;

}

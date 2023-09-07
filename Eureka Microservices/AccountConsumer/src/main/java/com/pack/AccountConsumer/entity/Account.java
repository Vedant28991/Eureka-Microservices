package com.pack.AccountConsumer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="acc100")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	@Id
    private Integer id;
    private String name;
    private String type;
    private Double amount;
}

package org.keycloak.examples.rest.jpa;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER_ATTRIBUTE")
public class UserAttribute {
	@Id
	private String ID;
	private String USER_ID;
	private String NAME;
	private String VALUE;
	/*
	@ManyToOne(cascade = CascadeType.ALL)
    private EventEntity eventEntity;
	*/
	
//	@ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name = "USER_ID")
//    protected UserEntity2 user;
	
//	@ManyToOne
//    @JoinColumn(name = "USER_ID")
//    protected UserEntity2 user;
}

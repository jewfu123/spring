package org.keycloak.examples.rest.jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
//import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Nationalized;
import org.keycloak.models.utils.KeycloakModelUtils;

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
@Table(name="USER_ENTITY")
public class UserEntity {
	@Id
	@Column(name="ID", length = 36)
    @Access(AccessType.PROPERTY) // we do this because relationships often fetch id, but not entity.  This avoids an extra SQL
    protected String id;

    @Nationalized
    @Column(name = "USERNAME")
    protected String username;
    @Nationalized
    @Column(name = "FEDERATION_LINK")
    protected String federationLink;
    @Nationalized
    @Column(name = "FIRST_NAME")
    protected String firstName;
    @Column(name = "CREATED_TIMESTAMP")
    protected Long createdTimestamp;
    @Nationalized
    @Column(name = "LAST_NAME")
    protected String lastName;
    @Column(name = "EMAIL")
    protected String email;
    @Column(name = "ENABLED")
    protected boolean enabled;
    @Column(name = "EMAIL_VERIFIED")
    protected boolean emailVerified;

    // This is necessary to be able to dynamically switch unique email constraints on and off in the realm settings
    @Column(name = "EMAIL_CONSTRAINT")
    protected String emailConstraint = KeycloakModelUtils.generateId();

    @Column(name = "REALM_ID")
    protected String realmId;
    
    @Column(name = "SERVICE_ACCOUNT")
    protected boolean serviceAccount;
    
    @Column(name = "NOT_BEFORE")
    protected boolean notBefore;
    
//    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy="user")
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 20)
//    private Collection<Product> products = new ArrayList<>();
//    private UserEntity userentity;
//    //protected Collection<UserEventEntity> userevents;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
    private Collection<EventEntity> evententitys = new ArrayList<>();

}

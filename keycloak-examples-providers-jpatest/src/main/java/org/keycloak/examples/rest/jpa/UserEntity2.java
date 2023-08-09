package org.keycloak.examples.rest.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name="ue_findAll", query="SELECT e FROM UserEntity2 e"),
})
public class UserEntity2 implements Serializable {
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
    
    @Column(name = "SERVICE_ACCOUNT_CLIENT_LINK")
    protected String serviceAccount;
    
    @Column(name = "NOT_BEFORE")
    protected int notBefore;
    
//    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy="user")
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 20)
//    private Collection<Product> products = new ArrayList<>();
//    private UserEntity userentity;
//    //protected Collection<UserEventEntity> userevents;
    
//    @OneToMany(mappedBy = "userentity", fetch = FetchType.LAZY)
//    private List<UserEntity> evententity;
//    
//    public UserEntity(String s, String santideva, String sdfs) {
//        super();
//    }
    
    /*
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
    private Collection<EventEntity> evententitys = new ArrayList<>();
	*/
}

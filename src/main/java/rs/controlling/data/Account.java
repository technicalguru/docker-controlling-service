/**
 * 
 */
package rs.controlling.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * A controlling account (German SKR model).
 * @author ralph
 *
 */
@Entity
public class Account {

	private @Id @GeneratedValue Long uid;
	
	private String accountNumber;
	private AccountType accountType;
	private AccountSubType accountSubType;
	private String name;
	private String description;
	
	// These fields are computed
	private @Transient AccountClass accountClass;
	private @Transient AccountGroup accountGroup;
	private @Transient String subNumber;
		
	/**
	 * Constructor.
	 */
	public Account() {
	}

	/**
	 * Constructor.
	 * @param accountNumber
	 * @param accountType
	 * @param accountSubType
	 * @param name
	 * @param description
	 */
	public Account(String accountNumber, AccountType accountType, AccountSubType accountSubType, String name, String description) {
		setAccountNumber(accountNumber);
		setAccountType(accountType);
		setAccountSubType(accountSubType);
		setName(name);
		setDescription(description);
	}

	/**
	 * @return the uid
	 */
	public Long getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the accountSubType
	 */
	public AccountSubType getAccountSubType() {
		return accountSubType;
	}

	/**
	 * @param accountSubType the accountSubType to set
	 */
	public void setAccountSubType(AccountSubType accountSubType) {
		this.accountSubType = accountSubType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the accountClass
	 */
	public AccountClass getAccountClass() {
		return accountClass;
	}

	/**
	 * @return the accountGroup
	 */
	public AccountGroup getAccountGroup() {
		return accountGroup;
	}

	/**
	 * @return the subNumber
	 */
	public String getSubNumber() {
		return subNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Account)) return false;
		Account other = (Account) obj;
		return Objects.equals(accountNumber, other.accountNumber);
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + "]";
	}
	
	
}

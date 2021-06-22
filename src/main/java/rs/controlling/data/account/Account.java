/**
 * 
 */
package rs.controlling.data.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import rs.controlling.ControllingException;
import rs.controlling.data.converter.AccountSubTypeConverter;
import rs.controlling.data.converter.AccountTypeConverter;
import rs.controlling.data.ledger.AccountPosting;
import rs.controlling.data.ledger.AccountPostingType;

/**
 * A controlling account (German SKR model).
 * @author ralph
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "accountNumber")
@JsonIgnoreProperties({"​hibernateLazyInitializer", "handler"})
@Table(name = "ctrl_accounts")
public class Account {

	@JsonIgnore
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	
	@Column(name = "account_number")
	private String accountNumber;
	@Column(name = "account_type")
	@Convert(converter = AccountTypeConverter.class)
	private AccountType accountType;
	@Column(name = "account_subtype")
	@Convert(converter = AccountSubTypeConverter.class)
	private AccountSubType accountSubType;
	private String name;
	private String description;
	private Boolean active;
	private BigDecimal balance;
	
	// These fields are computed
	private @Transient AccountClass accountClass;
	private @Transient AccountGroup accountGroup;
	private @Transient int subNumber;
		
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "account")
	@JsonIgnore
	private List<AccountPosting> accountPostings = new ArrayList<>();

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
	public Account(String accountNumber, AccountType accountType, AccountSubType accountSubType, String name, String description, Boolean active) {
		setAccountNumber(accountNumber);
		setAccountType(accountType);
		setAccountSubType(accountSubType);
		setName(name);
		setDescription(description);
		setActive(active);
		this.balance = BigDecimal.ZERO;
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
		if ((accountNumber == null) || (accountNumber.length() < 4)) throw new ControllingException("Invalid account number: "+accountNumber);
		try {
			Integer.parseInt(accountNumber.substring(0, 4));
		} catch (NumberFormatException e) {
			throw new ControllingException("Invalid account number: "+accountNumber);
		}
		this.accountNumber = accountNumber;
		onLoad();
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
	public int getSubNumber() {
		return subNumber;
	}

	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @return the balance
	 */
	public void setBalance(BigDecimal value) {
		balance = value;
	}

	public BigDecimal apply(AccountPostingType type, BigDecimal value) {
		if (type.equals(AccountPostingType.CREDIT)) {
			return credit(value);
		}
		return debit(value);
	}
	
	public BigDecimal debit(BigDecimal other) {
		balance = balance.subtract(other);
		return balance;
	}
	
	public BigDecimal credit(BigDecimal other) {
		balance = balance.add(other);
		return balance;
	}
	
	/**
	 * @return the active
	 */
	public Boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the accountPostings
	 */
	public List<AccountPosting> getAccountPostings() {
		return accountPostings;
	}

	/**
	 * @param accountPostings the accountPostings to set
	 */
	public void setAccountPostings(List<AccountPosting> accountPostings) {
		this.accountPostings = accountPostings;
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
	
	@PostLoad
	private void onLoad() {
		this.accountClass  = AccountClass.get(accountNumber.substring(0, 1));
		this.accountGroup  = AccountGroup.get(accountNumber.substring(1, 2));
		if (accountNumber.length() == 4) {
			this.subNumber     = Integer.parseInt(accountNumber.substring(2));
		} else {
			// Strip out any extra characters
			StringBuilder s = new StringBuilder();
			char chars[] = accountNumber.toCharArray();
			for (int i=2; i<chars.length; i++) {
				if (Character.isDigit(chars[i])) s.append(chars[i]);
			}
			this.subNumber     = Integer.parseInt(s.toString());
		}
	}
	
	public static Account from(String number) {
		return new Account(number, null, null, null, null, null);
	}
}

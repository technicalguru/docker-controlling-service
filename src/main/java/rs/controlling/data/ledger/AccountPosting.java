/**
 * 
 */
package rs.controlling.data.ledger;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import rs.controlling.data.account.Account;

/**
 * Details about a posting on an account
 * @author ralph
 *
 */
@Entity
public class AccountPosting {

	private @Id @GeneratedValue Long uid;

	private String postingNumber;
	private String accountNumber;
	private AccountPostingType postingType;
	private BigDecimal amount;
	
	/**
	 * Constructor
	 */
	public AccountPosting() {
	}

	public AccountPosting(String postingNumber, String accountNumber, AccountPostingType postingType, BigDecimal amount) {
		super();
		this.postingNumber = postingNumber;
		this.accountNumber = accountNumber;
		this.postingType = postingType;
		this.amount = amount;
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
	 * @return the postingNumber
	 */
	public String getPostingNumber() {
		return postingNumber;
	}

	/**
	 * @param postingNumber the postingNumber to set
	 */
	public void setPostingNumber(String postingNumber) {
		this.postingNumber = postingNumber;
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
	 * @return the postingType
	 */
	public AccountPostingType getPostingType() {
		return postingType;
	}

	/**
	 * @param postingType the postingType to set
	 */
	public void setPostingType(AccountPostingType postingType) {
		this.postingType = postingType;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, postingNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof AccountPosting)) return false;
		AccountPosting other = (AccountPosting) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(postingNumber, other.postingNumber);
	}

	@Override
	public String toString() {
		return "AccountPosting [postingNumber=" + postingNumber + ", accountNumber=" + accountNumber + ", postingType="
				+ postingType + ", amount=" + amount + "]";
	}

	public static AccountPosting from(Account account) {
		return new AccountPosting(null, account.getAccountNumber(), null, null);
	}
}

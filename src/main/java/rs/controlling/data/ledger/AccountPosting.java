/**
 * 
 */
package rs.controlling.data.ledger;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import rs.controlling.data.account.Account;

/**
 * Details about a posting on an account
 * @author ralph
 *
 */
@Entity
@JsonIgnoreProperties({"​hibernateLazyInitializer", "handler"})
public class AccountPosting {

	@JsonIgnore
	private @Id @GeneratedValue Long uid;

    @ManyToOne(fetch = FetchType.LAZY)
    private Posting posting;
    
    @ManyToOne(fetch = FetchType.LAZY)
	private Account account;

    private AccountPostingType postingType;
	private BigDecimal amount;

	/**
	 * Constructor
	 */
	public AccountPosting() {
	}

	public AccountPosting(Posting posting, Account account, AccountPostingType postingType, BigDecimal amount) {
		super();
		setPosting(posting);
		setAccount(account);
		setPostingType(postingType);
		setAmount(amount);
		posting.getAccountPostings().add(this);
		account.getAccountPostings().add(this);
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
	 * @return the posting
	 */
	public Posting getPosting() {
		return posting;
	}

	/**
	 * @param posting the posting to set
	 */
	public void setPosting(Posting posting) {
		this.posting = posting;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
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
		return Objects.hash(account.getAccountNumber(), posting.getPostingNumber());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof AccountPosting)) return false;
		AccountPosting other = (AccountPosting) obj;
		return Objects.equals(account, other.account) && Objects.equals(posting, other.posting);
	}

	@Override
	public String toString() {
		return "AccountPosting [postingNumber=" + posting.getPostingNumber() + ", accountNumber=" + account.getAccountNumber() + ", postingType="
				+ postingType + ", amount=" + amount + "]";
	}

	public static AccountPosting from(Account account) {
		return new AccountPosting(null, account, null, null);
	}
}

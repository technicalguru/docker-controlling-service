/**
 * 
 */
package rs.controlling.service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import rs.controlling.data.ledger.PostingType;

/**
 * Object for creating a new posting.
 * @author ralph
 *
 */
public class PostingRequest {

	private String postingNumber;
	private PostingType postingType;
	private String source;
	private String sourceReference;
	private ZonedDateTime creationTime;
	private String description;
	private BigDecimal amount;
	private String accountNumber1;
	private String accountNumber2;
	
	/**
	 * Constructor.
	 */
	public PostingRequest() {
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
	 * @return the postingType
	 */
	public PostingType getPostingType() {
		return postingType;
	}

	/**
	 * @param postingType the postingType to set
	 */
	public void setPostingType(PostingType postingType) {
		this.postingType = postingType;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the sourceReference
	 */
	public String getSourceReference() {
		return sourceReference;
	}

	/**
	 * @param sourceReference the sourceReference to set
	 */
	public void setSourceReference(String sourceReference) {
		this.sourceReference = sourceReference;
	}

	/**
	 * @return the creationTime
	 */
	public ZonedDateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(ZonedDateTime creationTime) {
		this.creationTime = creationTime;
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

	/**
	 * @return the accountNumber1
	 */
	public String getAccountNumber1() {
		return accountNumber1;
	}

	/**
	 * @param accountNumber1 the accountNumber1 to set
	 */
	public void setAccountNumber1(String accountNumber1) {
		this.accountNumber1 = accountNumber1;
	}

	/**
	 * @return the accountNumber2
	 */
	public String getAccountNumber2() {
		return accountNumber2;
	}

	/**
	 * @param accountNumber2 the accountNumber2 to set
	 */
	public void setAccountNumber2(String accountNumber2) {
		this.accountNumber2 = accountNumber2;
	}

	
}

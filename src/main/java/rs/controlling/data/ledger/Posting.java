/**
 * 
 */
package rs.controlling.data.ledger;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import rs.baselib.util.RsDate;
import rs.baselib.util.RsYear;

/**
 * A Posting to form the ledger in an account
 * @author ralph
 */
@Entity
public class Posting {

	private @Id @GeneratedValue Long uid;

	private String postingNumber;
	private PostingType postingType;
	private String source;
	private String sourceReference;
	private RsDate creationTime;
	private RsYear fiscalYear;
	private String description;
	
	/**
	 * Constructor.
	 */
	public Posting() {
	}

	/**
	 * Constructor.
	 * @param postingNumber
	 * @param postingType
	 * @param source
	 * @param sourceReference
	 * @param creationTime
	 * @param fiscalYear
	 * @param description
	 */
	public Posting(String postingNumber, PostingType postingType, String source, String sourceReference, RsDate creationTime, RsYear fiscalYear, String description) {
		super();
		this.postingNumber = postingNumber;
		this.postingType = postingType;
		this.source = source;
		this.sourceReference = sourceReference;
		this.creationTime = creationTime;
		this.fiscalYear = fiscalYear;
		this.description = description;
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
	public RsDate getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(RsDate creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the fiscalYear
	 */
	public RsYear getFiscalYear() {
		return fiscalYear;
	}

	/**
	 * @param fiscalYear the fiscalYear to set
	 */
	public void setFiscalYear(RsYear fiscalYear) {
		this.fiscalYear = fiscalYear;
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

	@Override
	public int hashCode() {
		return Objects.hash(postingNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Posting)) return false;
		Posting other = (Posting) obj;
		return Objects.equals(postingNumber, other.postingNumber);
	}

	@Override
	public String toString() {
		return "Posting [postingNumber=" + postingNumber + "]";
	}

	
}

/**
 * 
 */
package rs.controlling.data.ledger;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import rs.controlling.data.converter.PostingTypeConverter;

/**
 * A Posting to form the ledger in an account
 * @author ralph
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "postingNumber")
@JsonIgnoreProperties({"​hibernateLazyInitializer", "handler"})
@Table(name = "ctrl_postings")
public class Posting {

	@JsonIgnore
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;

	@Column(name = "posting_number")
	private String postingNumber;
	@Column(name = "posting_type")
	@Convert(converter = PostingTypeConverter.class)
	private PostingType postingType;
	private String source;
	@Column(name = "source_ref")
	private String sourceReference;
	@Column(name = "creation_time")
	private ZonedDateTime creationTime;
	@Column(name = "fiscal_year")
	private Integer fiscalYear;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "posting")
	private List<AccountPosting> accountPostings = new ArrayList<>();
	
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
	 * @param description
	 */
	public Posting(String postingNumber, PostingType postingType, String source, String sourceReference, ZonedDateTime creationTime, String description) {
		super();
		setPostingNumber(postingNumber);
		setPostingType(postingType);
		setSource(source);
		setSourceReference(sourceReference);
		setCreationTime(creationTime == null ? ZonedDateTime.now(ZoneId.of("UTC")) : creationTime);
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
		this.creationTime = creationTime.withZoneSameInstant(ZoneId.of("UTC")).truncatedTo(ChronoUnit.SECONDS);
		this.fiscalYear   = this.creationTime.getYear();
	}

	/**
	 * @return the fiscalYear
	 */
	public Integer getFiscalYear() {
		return fiscalYear;
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

	@PostLoad
	private void onLoad() {
		if (!creationTime.getZone().getId().equals("UTC")) {
			creationTime = creationTime.withZoneSameInstant(ZoneId.of("UTC"));
		}
		this.fiscalYear   = creationTime.getYear();
	}	
}

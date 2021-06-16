/**
 * 
 */
package rs.controlling.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.controlling.data.ControllingEnum;
import rs.controlling.data.account.AccountClass;
import rs.controlling.data.account.AccountGroup;
import rs.controlling.data.account.AccountSubType;
import rs.controlling.data.account.AccountType;
import rs.controlling.data.ledger.AccountPostingType;
import rs.controlling.data.ledger.PostingType;

/**
 * Lists enumerations and other types
 * @author ralph
 *
 */
@RestController
@RequestMapping(path = "/help")
public class HelpController {

	/**
	 * Constructor
	 */
	public HelpController() {
	}

	/**
	 * List all account classes.
	 * @return
	 */
	@GetMapping("/accounts/classes")
	public List<EnumDescription> accountClasses() {
		return list(AccountClass.class);
	}
	
	/**
	 * List all account groups.
	 * @return
	 */
	@GetMapping("/accounts/groups")
	public List<EnumDescription> accountGroup() {
		return list(AccountGroup.class);
	}
	
	/**
	 * List all account types.
	 * @return
	 */
	@GetMapping("/accounts/types")
	public List<EnumDescription> accountTypes() {
		return list(AccountType.class);
	}
	
	/**
	 * List all account sub types.
	 * @return
	 */
	@GetMapping("/accounts/subtypes")
	public List<EnumDescription> accountSubTypes() {
		return list(AccountSubType.class);
	}
	
	/**
	 * List all posting types.
	 * @return
	 */
	@GetMapping("/postings/types")
	public List<EnumDescription> postingTypes() {
		return list(PostingType.class);
	}
	
	/**
	 * List all account posting types.
	 * @return
	 */
	@GetMapping("/postings/subtypes")
	public List<EnumDescription> accountPostingTypes() {
		return list(AccountPostingType.class);
	}
	
	protected List<EnumDescription> list(Class<? extends Enum<? extends ControllingEnum>> enumClass) {
		List<EnumDescription> rc = new ArrayList<>();
		for (Enum<?> e : enumClass.getEnumConstants()) {
			rc.add(new EnumDescription(((ControllingEnum)e).getId(), e.name(), ((ControllingEnum)e).getDescription()));
		}
		return rc;
	}
	
	public static class EnumDescription {
		
		private String id;
		private String name;
		private String description;
		
		public EnumDescription(String id, String name, String description) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
		
	}
}

/**
 * 
 */
package rs.controlling.rest.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

/**
 * Helps with REST calls.
 * @author ralph
 *
 */
public class RestUtils {

	public static Pageable createPageable(Integer pageNo, Integer pageSize, String sortDesc) {
		if (pageNo   == null) pageNo   = Integer.valueOf(0);
		if (pageSize == null) pageSize = Integer.valueOf(30);		
		
		// Construct sorting
		List<Order> orders = new ArrayList<>();
		for (String s : sortDesc.split(",")) {
			String p[] = s.split(":");
			orders.add((p.length < 2) || p[1].equalsIgnoreCase("asc") ? Order.asc(p[0]) : Order.desc(p[0]));
		}
		Sort sort = orders.size() > 0 ? Sort.by(orders) : Sort.unsorted();
		
		return PageRequest.of(pageNo, pageSize, sort);
	}

}

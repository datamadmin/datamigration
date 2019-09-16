package com.dataeconomy.framework.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dataeconomy.framework.filter.BaseFilter;

public class DAOUtils {

	// Build the criteria/sql to retrieve the data from the database
	@SuppressWarnings("rawtypes")
	public static List<Predicate> buildPredicates(CriteriaBuilder criteriaBuilder, Root root,
			Set<BaseFilter> baseFilters) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		for (BaseFilter userFilters : baseFilters) {
		   predicates.add(userFilters.getPredicate(criteriaBuilder, root));
		}
		return predicates;
	}
}

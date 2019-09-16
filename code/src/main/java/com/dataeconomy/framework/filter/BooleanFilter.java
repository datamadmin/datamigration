package com.dataeconomy.framework.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dataeconomy.workbench.constant.Labels;
import com.dataeconomy.workbench.constant.YesNoBoolean;



/**
 * 
 * @author GuvalaL1
 *
 */
public class BooleanFilter extends BaseFilter implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean value;

	public BooleanFilter(boolean value, String attributeName, Labels labelId) {
		this.value = value;
		this.attributeName = attributeName;
		this.labelId = labelId;
	}

	public BooleanFilter(FilterImpl filterImpl) {
		this.value = YesNoBoolean.fromString(filterImpl.getValue1()).toBoolean();
		this.attributeName = filterImpl.getAttributeName();
		this.labelId = filterImpl.getLabelId();
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public String getFilterType() {
		return BOOLEAN_FILTER;
	}

	// Return true if the user has entered valid data to filter
	public static boolean hasFilterableSelection(Boolean aValue) {
		return (aValue != null);
	}

	public FilterImpl toFilter() {
		return new FilterImpl(getAttributeName(), // id
				getAttributeName(), getOperator(), getFilterType(), YesNoBoolean.fromBoolean(getValue()).toString(),
				null, getLabelId());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Predicate getPredicate(CriteriaBuilder criteriaBuilder, Root root) {
		Expression<String> stringExpression = root.get(getAttributeName());
		return getPredicate(criteriaBuilder, stringExpression);
	}

	public Predicate getPredicate(CriteriaBuilder criteriaBuilder, Expression<String> stringExpression) {
		Predicate predicate = criteriaBuilder.equal(stringExpression, getValue());
		return predicate;
	}

	public String getActiveFilters() {
		return (YesNoBoolean.fromBoolean(getValue()).toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeName == null) ? 0 : attributeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooleanFilter other = (BooleanFilter) obj;
		if (attributeName == null) {
			if (other.attributeName != null)
				return false;
		} else if (!attributeName.equals(other.attributeName))
			return false;
		return true;
	}
}

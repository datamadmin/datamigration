package com.dataeconomy.framework.filter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dataeconomy.workbench.constant.Labels;
import com.dataeconomy.workbench.constant.WBConstants;



/**
 *  @author Guvala
 */
public class IntegerFilter extends BaseFilter implements Cloneable {

	protected Integer value1;
	protected Integer value2;
	private boolean localTime;
	

	public IntegerFilter() {

	}

	public IntegerFilter(Integer value1, Integer value2, String operator, String attributeName, Labels labelId) {
		this.value1 = value1;
		this.value2 = value2;
		this.operator = operator;
		this.attributeName = attributeName;
		this.labelId = labelId;
	}

	public IntegerFilter(FilterImpl filterImpl) {
		this.value1 = getValueOrNull(filterImpl.getValue1());
		this.value2 = getValueOrNull(filterImpl.getValue2());
		this.operator = filterImpl.getOperator();
		this.attributeName = filterImpl.getAttributeName();
		this.labelId = filterImpl.getLabelId();
	}

	public Integer getValue1() {
		return value1;
	}

	public void setValue1(Integer value1) {
		this.value1 = value1;
	}

	public Integer getValue2() {
		return value2;
	}

	public void setValue2(Integer value2) {
		this.value2 = value2;
	}

	public String getFilterType() {
		return INTEGER_FILTER;
	}

	@Override
	public String getEmbeddedValue1() {
		return String.valueOf(getValue1());
	}

	@Override
	public String getEmbeddedValue2() {
		return String.valueOf(getValue2());
	}

	public static List<String> getOperators() {
		List<String> operators = new ArrayList<String>();
		operators.add(EQUAL_OPERATOR);
		operators.add(GREATER_THAN_OPERATOR);
		operators.add(SMALLER_THAN_OPERATOR);
		operators.add(GREATER_AND_EQUAL_THAN_OPERATOR);
		operators.add(SMALLER_AND_EQUAL_THAN_OPERATOR);
		operators.add(NOT_EQUAL_OPERATOR);
		operators.add(BETWEEN_OPERATOR);

		return operators;
	}

	public static List<String> getExcludeBetweenOperators() {
		List<String> operators = new ArrayList<String>();
		operators.add(EQUAL_OPERATOR);
		operators.add(GREATER_THAN_OPERATOR);
		operators.add(SMALLER_THAN_OPERATOR);
		operators.add(GREATER_AND_EQUAL_THAN_OPERATOR);
		operators.add(SMALLER_AND_EQUAL_THAN_OPERATOR);
		operators.add(NOT_EQUAL_OPERATOR);

		return operators;
	}

	public FilterImpl toFilter() {
		return new FilterImpl(getAttributeName(), // id
				getAttributeName(), getOperator(), getFilterType(), getStringValueOrNull(getValue1()),
				getStringValueOrNull(getValue2()), getLabelId());
	}

	// Return true if the user has entered valid data to filter
	public static boolean hasFilterableSelection(Integer aValue) {
		return (aValue != null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Predicate getPredicate(CriteriaBuilder criteriaBuilder, Root root) {
		Expression<Integer> integerExpression = root.get(getAttributeName());
		return getPredicate(criteriaBuilder, integerExpression);
	}

	public Predicate getPredicate(CriteriaBuilder criteriaBuilder, Expression<Integer> integerExpression) {
		Predicate predicate = null;

		if (getOperator().equals(EQUAL_OPERATOR)) {
			predicate = criteriaBuilder.equal(integerExpression, getValue1());
		} else if (getOperator().equals(GREATER_THAN_OPERATOR)) {
			predicate = criteriaBuilder.gt(integerExpression, getValue1());
		} else if (getOperator().equals(SMALLER_THAN_OPERATOR)) {
			predicate = criteriaBuilder.lt(integerExpression, getValue1());
		} else if (getOperator().equals(GREATER_AND_EQUAL_THAN_OPERATOR)) {
			predicate = criteriaBuilder.ge(integerExpression, getValue1());
		} else if (getOperator().equals(SMALLER_AND_EQUAL_THAN_OPERATOR)) {
			predicate = criteriaBuilder.le(integerExpression, getValue1());
		} else if (getOperator().equals(NOT_EQUAL_OPERATOR)) {
			predicate = criteriaBuilder.notEqual(integerExpression, getValue1());
		} else if (getOperator().equals(BETWEEN_OPERATOR)) {
			predicate = criteriaBuilder.between(integerExpression, getValue1(), getValue2());
		}

		return predicate;
	}

	public String getActiveFilters() {
		StringBuilder activeFilter = new StringBuilder();
		activeFilter.append(getOperator()).append(WBConstants.BLANK_SPACE).append(getValue1());
		if (getOperator().equalsIgnoreCase(BETWEEN_OPERATOR)) {
			activeFilter.append(AND_SEPARATOR).append(getValue2());
		}
		return activeFilter.toString();
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
		IntegerFilter other = (IntegerFilter) obj;
		if (attributeName == null) {
			if (other.attributeName != null)
				return false;
		} else if (!attributeName.equals(other.attributeName))
			return false;
		return true;
	}

	protected Integer getValueOrNull(String stringValue) {
		Integer integerValue = null;
		try {
			if (stringValue != null) {
				integerValue = Integer.valueOf(stringValue);
			}
		} catch (NumberFormatException nfe) {
			// Do nothing will pass back null;
		}
		return integerValue;
	}

	private String getStringValueOrNull(Integer integerValue) {
		String stringValue = null;
		if (integerValue != null) {
			stringValue = String.valueOf(integerValue);
		}
		return stringValue;
	}

	public boolean isLocalTime() {
		return localTime;
	}

	public void setLocalTime(boolean localTime) {
		this.localTime = localTime;
	}
}

package com.dataeconomy.framework.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dataeconomy.framework.util.StringUtils;
import com.dataeconomy.workbench.constant.Labels;
import com.dataeconomy.workbench.constant.WBConstants;

/**
 *  @author Guvala
 */
public class StringFilter extends BaseFilter implements Cloneable {

	public static String DEFAULT_SELECT_ALL = "Select All";
	protected String value;
	protected boolean upperCase = true;
	protected boolean useUpperFunction = false; // Use ONLY for values that are
												// mixed case in the database.
												// E.g. values in the USERS
												// table

	public StringFilter() {

	}

	public StringFilter(String value, String operator, String attributeName, Labels labelId) {
		this.value = value;
		this.operator = operator;
		this.attributeName = attributeName;
		this.labelId = labelId;
	}

	public StringFilter(String value, String operator, String attributeName, Labels labelId, boolean upperCase) {
		this.value = value;
		this.operator = operator;
		this.attributeName = attributeName;
		this.labelId = labelId;
		this.upperCase = upperCase;
	}

	public StringFilter(String value, String operator, String attributeName, Labels labelId, boolean upperCase,
			boolean useUpperFunction) {
		this.value = value;
		this.operator = operator;
		this.attributeName = attributeName;
		this.labelId = labelId;
		this.upperCase = upperCase;
		this.useUpperFunction = useUpperFunction;
	}

	public StringFilter(FilterImpl filterImpl) {
		this.value = filterImpl.getValue1();
		this.operator = filterImpl.getOperator();
		this.attributeName = filterImpl.getAttributeName();
		this.labelId = filterImpl.getLabelId();
	}

	public String getValue() {
		return (upperCase ? value.trim().toUpperCase() : value);
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isUseUpperFunction() {
		return useUpperFunction;
	}

	public void setUseUpperFunction(boolean useUpperFunction) {
		this.useUpperFunction = useUpperFunction;
	}

	public String getFilterType() {
		return STRING_FILTER;
	}

	@Override
	public String getEmbeddedValue1() {
		return getValue();
	}

	public static List<String> getOperators() {
		List<String> operators = new ArrayList<String>();
		operators.add(EQUAL_OPERATOR);
		operators.add(NOT_EQUAL_OPERATOR);
		operators.add(STARTS_WITH_OPERATOR);
		operators.add(ENDS_WITH_OPERATOR);
		operators.add(CONTAINS_OPERATOR);
		operators.add(EMPTY_OPERATOR);
		operators.add(NOT_EMPTY_OPERATOR);
		operators.add(LAST_6_OPERATOR);
		operators.add(LAST_8_OPERATOR);
		operators.add(LAST_10_OPERATOR);

		return operators;
	}

	public static List<String> getCustomOperators() {
		List<String> operators = new ArrayList<String>();
		operators.add(EQUAL_OPERATOR);
		operators.add(NOT_EQUAL_OPERATOR);
		operators.add(STARTS_WITH_OPERATOR);
		operators.add(ENDS_WITH_OPERATOR);
		operators.add(CONTAINS_OPERATOR);
		operators.add(NOT_CONTAINS_OPERATOR);
		return operators;
	}

	public FilterImpl toFilter() {
		return new FilterImpl(getAttributeName(), // id
				getAttributeName(), getOperator(), getFilterType(), getValue(), null, getLabelId());
	}

	// Return true if the user has entered valid data to filter
	public static boolean hasFilterableSelection(String aValue) {
		return (!StringUtils.isEmpty(aValue) && !aValue.equalsIgnoreCase(DEFAULT_SELECT_ALL));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Predicate getPredicate(CriteriaBuilder criteriaBuilder, Root root) {
		Expression<String> stringExpression = (isUseUpperFunction()
				? criteriaBuilder.upper(root.get(getAttributeName())) : root.get(getAttributeName()));
		return getPredicate(criteriaBuilder, stringExpression);
	}

	public Predicate getPredicate(CriteriaBuilder criteriaBuilder, Expression<String> stringExpression) {
		Predicate predicate = null;

		if (getOperator().equals(EQUAL_OPERATOR)) {
			predicate = criteriaBuilder.equal(stringExpression, getValue());
		} else if (getOperator().equals(NOT_EQUAL_OPERATOR)) {
			predicate = criteriaBuilder.notEqual(stringExpression, getValue());
		} else if (getOperator().equals(STARTS_WITH_OPERATOR)) {
			String statswithid = getValue();
			predicate = criteriaBuilder.like(stringExpression, statswithid.replace("_", "$_") + "%",'$');
		} else if (getOperator().equals(DOES_NOT_START_WITH_OPERATOR)) {
			String doesNotLikeValue = getValue();
			predicate = criteriaBuilder.notLike(stringExpression, doesNotLikeValue.replace("_", "$_") + "%",'$');
		} else if (getOperator().equals(ENDS_WITH_OPERATOR)) {
			String endswithid = getValue();
			predicate = criteriaBuilder.like(stringExpression, "%" +endswithid.replace("_", "$_"),'$');
		} else if (getOperator().equals(CONTAINS_OPERATOR)) {
			String containsid = getValue();
			predicate = criteriaBuilder.like(stringExpression, "%" +containsid.replace("_", "$_") + "%",'$');
		}else if(getOperator().equals(NOT_CONTAINS_OPERATOR)){	
			String notcontainsid = getValue();
			predicate = criteriaBuilder.notLike(stringExpression, "%" + notcontainsid.replace("_", "$_") + "%",'$');
		} else if (getOperator().equals(EMPTY_OPERATOR)) {
			predicate = criteriaBuilder.isNull(stringExpression);
		} else if (getOperator().equals(NOT_EMPTY_OPERATOR)) {
			predicate = criteriaBuilder.isNotNull(stringExpression);
		} else if (operator.equals(LAST_6_OPERATOR) || operator.equals(LAST_8_OPERATOR)
				|| operator.equals(LAST_10_OPERATOR)) {
			Expression<Integer> attributeLengthExpression = criteriaBuilder.length(stringExpression);
			Expression<Integer> lengthExpression = null;
			Expression<String> subStringExpression = null;

			if (operator.equals(LAST_6_OPERATOR)) {
				lengthExpression = criteriaBuilder.diff(attributeLengthExpression, 5); // length
																						// -5
				subStringExpression = criteriaBuilder.substring(stringExpression, lengthExpression,
						criteriaBuilder.literal(6));
			} else if (operator.equals(LAST_8_OPERATOR)) {
				lengthExpression = criteriaBuilder.diff(attributeLengthExpression, 7); // length
																						// -7
				subStringExpression = criteriaBuilder.substring(stringExpression, lengthExpression,
						criteriaBuilder.literal(8));
			} else { // LAST_10
				lengthExpression = criteriaBuilder.diff(attributeLengthExpression, 9); // length
																						// -9
				subStringExpression = criteriaBuilder.substring(stringExpression, lengthExpression,
						criteriaBuilder.literal(10));
			}

			predicate = criteriaBuilder.equal(subStringExpression, getValue());
		}

		return predicate;
	}

	public String getActiveFilters() {
		StringBuffer activefilter = new StringBuffer();
		activefilter.append(getOperator());

		if (!getOperator().equals(EMPTY_OPERATOR) && !getOperator().equals(NOT_EMPTY_OPERATOR)) {
			activefilter.append(WBConstants.BLANK_SPACE).append(getValue());
		}

		return activefilter.toString();
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
		StringFilter other = (StringFilter) obj;
		if (attributeName == null) {
			if (other.attributeName != null)
				return false;
		} else if (!attributeName.equals(other.attributeName))
			return false;
		return true;
	}

}

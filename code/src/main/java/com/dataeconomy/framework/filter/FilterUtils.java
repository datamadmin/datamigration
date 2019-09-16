package com.dataeconomy.framework.filter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.dataeconomy.workbench.constant.Labels;

/**
 * 
 * @author Guvala
 *
 */
public class FilterUtils {

	public static List<String> getDateFilterOperators() {
		return DateFilter.getOperators();
	}

	public static List<String> getCustomDateFilterOperators() {
		return DateFilter.getDateFilterCustomeOperators();
	}

	public static List<String> getStringFilterOperators() {
		return StringFilter.getOperators();
	}

	// =, <>, Starts With, Empty, Not Empty operators
	public static List<String> getCustomStringFilterOperators() {
		return StringFilter.getCustomOperators();
	}

	public static List<String> getIntegerFilterOperators() {
		return IntegerFilter.getOperators();
	}

	public static List<String> getIntegerFilterOperatorsExcludeBetween() {
		return IntegerFilter.getExcludeBetweenOperators();
	}

	// Return a new instance of the DateFilter
	public static DateFilter getDateFilter(LocalDate date01, LocalDate date02, String operator, String attributeName,
			Labels labelId) {
		DateFilter dateFilter = null;
		if (operator == null) {
			return dateFilter;
		}
		if ((operator.equals(DateFilter.EMPTY_OPERATOR)) || (operator.equals(DateFilter.NOT_EMPTY_OPERATOR))
				|| (operator.equals(DateFilter.TODAY_OPERATOR)) || (operator.equals(DateFilter.YESTERDAY_OPERATOR))
				|| (DateFilter.hasFilterableSelections(date01))) {
			dateFilter = new DateFilter(date01, date02, operator, attributeName, labelId);
		}
		return dateFilter;
	}

	// Return a new instance of the DateFilter
	public static DateFilter getDateFilter(LocalDate date01, String operator, String attributeName, Labels labelId) {
		DateFilter dateFilter = null;
		if (operator == null) {
			return dateFilter;
		}
		if ((operator.equals(DateFilter.EMPTY_OPERATOR)) || (operator.equals(DateFilter.NOT_EMPTY_OPERATOR))
				|| (operator.equals(DateFilter.TODAY_OPERATOR)) || (operator.equals(DateFilter.YESTERDAY_OPERATOR))
				|| (DateFilter.hasFilterableSelections(date01))) {
			dateFilter = new DateFilter(date01, operator, attributeName, labelId);
		}
		return dateFilter;
	}

	public static DateFilter getDateFilter(LocalDateTime date01, LocalDateTime date02, String operator,
			String attributeName, Labels labelId) {
		DateFilter dateFilter = null;
		if (operator == null) {
			return dateFilter;
		}
		if ((operator.equals(DateFilter.EMPTY_OPERATOR)) || (operator.equals(DateFilter.NOT_EMPTY_OPERATOR))
				|| (operator.equals(DateFilter.TODAY_OPERATOR)) || (operator.equals(DateFilter.YESTERDAY_OPERATOR))
				|| (DateFilter.hasFilterableSelections(date01))) {
			dateFilter = new DateFilter(date01, date02, operator, attributeName, labelId);
		}
		return dateFilter;
	}

	// Return a new instance of the DateFilter
	public static DateFilter getDateFilter(LocalDateTime date01, String operator, String attributeName,
			Labels labelId) {
		DateFilter dateFilter = null;
		if (operator == null) {
			return dateFilter;
		}
		if ((operator.equals(DateFilter.EMPTY_OPERATOR)) || (operator.equals(DateFilter.NOT_EMPTY_OPERATOR))
				|| (operator.equals(DateFilter.TODAY_OPERATOR)) || (operator.equals(DateFilter.YESTERDAY_OPERATOR))
				|| (DateFilter.hasFilterableSelections(date01))) {
			dateFilter = new DateFilter(date01, operator, attributeName, labelId);
		}
		return dateFilter;
	}

	// Return a new instance of the IntegerFilter
	public static IntegerFilter getIntegerFilter(Integer value1, Integer value2, String operator, String attributeName,
			Labels labelId) {
		IntegerFilter integerFilter = null;
		if (operator == null) {
			return integerFilter;
		}
		// Both value1 and value2 must be entered for a Between search
		if (operator.equals(BaseFilter.BETWEEN_OPERATOR) && value2 == null) {
			// throw new
			// WebAppException(MessageConstants.TO_VALUE_REQUIRED_FOR_SEARCH,
			// getLabel(labelId));
		}

		if (IntegerFilter.hasFilterableSelection(value1)) {
			integerFilter = new IntegerFilter(value1, value2, operator, attributeName, labelId);
		}
		return integerFilter;
	}

	// Return a new instance of the LongFilter
	public static LongFilter getLongFilter(Long value1, Long value2, String operator, String attributeName,
			Labels labelId) {
		LongFilter longFilter = null;
		if (operator == null) {
			return longFilter;
		}

		if (LongFilter.hasFilterableSelection(value1)) {
			longFilter = new LongFilter(value1, value2, operator, attributeName, labelId);
		}

		if (operator.equals(BaseFilter.NOT_EMPTY_OPERATOR)) {
			longFilter = new LongFilter(value1, value2, operator, attributeName, labelId);
		}
		return longFilter;
	}

	// Return a new instance of the StringFilter
	public static StringFilter getStringFilter(String value, String operator, String attributeName, Labels labelId) {
		StringFilter stringFilter = null;
		if (operator != null
				&& ((operator.equals(StringFilter.EMPTY_OPERATOR)) || (operator.equals(StringFilter.NOT_EMPTY_OPERATOR))
						|| (StringFilter.hasFilterableSelection(value)))) {
			stringFilter = new StringFilter(value, operator, attributeName, labelId);
		}
		return stringFilter;
	}

	// Return a new instance of the StringFilter
	// The upperCase parameter should be set to true where mixed case is
	// allowed, and we need to use the UPPER function in the SQL
	public static StringFilter getStringFilter(String value, String operator, String attributeName, Labels labelId,
			Boolean upperCase) {
		StringFilter stringFilter = null;
		if (operator != null
				&& ((operator.equals(StringFilter.EMPTY_OPERATOR)) || (operator.equals(StringFilter.NOT_EMPTY_OPERATOR))
						|| (StringFilter.hasFilterableSelection(value)))) {
			stringFilter = new StringFilter(value, operator, attributeName, labelId, upperCase);
		}
		return stringFilter;
	}

	// Return a new instance of the StringFilter
	// The upperCase parameter should be set to true where mixed case is
	// allowed, and we need to use the UPPER function in the SQL
	// Use only for the USER functions
	public static StringFilter getStringFilter(String value, String operator, String attributeName, Labels labelId,
			Boolean upperCase, Boolean useUpperFunction) {
		StringFilter stringFilter = null;
		if (operator != null
				&& ((operator.equals(StringFilter.EMPTY_OPERATOR)) || (operator.equals(StringFilter.NOT_EMPTY_OPERATOR))
						|| (StringFilter.hasFilterableSelection(value)))) {
			stringFilter = new StringFilter(value, operator, attributeName, labelId, upperCase, useUpperFunction);
		}
		return stringFilter;
	}

	// Return a new instance of the BooleanFilter
	public static BooleanFilter getBooleanFilter(Boolean value, String attributeName, Labels labelId) {
		BooleanFilter booleanFilter = null;
		if (BooleanFilter.hasFilterableSelection(value)) {
			booleanFilter = new BooleanFilter(value, attributeName, labelId);
		}
		return booleanFilter;
	}
}

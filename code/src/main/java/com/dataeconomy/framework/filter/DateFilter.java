package com.dataeconomy.framework.filter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.workbench.constant.Labels;
import com.dataeconomy.workbench.constant.WBConstants;

/**
 * Date filters
 */
public class DateFilter extends BaseFilter implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final String FUNCTION_TO_DATE = "CONVERT";
	protected LocalDate date1;
	protected LocalDate date2;
	protected LocalDateTime dateTime1;
	protected LocalDateTime dateTime2;
	protected String formattedDate1;
	protected String formattedDate2;

	public DateFilter() {

	}

	public DateFilter(LocalDate date1, LocalDate date2, String operator, String attributeName, Labels labelId) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.formattedDate1 = DateUtils.convertToFilterDateString(getDate1());
		this.formattedDate2 = DateUtils.convertToFilterDateString(getDate2());
		this.operator = operator;
		this.attributeName = attributeName;
		this.labelId = labelId;
	}

	public DateFilter(LocalDateTime date1, String operator, String attributeName, Labels labelId) {
		super();
		this.dateTime1 = date1;
		this.formattedDate1 = DateUtils.convertToDisplayFormat(date1);
		this.operator = operator;
		this.attributeName = attributeName;
		this.labelId = labelId;
	}

	public DateFilter(LocalDateTime date1, LocalDateTime date2, String operator, String attributeName, Labels labelId) {
		super();
		this.dateTime1 = date1;
		this.dateTime2 = date2;
		this.formattedDate1 = DateUtils.convertToDisplayFormat(date1);
		this.formattedDate2 = DateUtils.convertToDisplayFormat(date2);
		this.operator = operator;
		this.attributeName = attributeName;
		this.labelId = labelId;
	}

	public DateFilter(LocalDate date1, String operator, String attributeName, Labels labelId) {
		super();
		this.date1 = date1;
		this.formattedDate1 = DateUtils.convertToFilterDateString(getDate1());
		this.operator = operator;
		this.attributeName = attributeName;
		this.labelId = labelId;
	}

	public DateFilter(FilterImpl filterImpl) {
		this.formattedDate1 = filterImpl.getValue1();
		this.formattedDate2 = filterImpl.getValue2();
		this.date1 = DateUtils.convertToLocalDate(getFormattedDate1());
		this.date2 = DateUtils.convertToLocalDate(getFormattedDate2());
		this.operator = filterImpl.getOperator();
		this.attributeName = filterImpl.getAttributeName();
		this.labelId = filterImpl.getLabelId();
	}

	public LocalDate getDate1() {
		return date1;
	}

	public void setDate1(LocalDate date1) {
		this.date1 = date1;
	}

	public LocalDate getDate2() {
		return date2;
	}

	public void setDate2(LocalDate date2) {
		this.date2 = date2;
	}

	public String getFormattedDate1() {
		return formattedDate1;
	}

	public void setFormattedDate1(String formattedDate1) {
		this.formattedDate1 = formattedDate1;
	}

	public String getFormattedDate2() {
		return formattedDate2;
	}

	public void setFormattedDate2(String formattedDate2) {
		this.formattedDate2 = formattedDate2;
	}

	public String getFilterType() {
		return DATE_FILTER;
	}

	public LocalDateTime getDateTime1() {
		return dateTime1;
	}

	public void setDateTime1(LocalDateTime dateTime1) {
		this.dateTime1 = dateTime1;
	}

	public LocalDateTime getDateTime2() {
		return dateTime2;
	}

	public void setDateTime2(LocalDateTime dateTime2) {
		this.dateTime2 = dateTime2;
	}

	@Override
	public String getEmbeddedValue1() {
		return getFormattedDate1();
	}

	@Override
	public String getEmbeddedValue2() {
		return getFormattedDate2();
	}

	// Return the list of operators available in the drop down.
	public static List<String> getOperators() {
		List<String> operators = new ArrayList<String>();
		operators.add(EQUAL_OPERATOR);
		operators.add(GREATER_THAN_OPERATOR);
		operators.add(SMALLER_THAN_OPERATOR);
		operators.add(GREATER_AND_EQUAL_THAN_OPERATOR);
		operators.add(SMALLER_AND_EQUAL_THAN_OPERATOR);
		operators.add(NOT_EQUAL_OPERATOR);
		operators.add(BETWEEN_OPERATOR);
		operators.add(EMPTY_OPERATOR);
		operators.add(NOT_EMPTY_OPERATOR);
		operators.add(TODAY_OPERATOR);
		operators.add(YESTERDAY_OPERATOR);

		return operators;
	}

	// Return the list of operators available in the drop down.
	public static List<String> getDateFilterCustomeOperators() {
		List<String> operators = new ArrayList<String>();
		operators.add(EQUAL_OPERATOR);
		operators.add(NOT_EQUAL_OPERATOR);
		operators.add(GREATER_THAN_OPERATOR);
		operators.add(GREATER_AND_EQUAL_THAN_OPERATOR);
		operators.add(SMALLER_THAN_OPERATOR);
		operators.add(SMALLER_AND_EQUAL_THAN_OPERATOR);
		return operators;
	}

	public FilterImpl toFilter() {
		return new FilterImpl(getAttributeName(), // id
				getAttributeName(), getOperator(), getFilterType(), getFormattedDate1(), getFormattedDate2(),
				getLabelId());
	}

	// Return true if the user has entered valid data to filter
	public static boolean hasFilterableSelections(LocalDate aDate) {
		return (aDate != null);
	}

	public static boolean hasFilterableSelections(LocalDateTime aDate) {
		return (aDate != null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Predicate getPredicate(CriteriaBuilder criteriaBuilder, Root root) {
		if (getDateTime1() != null) {
			Expression<LocalDateTime> dateExpression = root.get(getAttributeName());
			return getLocalDateTimePredicate(criteriaBuilder, dateExpression);
		} else {
			Expression<LocalDate> dateExpression = root.get(getAttributeName());
			return getDatePredicate(criteriaBuilder, dateExpression);
		}

	}

	public Predicate getDatePredicate(CriteriaBuilder criteriaBuilder, Expression<LocalDate> dateExpression) {
		Predicate predicate = null;
		int addOne = 1;
		LocalDate datePlusOne = null;
		if (getDate1() != null) {
			datePlusOne = getDate1().plusDays(addOne);
		}
		if (getOperator().equals(GREATER_THAN_OPERATOR)) {
			// Add one day to the input date
			predicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, datePlusOne);
		}
		// Operator '=' will be processed as to_date(db_date) >=
		// to_date(inputDate) && to_date(db_date) < to_date(inputDate + 1)
		else if (getOperator().equals(EQUAL_OPERATOR)) {
			Predicate gePredicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, getDate1());
			LocalDate date2 = getDate1().plusDays(addOne);
			Predicate ltPredicate = criteriaBuilder.lessThan(dateExpression, date2);
			predicate = criteriaBuilder.and(gePredicate, ltPredicate);
		}
		// Operator '<' will be processed as to_date(db_date) <
		// to_date(inputDate)
		else if (getOperator().equals(SMALLER_THAN_OPERATOR)) {
			predicate = criteriaBuilder.lessThan(dateExpression, getDate1());
		}
		// Operator '>=' will be processed as to_date(db_date) >=
		// to_date(inputDate)
		else if (getOperator().equals(GREATER_AND_EQUAL_THAN_OPERATOR)) {
			predicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, getDate1());
		}
		// Operator '<=' will be processed as to_date(db_date) <
		// to_date(inputDate + 1)
		else if (getOperator().equals(SMALLER_AND_EQUAL_THAN_OPERATOR)) {
			// Add one day to the input date
			predicate = criteriaBuilder.lessThan(dateExpression, datePlusOne);
		}
		// Operator '<>' will be processed as to_date(db_date) <
		// to_date(inputDate) && to_date(db_date) >= to_date(inputDate + 1)
		else if (getOperator().equals(NOT_EQUAL_OPERATOR)) {
			Predicate ltPredicate = criteriaBuilder.lessThan(dateExpression, getDate1());
			// Add one day to the input date
			Predicate gePredicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, datePlusOne);
			predicate = criteriaBuilder.or(ltPredicate, gePredicate);
		}
		// Operator 'Between' will be processed as to_date(db_date) >=
		// to_date(inputDate1) && to_date(db_date) < to_date(inputDate2 + 1)
		else if (getOperator().equals(BETWEEN_OPERATOR)) {
			Predicate gePredicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, getDate1());
			// Add one day to the input date2
			Predicate ltPredicate = criteriaBuilder.lessThan(dateExpression, datePlusOne);
			predicate = criteriaBuilder.and(gePredicate, ltPredicate);
		} else if (getOperator().equals(EMPTY_OPERATOR)) {
			predicate = criteriaBuilder.isNull(dateExpression);
		} else if (getOperator().equals(NOT_EMPTY_OPERATOR)) {
			predicate = criteriaBuilder.isNotNull(dateExpression);
		}

		return predicate;
	}

	public Predicate getLocalDateTimePredicate(CriteriaBuilder criteriaBuilder,
			Expression<LocalDateTime> dateExpression) {
		Predicate predicate = null;
		int addOne = 1;
		LocalDateTime datePlusOne = null;
		if (getDate1() != null) {
			datePlusOne = getDateTime1().plusDays(addOne);
		}
		if (getOperator().equals(GREATER_THAN_OPERATOR)) {
			// Add one day to the input date
			predicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, datePlusOne);
		}
		// Operator '=' will be processed as to_date(db_date) >=
		// to_date(inputDate) && to_date(db_date) < to_date(inputDate + 1)
		else if (getOperator().equals(EQUAL_OPERATOR)) {
			Predicate gePredicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, getDateTime1());
			LocalDateTime date2 = getDateTime1().plusDays(addOne);
			Predicate ltPredicate = criteriaBuilder.lessThan(dateExpression, date2);
			predicate = criteriaBuilder.and(gePredicate, ltPredicate);
		}
		// Operator '<' will be processed as to_date(db_date) <
		// to_date(inputDate)
		else if (getOperator().equals(SMALLER_THAN_OPERATOR)) {
			predicate = criteriaBuilder.lessThan(dateExpression, getDateTime1());
		}
		// Operator '>=' will be processed as to_date(db_date) >=
		// to_date(inputDate)
		else if (getOperator().equals(GREATER_AND_EQUAL_THAN_OPERATOR)) {
			predicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, getDateTime1());
		}
		// Operator '<=' will be processed as to_date(db_date) <
		// to_date(inputDate + 1)
		else if (getOperator().equals(SMALLER_AND_EQUAL_THAN_OPERATOR)) {
			// Add one day to the input date
			predicate = criteriaBuilder.lessThan(dateExpression, datePlusOne);
		}
		// Operator '<>' will be processed as to_date(db_date) <
		// to_date(inputDate) && to_date(db_date) >= to_date(inputDate + 1)
		else if (getOperator().equals(NOT_EQUAL_OPERATOR)) {
			Predicate ltPredicate = criteriaBuilder.lessThan(dateExpression, getDateTime1());
			// Add one day to the input date
			Predicate gePredicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, datePlusOne);
			predicate = criteriaBuilder.or(ltPredicate, gePredicate);
		}
		// Operator 'Between' will be processed as to_date(db_date) >=
		// to_date(inputDate1) && to_date(db_date) < to_date(inputDate2 + 1)
		else if (getOperator().equals(BETWEEN_OPERATOR)) {
			Predicate gePredicate = criteriaBuilder.greaterThanOrEqualTo(dateExpression, getDateTime1());
			// Add one day to the input date2
			Predicate ltPredicate = criteriaBuilder.lessThan(dateExpression, datePlusOne);
			predicate = criteriaBuilder.and(gePredicate, ltPredicate);
		} else if (getOperator().equals(EMPTY_OPERATOR)) {
			predicate = criteriaBuilder.isNull(dateExpression);
		} else if (getOperator().equals(NOT_EMPTY_OPERATOR)) {
			predicate = criteriaBuilder.isNotNull(dateExpression);
		}

		return predicate;
	}

	public String getActiveFilters() {
		StringBuffer activefilter = new StringBuffer();
		activefilter.append(getOperator());

		if (!getOperator().equals(EMPTY_OPERATOR) && !getOperator().equals(NOT_EMPTY_OPERATOR)
				&& !getOperator().equals(TODAY_OPERATOR) && !getOperator().equals(YESTERDAY_OPERATOR)) {
			activefilter.append(WBConstants.BLANK_SPACE).append(DateUtils.convertToFilterDateString(getDate1()));
		}

		if (getOperator().equalsIgnoreCase(BETWEEN_OPERATOR)) {
			activefilter.append(AND_SEPARATOR).append(DateUtils.convertToFilterDateString(getDate2()));
		}

		return activefilter.toString();
	}

	public DateFilter getDateFilter(LocalDate date01, LocalDate date02, String operator, String attributeName,
			Labels labelId) {
		return FilterUtils.getDateFilter(date01, date02, operator, attributeName, labelId);
	}

	public DateFilter getDateFilter(LocalDateTime date01, LocalDateTime date02, String operator, String attributeName,
			Labels labelId) {
		return FilterUtils.getDateFilter(date01, date02, operator, attributeName, labelId);
	}

	public DateFilter getDateFilter(LocalDateTime date01, String operator, String attributeName, Labels labelId) {
		return FilterUtils.getDateFilter(date01, operator, attributeName, labelId);
	}

	public StringFilter getStringFilter(String value, String operator, String attributeName, Labels labelId) {
		return FilterUtils.getStringFilter(value, operator, attributeName, labelId);
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
		DateFilter other = (DateFilter) obj;
		if (attributeName == null) {
			if (other.attributeName != null)
				return false;
		} else if (!attributeName.equals(other.attributeName))
			return false;
		return true;
	}
}

package com.dataeconomy.framework.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dataeconomy.framework.errorHandler.AppException;
import com.dataeconomy.framework.util.AppBundle;
import com.dataeconomy.workbench.constant.Labels;
import com.dataeconomy.workbench.constant.MessagesEnum;

/**
 * 
 * @author GuvalaL1
 *
 */
public abstract class BaseFilter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String GREATER_THAN_OPERATOR = "is greater than";
	public static final String EQUAL_OPERATOR = "is equal to";
	public static final String SMALLER_THAN_OPERATOR = "is lower than";
	public static final String GREATER_AND_EQUAL_THAN_OPERATOR = "is greater or equals";
	public static final String SMALLER_AND_EQUAL_THAN_OPERATOR = "is lower or equals";
	public static final String NOT_EQUAL_OPERATOR = "is not equal to";
	public static final String BETWEEN_OPERATOR = "between";
	public static final String EMPTY_OPERATOR = "Empty";
	public static final String NOT_EMPTY_OPERATOR = "Not Empty";
	public static final String STARTS_WITH_OPERATOR = "begins with";
	public static final String DOES_NOT_START_WITH_OPERATOR = "Does not start with";
	public static final String ENDS_WITH_OPERATOR = "ends with";
	public static final String CONTAINS_OPERATOR = "contains the word(s)";
	public static final String NOT_CONTAINS_OPERATOR = "does not contains the word(s)";
	public static final String LAST_6_OPERATOR = "Last 6";
	public static final String LAST_8_OPERATOR = "Last 8";
	public static final String LAST_10_OPERATOR = "Last 10";
	public static final String TODAY_OPERATOR = "Today";
	public static final String YESTERDAY_OPERATOR = "Yesterday";
	public static final String AND = "AND";
	public static final String OR = "OR";
	public static final String BOOLEAN_FILTER = "BooleanFilter";
	public static final String BOOLEAN_EMBEDDED_FILTER = "BooleanEmbeddedFilter";
	public static final String DATE_FILTER = "DateFilter";
	public static final String DATE_FILTER_LOCALE = "DateFilterLocale";
	public static final String BIG_DECIMAL_FILTER = "DecimalFilter";
	public static final String BIG_DECIMAL_FILTER_LOCALE = "DecimalFilterLocale";
	public static final String INTEGER_FILTER = "IntegerFilter";
	public static final String INTEGER_FILTER_LOCALE = "IntegerFilterLocale";
	public static final String INTEGER_SELECTABLE_FILTER = "IntegerSelectableFilter";
	public static final String LONG_FILTER = "LongFilter";
	public static final String LONG_FILTER_LOCALE = "LongFilterLocale";
	public static final String MULTIPLE_EMBEDDED_FILTER = "MultipleEmbeddedFilter";
	public static final String MULTIPLE_FILTER = "MultipleStringFilter";
	public static final String MULTIPLE_INTEGER_FILTER = "MultipleIntegerFilter";
	public static final String MULTIPLE_LONG_FILTER = "MultipleLongFilter";
	public static final String SELECTABLE_FILTER = "SelectableFilter";
	public static final String SELECTABLE_EXISTS_FILTER = "SelectableExistsFilter";
	public static final String SELECTABLE_OBJECT_FILTER = "SelectableObjectFilter";
	public static final String STRING_FILTER = "StringFilter";
	public static final String STRING_FILTER_LOCALE = "StringFilterLocale";
	public static final String STRING_EMBEDDED_FILTER = "StringEmbeddedFilter";
	public static final String STRING_EXISTS_FILTER = "StringExistsFilter";
	public static final String EXISTS_CONSTRAINT_FILTER = "ExistsConstraintFilter";
	protected static final String AND_SEPARATOR = " and ";
	public static final String DEFAULT_DELIMITER = ";;";
	public static final String DEFAULT_SELECT_ALL = "Select All";

	public Boolean showActiveFilters = Boolean.TRUE;
	public Boolean canIncludeFilter = Boolean.TRUE; // Set to false if you do
													// not want to include the
													// filter in the SQL
	protected String operator;
	protected String attributeName;
	protected Labels labelId;
	protected String databaseName;
	protected Class<?> existsClass; // For exists filters
	protected String mapToAttribute; // For exists filters
	protected Class<?> mapToAttributeClass; // For exists filters

	// Return the default selected operator
	public static String getDefaultOperator() {
		return EQUAL_OPERATOR;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public Labels getLabelId() {
		return labelId;
	}

	public void setLabelId(Labels labelId) {
		this.labelId = labelId;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public Class<?> getExistsClass() {
		return existsClass;
	}

	public void setExistsClass(Class<?> existsClass) {
		this.existsClass = existsClass;
	}

	public String getMapToAttribute() {
		return mapToAttribute;
	}

	public void setMapToAttribute(String mapToAttribute) {
		this.mapToAttribute = mapToAttribute;
	}

	public Class<?> getMapToAttributeClass() {
		return mapToAttributeClass;
	}

	public void setMapToAttributeClass(Class<?> mapToAttributeClass) {
		this.mapToAttributeClass = mapToAttributeClass;
	}

	public Boolean getShowActiveFilters() {
		return showActiveFilters;
	}

	public void setShowActiveFilters(Boolean showActiveFilters) {
		this.showActiveFilters = showActiveFilters;
	}

	public Boolean getCanIncludeFilter() {
		return canIncludeFilter;
	}

	public void setCanIncludeFilter(Boolean canIncludeFilter) {
		this.canIncludeFilter = canIncludeFilter;
	}

	public BaseFilter clone() {
		BaseFilter newFilter = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
			newFilter = (BaseFilter) in.readObject();
		} catch (IOException ex) {
			throw new AppException(MessagesEnum.DEFAULT_ERROR_MESSAGE, ex);
		} catch (ClassNotFoundException ex) {
			throw new AppException(MessagesEnum.DEFAULT_ERROR_MESSAGE, ex);
		}
		return newFilter;
	}

	public abstract Predicate getPredicate(CriteriaBuilder builder, Root root);

	public abstract FilterImpl toFilter();

	public abstract String getActiveFilters();

	public abstract String getFilterType();

	public Boolean isConstraintFilter() {
		return false;
	}

	public Boolean isExistsConstraintFilter() {
		return false;
	}

	public Boolean isUserExistsFilter() {
		return false;
	}

	protected String getLabel(Locale locale) {
		return AppBundle.getString(labelId, locale);
	}

	// Override in the subclass if required
	protected String getEmbeddedValue1() {
		return null;
	}

	// Override in the subclass if required
	protected String getEmbeddedValue2() {
		return null;
	}
}

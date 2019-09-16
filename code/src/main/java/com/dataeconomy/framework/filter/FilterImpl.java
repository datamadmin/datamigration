package com.dataeconomy.framework.filter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.dataeconomy.workbench.constant.Labels;


/**
 *  @author Guvala
 */
@XmlRootElement(name = "filter")
@XmlType(propOrder = { "attributeName", "databaseName", "operator", "type", "value1", "value2", "value3", "labelId",
		"precision", "embeddedType" })
public class FilterImpl implements Filter {

	private String id;
	private String attributeName;
	private String databaseName;
	private String operator;
	private String type;
	private String value1;
	private String value2;
	private String value3; // Only required for Embedded filter types
	private Labels labelId;
	private int precision; // Only required for Big Decimal filter types
	private String embeddedType;

	public FilterImpl() {

	}

	public FilterImpl(String id, String attributeName, String operator, String type, String value1, String value2,
			Labels labelId) {
		super();
		this.id = id;
		this.attributeName = attributeName;
		this.operator = operator;
		this.type = type;
		this.value1 = value1;
		this.value2 = value2;
		this.labelId = labelId;
	}

	// Boolean is added to change the constructor signature for use with native
	// queries
	// The Boolean isNative is not actually going to be used
	public FilterImpl(String id, String attributeName, String operator, String type, String value1, String value2,
			Labels labelId, String databaseName) {
		super();
		this.id = id;
		this.attributeName = attributeName;
		this.operator = operator;
		this.type = type;
		this.value1 = value1;
		this.value2 = value2;
		this.labelId = labelId;
		this.databaseName = databaseName;
	}

	// This constructor will be used by the Big Decimal Filter types
	public FilterImpl(String id, String attributeName, String operator, String type, String value1, String value2,
			Labels labelId, int precision) {
		super();
		this.id = id;
		this.attributeName = attributeName;
		this.operator = operator;
		this.type = type;
		this.value1 = value1;
		this.value2 = value2;
		this.labelId = labelId;
		this.precision = precision;
	}

	// This constructor will be used by the Embedded Filter types, as we always
	// need to retain the values of the outer
	// filter as well as the embedded one.
	public FilterImpl(String id, String attributeName, String operator, String type, String value1, String value2,
			String value3, Labels labelId, String embeddedType) {
		super();
		this.id = id;
		this.attributeName = attributeName;
		this.operator = operator;
		this.type = type;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.labelId = labelId;
		this.embeddedType = embeddedType;
	}

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public Labels getLabelId() {
		return labelId;
	}

	public void setLabelId(Labels labelId) {
		this.labelId = labelId;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getEmbeddedType() {
		return embeddedType;
	}

	public void setEmbeddedType(String embeddedType) {
		this.embeddedType = embeddedType;
	}

	public BaseFilter toFilterObject() {
		if (getType().equals(BaseFilter.DATE_FILTER)) {
			return new DateFilter(this);
		} else if (getType().equals(BaseFilter.INTEGER_FILTER)) {
			return new IntegerFilter(this);
		} else if (getType().equals(BaseFilter.LONG_FILTER)) {
			return new LongFilter(this);
		} else if (getType().equals(BaseFilter.STRING_FILTER)) {
			return new StringFilter(this);
		} else if (getType().equals(BaseFilter.BOOLEAN_FILTER)) {
			return new BooleanFilter(this);
		}

		return null;
	}
}

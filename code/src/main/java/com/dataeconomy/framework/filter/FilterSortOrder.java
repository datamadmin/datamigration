package com.dataeconomy.framework.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com.dataeconomy.framework.errorHandler.AppException;
import com.dataeconomy.framework.util.StringUtils;
import com.dataeconomy.workbench.constant.MessagesEnum;

/**
 * @author Guvala
 */
public class FilterSortOrder implements Serializable, Cloneable {

	public static final String ORDER_ASC = "asc";
	public static final String ORDER_DESC = "desc";
	public static final String SUM = "sum";
	public static final String AVG = "avg";
	public static final String COUNT = "count";
	public static final String MAX = "max";

	private String attributeName;
	private String sortOrder;
	private String label;
	private String aggregation;
	private String aggregatedAttributeName;
	private String function;

	public FilterSortOrder() {

	}

	public FilterSortOrder(String attributeName, String sortOrder) {
		this.attributeName = attributeName;
		this.sortOrder = sortOrder;
	}

	public FilterSortOrder(String attributeName, String sortOrder, String label) {
		this.attributeName = attributeName;
		this.sortOrder = sortOrder;
		this.label = label;
	}

	public FilterSortOrder(String attributeName, String sortOrder, String label, String aggregation,
			String aggregatedAttributeName) {
		this.attributeName = attributeName;
		this.sortOrder = sortOrder;
		this.label = label;
		this.aggregation = aggregation;
		this.aggregatedAttributeName = aggregatedAttributeName;
	}

	public FilterSortOrder(String attributeName, String function, String sortOrder, String label) {
		this.attributeName = attributeName;
		this.function = function;
		this.sortOrder = sortOrder;
		this.label = label;

	}

	public FilterSortOrder(FilterSortImpl sortImpl) {
		this.attributeName = sortImpl.getAttributeName();
		this.sortOrder = sortImpl.getSortOrder();
		this.label = sortImpl.getLabel();
		this.aggregation = sortImpl.getAggregation();
		this.aggregatedAttributeName = sortImpl.getAggregatedAttributeName();
	}

	public FilterSortOrder clone() {
		FilterSortOrder newFilter = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
			newFilter = (FilterSortOrder) in.readObject();
		} catch (IOException ex) {
			throw new AppException(MessagesEnum.DEFAULT_ERROR_MESSAGE, ex);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return newFilter;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Order getOrder(CriteriaBuilder criteriaBuilder, Root root) {
		Order order = null;
		Expression sortAttributeExpression = null;

		if (getAggregation() == null) {
			sortAttributeExpression = root.get(attributeName);
		} else {
			sortAttributeExpression = getAggregatedSortExpression(criteriaBuilder, root);
		}

		if (isOrderAscending()) {
			order = criteriaBuilder.asc(sortAttributeExpression);
		} else {
			order = criteriaBuilder.desc(sortAttributeExpression);
		}

		return order;
	}

	private Expression getAggregatedSortExpression(CriteriaBuilder criteriaBuilder, Root root) {
		Expression sortAttributeExpression = root.get(getAggregatedAttributeName());

		if (getAggregation().equalsIgnoreCase(AVG)) {
			sortAttributeExpression = criteriaBuilder.avg(sortAttributeExpression);
		} else if (getAggregation().equalsIgnoreCase(COUNT)) {
			sortAttributeExpression = criteriaBuilder.count(sortAttributeExpression);
		} else if (getAggregation().equalsIgnoreCase(MAX)) {
			sortAttributeExpression = criteriaBuilder.max(sortAttributeExpression);
		} else if (getAggregation().equalsIgnoreCase(SUM)) {
			sortAttributeExpression = criteriaBuilder.sum(sortAttributeExpression);
		}

		return sortAttributeExpression;
	}

	public String getSortListLabel(String sortLabel) {
		if (!StringUtils.isEmpty(getSortOrder())) {
			sortLabel = sortLabel + " - " + getSortOrder().toUpperCase();
		}

		return sortLabel;
	}

	public FilterSortImpl toICLFilterSort() {
		return new FilterSortImpl(getAttributeName(), getSortOrder(), getLabel(), getAggregation(),
				getAggregatedAttributeName());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FilterSortOrder that = (FilterSortOrder) o;

		if (attributeName != null ? !attributeName.equals(that.attributeName) : that.attributeName != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return attributeName != null ? attributeName.hashCode() : 0;
	}

	/**** Getters and Setters ****/

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private boolean isOrderAscending() {
		return getSortOrder().equals(ORDER_ASC);
	}

	public String getAggregation() {
		return aggregation;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}

	public String getAggregatedAttributeName() {
		return aggregatedAttributeName;
	}

	public void setAggregatedAttributeName(String aggregatedAttributeName) {
		this.aggregatedAttributeName = aggregatedAttributeName;
	}
}

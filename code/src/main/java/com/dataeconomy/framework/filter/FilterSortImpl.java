package com.dataeconomy.framework.filter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *  @author Guvala
 */
@XmlRootElement(name = "sortOrder")
@XmlType(propOrder = {"attributeName", "sortOrder", "label", "aggregation", "aggregatedAttributeName"})
public class FilterSortImpl implements FilterSort {

    private String attributeName;
    private String sortOrder;
    private String label;
    private String aggregation;
    private String aggregatedAttributeName;

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
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

    public FilterSortImpl() {

    }

    public FilterSortImpl(String attributeName, String sortOrder, String label, String aggregation, String aggregatedAttributeName) {
        this.attributeName = attributeName;
        this.sortOrder = sortOrder;
        this.label = label;
        this.aggregation = aggregation;
        this.aggregatedAttributeName = aggregatedAttributeName;
    }

    public FilterSortOrder toFilterSortOrder() {
        return new FilterSortOrder(this);
    }
}

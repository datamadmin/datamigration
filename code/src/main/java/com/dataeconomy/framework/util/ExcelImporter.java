package com.dataeconomy.framework.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.dataeconomy.framework.errorHandler.AppException;

public final class ExcelImporter {

	/**
	 * Creates Workbook
	 * 
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	public static Workbook importExcel(InputStream inputStream) throws Exception {
		Workbook workbook;
		try {
			byte[] bytes = new byte[2048];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(bytes)) != -1) {
				baos.write(bytes, 0, bytesRead);
			}
			baos.flush();
			workbook = WorkbookFactory.create(new ByteArrayInputStream(baos.toByteArray()));
		} catch (Exception wae) {
			throw wae;
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
		}

		return workbook;
	}

	/**
	 * Covert the input stream to byte content
	 * 
	 */
	public static <T> List<T> importExcel(InputStream inputStream, Class<T> clazz) throws Exception {
		List<T> uploadData = null;

		try {
			byte[] bytes = new byte[2048];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(bytes)) != -1) {
				baos.write(bytes, 0, bytesRead);
			}
			baos.flush();
			uploadData = readExcel(baos.toByteArray(), clazz);
		} catch (Exception wae) {
			throw wae;
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
		}

		return uploadData;
	}

	/**
	 * read the excel and convert to mapping entity
	 * 
	 */
	public static <T> List<T> readExcel(byte[] bytes, Class<T> entity) throws Exception {
		List<T> objects = new ArrayList<>();
		Map<String, String> columnMap = getCustomColumnMap(entity);
		Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(bytes));
		Sheet sheet = workbook.getSheetAt(0);
		int headerRow = sheet.getFirstRowNum();
		List<String> headers = getHeaders(sheet, headerRow);
		int dataRowNum = headerRow + 1;
		int sheetRowNum = dataRowNum + 1;

		Row dataRow = sheet.getRow(dataRowNum);
		if (dataRow == null || isBlankRow(dataRow)) {

		}

		while (dataRow != null) {
			if (isBlankRow(dataRow)) {

			}
			T object = (T) entity.newInstance();
			for (int col = 0; col < headers.size(); col++) {
				Cell cell = dataRow.getCell(col);
				String propertyName = columnMap.get(headers.get(col));
				if (propertyName == null) {

				}
				if (cell != null) {
					int cellType = cell.getCellType();
					Object cellValue = null;
					try {
						if (cellType == Cell.CELL_TYPE_NUMERIC) {
							cellValue = cell.getNumericCellValue();
							if (DateUtil.isCellDateFormatted(cell)) {
								cellValue = HSSFDateUtil.getJavaDate((Double) cellValue);
							} else {
								String cellStyle = cell.getCellStyle().getDataFormatString();
								if (cellStyle.equalsIgnoreCase("general") || cellStyle.equalsIgnoreCase("@")) {
									cellValue = cell.getNumericCellValue();
								} else {
									int pos = cellStyle.indexOf(".");
									if (pos > 0) {
										int precision = cellStyle.length() - 1 - pos;
										cellValue = new BigDecimal((Double) cellValue).setScale(precision,
												BigDecimal.ROUND_HALF_UP);
									} else {
										DecimalFormat df = new DecimalFormat(cellStyle.replace(",", ""));
										cellValue = Long.parseLong(df.format(cellValue));
									}
								}

							}

						} else if (cellType == Cell.CELL_TYPE_STRING) {
							cellValue = cell.getStringCellValue();
							Class type = PropertyUtils.getPropertyType(object, propertyName);
							if (type.getName().equals("boolean")) {
							}
						} else if (cellType == Cell.CELL_TYPE_BOOLEAN) {
							cellValue = cell.getBooleanCellValue();
						}
					} catch (Exception ex) {
					}

					try {
						/*
						 * If celltype is numeric, then convert Double type to
						 * desired attribute type in entity or DTO
						 */
						if (cellType == Cell.CELL_TYPE_NUMERIC && cellValue != null) {
							cellValue = parseNumber(entity.getDeclaredField(propertyName).getType(), cellValue);
						}

						if (cellValue != null) {
							PropertyUtils.setProperty(object, propertyName, cellValue);
						}
					} catch (AppException ae) {
						throw ae;
					} catch (IllegalArgumentException iae) {

					} catch (Exception ex) {

					}
				}

			}

			// Add object to collection
			objects.add(object);

			// Read the next data row
			dataRowNum++;
			dataRow = sheet.getRow(dataRowNum);
			// Sheet row num is also updated so that it will display row
			// properly in error message
			sheetRowNum++;
		}
		return (objects);
	}

	// Get DB column names from the header row
	private static List<String> getHeaders(Sheet sheet, int headerRow) {
		Row row = sheet.getRow(headerRow);
		if (row == null) {
		}
		List<String> headers = new ArrayList<>();
		Iterator<Cell> cellIterator = row.cellIterator();

		try {
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String header = cell.getStringCellValue();
				if (!StringUtils.isEmpty(header)) {
					headers.add(header);
				}
			}
		} catch (Exception ex) {
		}

		return (headers);
	}

	/**
	 * Extract property names corresponding to the db column name from the
	 * entity object
	 * 
	 */
	private static Map<String, String> getColumnMap(Class entity) {
		Map<String, String> dbMap = new HashMap<>();
		Field[] fields = entity.getDeclaredFields();
		for (Field field : fields) {
			Column annotation = field.getAnnotation(Column.class);
			if (annotation != null) {
				dbMap.put(annotation.name(), field.getName());
			}
		}

		return (dbMap);
	}

	/**
	 * This method is used to convert Double type (which is the default format
	 * when Excel cell containing number is read) to type of the attribute
	 * declared in Entity or DTO
	 * 
	 * @param num
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NumberFormatException
	 */
	private static Object parseNumber(Class<?> num, Object obj) throws IllegalArgumentException, NumberFormatException {
		Object result = null;
		if (num != null && obj instanceof Double) {
			Double d = (Double) obj;
			if (num.equals(Double.class) || num.equals(double.class)) {
				result = (Object) d;
			}
			if (num.equals(String.class)) {
				result = (Object) String.valueOf("" + d.longValue());
			}
			if (num.equals(Integer.class) || num.equals(int.class)) {
				// This condition checks whether there is any Decimal part
				// If not the value is parsed to desired object type else
				// IllegalArgumentException is thrown as it cannot be casted to
				// Integer
				if (d % 1 == 0) {
					/*
					 * value is converted to String and parsed so that if the
					 * value is out of Integer range NumberFormat exception will
					 * be thrown
					 */
					result = (Object) Integer.valueOf("" + d.longValue());
				} else {
					throw new IllegalArgumentException("Number containing fractions, cannot convert to Integer");
				}
			} else if (num.equals(Short.class) || num.equals(short.class)) {
				if (d % 1 == 0) {
					result = (Object) Short.valueOf("" + d.longValue());
				} else {
					throw new IllegalArgumentException("Number containing fractions, cannot convert to Short");
				}
			} else if (num.equals(Long.class) || num.equals(long.class)) {
				if (d % 1 == 0) {
					result = (Object) Long.valueOf("" + d.longValue());
				} else {
					throw new IllegalArgumentException("Number containing fractions, cannot convert to Long");
				}
			} else if (num.equals(Float.class) || num.equals(float.class)) {
				result = (Object) Float.valueOf(d.toString());
			}
		} else if (obj instanceof Date) {
			result = obj;
		} else if (obj instanceof Number) {
			Number numType = (Number) obj;
			Integer temp = 0;
			if (num.equals(Integer.class) || num.equals(int.class)) {
				result = numType.intValue();
			} else if (num.equals(Long.class) || num.equals(long.class)) {
				result = numType.longValue();
			} else if (num.equals(String.class)) {
				temp = numType.intValue();
				result = temp.toString();
			} else if (num.equals(Double.class)) {
				result = numType.doubleValue();
			} else {
				result = obj;
			}
		} else {
			throw new IllegalArgumentException("Received input is not a Number object. Unable to parse data");
		}
		return result;
	}

	public static boolean isBlankRow(Row dataRow) {
		boolean blankRow = true;
		for (int i = dataRow.getFirstCellNum(); i <= dataRow.getLastCellNum(); i++) {
			Cell cell = dataRow.getCell(i);
			blankRow = cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK;
			if (!blankRow) {
				return false;
			}
		}
		return blankRow;
	}

	/**
	 * Validates Header row and Returns map with header and index pairs
	 * 
	 * @param headerRow
	 * @param headerColumns
	 * @return
	 */
	public static Map<String, Integer> getHeadersMap(Row headerRow, List<String> headerColumns, String sheetName) {
		Map<String, Integer> headersMap = new HashMap<String, Integer>();
		Iterator<Cell> headerCellIterator = headerRow.cellIterator();
		int size = headerColumns.size();
		while (headerCellIterator.hasNext()) {
			Cell cell = headerCellIterator.next();
			String label = cell.getStringCellValue();
			int labelIndex = cell.getColumnIndex();
			if (headersMap.size() == size) {
				return headersMap;
			}
			if (label.isEmpty()) {
			} else if (!headerColumns.contains(label)) {
			}
			headersMap.put(label, labelIndex);
		}
		// Identify missing columns
		Set<String> missingColumns = new HashSet<String>(headerColumns);
		missingColumns.removeAll(headersMap.keySet());
		if (!missingColumns.isEmpty()) {
		}
		return headersMap;

	}

	/**
	 * Validates Header row and Returns map with header and index pairs
	 * 
	 * @param headerRow
	 * @param headerColumns
	 * @return
	 */
	public static Map<String, Integer> getHeadersMap(Row headerRow, String sheetName) {
		Map<String, Integer> headersMap = new HashMap<String, Integer>();
		Iterator<Cell> headerCellIterator = headerRow.cellIterator();
		while (headerCellIterator.hasNext()) {
			Cell cell = headerCellIterator.next();
			String label = cell.getStringCellValue();
			int labelIndex = cell.getColumnIndex();
			if (!StringUtils.isEmpty(label)) {
				headersMap.put(label, labelIndex);
			}
		}
		return headersMap;
	}

	/**
	 * Returns last non empty row
	 * 
	 * @param sheet
	 * @return last index
	 */
	public static int getLastNonEmptyRow(Sheet sheet) {
		int lastNonEmptyIndex = 0;
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (!isBlankRow(row)) {
				lastNonEmptyIndex = row.getRowNum();
			}
		}
		return lastNonEmptyIndex;
	}

	/**
	 * returns the CDI bean instance by passing the Type.
	 * 
	 */

	public static <T> T getValue(Cell cell) {
		int cellType = cell.getCellType();
		Object cellValue = null;
		if (cellType == Cell.CELL_TYPE_NUMERIC) {
			cellValue = cell.getNumericCellValue();
			if (DateUtil.isCellDateFormatted(cell)) {
				cellValue = HSSFDateUtil.getJavaDate((Double) cellValue);
			} else {
				String cellStyle = cell.getCellStyle().getDataFormatString();
				if (cellStyle.equalsIgnoreCase("general") || cellStyle.equalsIgnoreCase("@")) {
					cellValue = (int) Math.round(cell.getNumericCellValue());
				} else {
					int pos = cellStyle.indexOf(".");
					if (pos > 0) {
						int precision = cellStyle.length() - 1 - pos;
						cellValue = new BigDecimal((Double) cellValue).setScale(precision, BigDecimal.ROUND_HALF_UP);
					} else {
						DecimalFormat df = new DecimalFormat(cellStyle.replace(",", ""));
						cellValue = Long.parseLong(df.format(cellValue));
					}
				}
			}

		} else if (cellType == Cell.CELL_TYPE_STRING) {
			cellValue = cell.getStringCellValue();
		} else if (cellType == Cell.CELL_TYPE_BOOLEAN) {
			cellValue = cell.getBooleanCellValue();
		}
		return (T) cellValue;
	}

	public static Map<String, String> getCustomColumnMap(Class entity) {
		Map<String, String> map = new LinkedHashMap<>();
		Field[] fields = entity.getDeclaredFields();
		for (Field field : fields) {
			ExcelHeader excelHeader = field.getAnnotation(ExcelHeader.class);
			if (excelHeader != null) {
				map.put(excelHeader.name(), field.getName());

			}
		}
		return map;

	}
}

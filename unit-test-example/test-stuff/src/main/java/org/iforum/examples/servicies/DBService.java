package org.iforum.examples.servicies;

/**
 * ������ ��� ������ � ����� ������.
 * 
 * @author igor.ch
 * 
 */
public interface DBService {

	/**
	 * ����� ��������� ������ � ��.
	 * 
	 * @param workData
	 * @return
	 */
	public WorkData saveToDB(WorkData workData);
}

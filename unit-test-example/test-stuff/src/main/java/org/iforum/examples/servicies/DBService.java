package org.iforum.examples.servicies;

/**
 * Сервис для работы с базой данных.
 * 
 * @author igor.ch
 * 
 */
public interface DBService {

	/**
	 * Метод сохраняет данные в БД.
	 * 
	 * @param workData
	 * @return
	 */
	public WorkData saveToDB(WorkData workData);
}

package org.iforum.examples.servicies;

/**
 * Сервис по вычислению данных.
 * 
 * @author igor.ch
 * 
 */
public interface CalcService {

	/**
	 * Выполняем вычисления над данными
	 * 
	 * @param workData
	 * @return
	 */
	public WorkData calculate(WorkData workData);
}
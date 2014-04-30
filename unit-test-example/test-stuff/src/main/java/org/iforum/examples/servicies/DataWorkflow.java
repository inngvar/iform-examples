package org.iforum.examples.servicies;

/**
 * Обработчик данных
 * 
 * @author igor.ch
 * 
 */
public class DataWorkflow {

	private RemoteService remoteService;
	private CalcService calcService;
	private DBService dbService;

	/**
	 * Конструктор
	 * 
	 * @param remoteService
	 *            Сервис для общения с удаленной системой
	 * @param calcService
	 *            Сервис для вычисления данных
	 * @param dbService
	 *            Сервис для работы с базой данных
	 */
	public DataWorkflow(RemoteService remoteService, CalcService calcService, DBService dbService) {
		this.remoteService = remoteService;
		this.calcService = calcService;
		this.dbService = dbService;
	}

	/**
	 * Выполнение операций над данными
	 * 
	 * @param workData
	 *            Данные над которыми будет выполненна операция.А
	 */
	public void doWork(WorkData workData) {

		remoteService.sendDataToRemoteService(workData); // Отошлем данные на
															// удаленный сервис
		workData = calcService.calculate(workData); // Выполнить необходимые
													// вычисления.
		dbService.saveToDB(workData);// сохранить данные в базу данных
	}
}

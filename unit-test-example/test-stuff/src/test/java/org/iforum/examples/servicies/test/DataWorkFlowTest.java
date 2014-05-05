package org.iforum.examples.servicies.test;
import org.easymock.EasyMock;
import org.iforum.examples.servicies.CalcService;
import org.iforum.examples.servicies.DBService;
import org.iforum.examples.servicies.DataWorkflow;
import org.iforum.examples.servicies.RemoteService;
import org.iforum.examples.servicies.WorkData;
import org.junit.Before;
import org.junit.Test;

/**
 * Тестирование класса DataWorkflow
 * 
 * @author igor.ch
 * 
 */
public class DataWorkFlowTest {

	/**
	 * Сервис обработки данных
	 */
	DataWorkflow dataWorkflow = null;

	/**
	 * Исходные Тестовые данные.
	 */
	WorkData sourceData = null;

	/**
	 * Тестовые данные после вычислений
	 */
	WorkData calculatedData = null;

	/**
	 * Тестовые данные после сохранения
	 */
	WorkData savedData = null;

	/**
	 * Сервис для работы с бд
	 */
	DBService dbService = null;

	/**
	 * Сервис для проведения вычислений.
	 */
	CalcService calcService = null;

	/**
	 * Сервися для работы с удаленным сервисом.
	 */
	RemoteService remoteService = null;

	/**
	 * Методы помечанные аннотацией Before выполняются каждый раз перед запуском
	 * теста
	 */
	@Before
	public void initialize() {
		// Создаем список данных который будет проходить по нашей цепочки
		sourceData = createData();
		calculatedData = createData();
		savedData = createData();

		// Сервис сохранения базы данных дожен попасть данные после расчетов, а
		// на выходе дожны быть данные после сохранения
		dbService = createDBService(calculatedData, savedData);

		// В сервис расчета должны попасть исходные данные, а на выходе дожны
		// быть данные после расчетов.
		calcService = createCalcService(sourceData, calculatedData);

		// В сервис отправки сообщений на удаленный сервер дожны попасть
		// сохраненные данные
		remoteService = createRemoteService(savedData);
		dataWorkflow = new DataWorkflow(remoteService, calcService, dbService);

	}

	/**
	 * Проверяем правильность работы метода doWork
	 */
	@Test
	public void testDoWork() {
		dataWorkflow.doWork(sourceData);
		EasyMock.verify(dbService, calcService, remoteService);
	}

	/**
	 * Создать тестовые данные
	 * 
	 * @return
	 */
	private WorkData createData() {
		// Создаем фейковую реализацию интерфейса.
		WorkData data = EasyMock.createMock(WorkData.class);

		// Устонавливаем правило вызова методов.
		// Читать так: Если был вызван метод getCount, то вернуть 10; Сколько
		// угодно раз
		EasyMock.expect(data.getCount()).andReturn(10).anyTimes();

		// Инициализировать все методы data
		EasyMock.replay(data);
		return data;
	}

	/**
	 * Создать Mock сервиса для работы сбазой данных
	 * 
	 * @param data
	 * @return
	 */
	private DBService createDBService(WorkData in, WorkData out) {
		DBService service = EasyMock.createMock(DBService.class);
		EasyMock.expect(service.saveToDB(in)).andReturn(out);
		EasyMock.replay(service);
		return service;
	}

	/**
	 * Создать Mock сервиса обработки данных
	 * 
	 * @param data
	 * @return
	 */
	private CalcService createCalcService(WorkData in, WorkData out) {

		CalcService service = EasyMock.createMock(CalcService.class);
		EasyMock.expect(service.calculate(in)).andReturn(out);
		EasyMock.replay(service);
		return service;
	}

	/**
	 * Создать Mock сервиса работы с удаленным сервисом
	 * 
	 * @param data
	 * @return
	 */
	private RemoteService createRemoteService(WorkData in) {
		RemoteService service = EasyMock.createMock(RemoteService.class);

		// А вот так нужно поступать с методами у которых return type - void

		// Делаем пример вызова метода.
		service.sendDataToRemoteService(in);

		// Объясняем EasyMock, что при выолнение программы нужно ожидать
		// предыдущего вызва ровно один раз.
		EasyMock.expectLastCall().once();
		EasyMock.replay(service);
		return service;
	}

}

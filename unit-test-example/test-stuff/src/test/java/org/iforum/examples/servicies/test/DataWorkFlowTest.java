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
 * ������������ ������ DataWorkflow
 * 
 * @author igor.ch
 * 
 */
public class DataWorkFlowTest {

	/**
	 * ������ ��������� ������
	 */
	DataWorkflow dataWorkflow = null;

	/**
	 * �������� �������� ������.
	 */
	WorkData sourceData = null;

	/**
	 * �������� ������ ����� ����������
	 */
	WorkData calculatedData = null;

	/**
	 * �������� ������ ����� ����������
	 */
	WorkData savedData = null;

	/**
	 * ������ ��� ������ � ��
	 */
	DBService dbService = null;

	/**
	 * ������ ��� ���������� ����������.
	 */
	CalcService calcService = null;

	/**
	 * ������� ��� ������ � ��������� ��������.
	 */
	RemoteService remoteService = null;

	/**
	 * ������ ���������� ���������� Before ����������� ������ ��� ����� ��������
	 * �����
	 */
	@Before
	public void initialize() {
		// ������� ������ ������ ������� ����� ��������� �� ����� �������
		sourceData = createData();
		calculatedData = createData();
		savedData = createData();

		// ������ ���������� ���� ������ ����� ������� ������ ����� ��������, �
		// �� ������ ����� ���� ������ ����� ����������
		dbService = createDBService(calculatedData, savedData);

		// � ������ ������� ������ ������� �������� ������, � �� ������ �����
		// ���� ������ ����� ��������.
		calcService = createCalcService(sourceData, calculatedData);

		// � ������ �������� ��������� �� ��������� ������ ����� �������
		// ����������� ������
		remoteService = createRemoteService(savedData);
		dataWorkflow = new DataWorkflow(remoteService, calcService, dbService);

	}

	/**
	 * ��������� ������������ ������ ������ doWork
	 */
	@Test
	public void testDoWork() {
		dataWorkflow.doWork(sourceData);
		EasyMock.verify(dbService, calcService, remoteService);
	}

	/**
	 * ������� �������� ������
	 * 
	 * @return
	 */
	private WorkData createData() {
		// ������� �������� ���������� ����������.
		WorkData data = EasyMock.createMock(WorkData.class);

		// ������������� ������� ������ �������.
		// ������ ���: ���� ��� ������ ����� getCount, �� ������� 10; �������
		// ������ ���
		EasyMock.expect(data.getCount()).andReturn(10).anyTimes();

		// ���������������� ��� ������ data
		EasyMock.replay(data);
		return data;
	}

	/**
	 * ������� Mock ������� ��� ������ ������ ������
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
	 * ������� Mock ������� ��������� ������
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
	 * ������� Mock ������� ������ � ��������� ��������
	 * 
	 * @param data
	 * @return
	 */
	private RemoteService createRemoteService(WorkData in) {
		RemoteService service = EasyMock.createMock(RemoteService.class);

		// � ��� ��� ����� ��������� � �������� � ������� return type - void

		// ������ ������ ������ ������.
		service.sendDataToRemoteService(in);

		// ��������� EasyMock, ��� ��� ��������� ��������� ����� �������
		// ����������� ����� ����� ���� ���.
		EasyMock.expectLastCall().once();
		EasyMock.replay(service);
		return service;
	}

}

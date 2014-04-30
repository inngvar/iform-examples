package org.iforum.examples.servicies;

/**
 * ���������� ������
 * 
 * @author igor.ch
 * 
 */
public class DataWorkflow {

	private RemoteService remoteService;
	private CalcService calcService;
	private DBService dbService;

	/**
	 * �����������
	 * 
	 * @param remoteService
	 *            ������ ��� ������� � ��������� ��������
	 * @param calcService
	 *            ������ ��� ���������� ������
	 * @param dbService
	 *            ������ ��� ������ � ����� ������
	 */
	public DataWorkflow(RemoteService remoteService, CalcService calcService, DBService dbService) {
		this.remoteService = remoteService;
		this.calcService = calcService;
		this.dbService = dbService;
	}

	/**
	 * ���������� �������� ��� �������
	 * 
	 * @param workData
	 *            ������ ��� �������� ����� ���������� ��������.�
	 */
	public void doWork(WorkData workData) {

		remoteService.sendDataToRemoteService(workData); // ������� ������ ��
															// ��������� ������
		workData = calcService.calculate(workData); // ��������� �����������
													// ����������.
		dbService.saveToDB(workData);// ��������� ������ � ���� ������
	}
}

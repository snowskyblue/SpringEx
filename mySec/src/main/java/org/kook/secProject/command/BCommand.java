/**
 * Controller�� ������ request�� �л�ó���ϴ� Ŭ�������� �������̽�
 */
package org.kook.secProject.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BCommand {
	void execute(Model model,HttpServletRequest request); 
	//�߻�޼���� public abstract�� �����Ǿ� �ְ� ������Ÿ������ �Ǿ� ����
}

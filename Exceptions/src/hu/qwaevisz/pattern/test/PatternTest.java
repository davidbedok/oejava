package hu.qwaevisz.pattern.test;

import hu.qwaevisz.pattern.base.ModuleException;
import hu.qwaevisz.pattern.module.MessageErrorCodes;
import hu.qwaevisz.pattern.module.MessageException;
import hu.qwaevisz.pattern.module.WorkflowErrorCodes;
import hu.qwaevisz.pattern.module.WorkflowException;

public class PatternTest {

	public static int testModuleException(int i) throws ModuleException {
		switch (i) {
		case 0:
			throw new WorkflowException(WorkflowErrorCodes.WF_GENERAL, "Hiba tortent!");
		case 1:
			throw new MessageException(MessageErrorCodes.M_BADFORMAT);
		}
		return 0;
	}

	public static void testCatch(int i) {
		System.out.println("\n# testCatch(" + i + ")");
		try {
			PatternTest.testModuleException(i);
		} catch (WorkflowException e) {
			System.out.println("e.getError() --> " + e.getError());
			System.out.println("e.getError().getCode() --> " + e.getError().getCode());
			System.out.println("e.getMessage() --> " + e.getMessage());
			System.out.println("e.getLocalizedMessage() --> " + e.getLocalizedMessage());
		} catch (ModuleException e) {
			System.out.println("e.getError() --> " + e.getError());
			System.out.println("e.getError().getCode() --> " + e.getError().getCode());
			System.out.println("e.getMessage() --> " + e.getMessage());
			System.out.println("e.getLocalizedMessage() --> " + e.getLocalizedMessage());
		}
	}

	public static int messageModuleMethod(int i) throws MessageException {
		switch (i) {
		case 0:
			throw new MessageException(MessageErrorCodes.M_GENERAL);
		}
		return 0;
	}

	public static int workflowModuleMethod(int i) throws WorkflowException {
		try {
			return PatternTest.messageModuleMethod(i);
		} catch (MessageException e) {
			// WorkflowException we = new WorkflowException(WorkflowErrorCodes.fromCode(e.getError().getCode()), e);
			WorkflowException we = new WorkflowException(WorkflowErrorCodes.WF_GENERAL, e);
			we.setMessageExtension(e.getError().toString());
			throw we;
		}
	}

	public static void testModuleCatch(int i) {
		System.out.println("\n# testModuleCatch(" + i + ")");
		try {
			int result = workflowModuleMethod(i);
		} catch (ModuleException e) {
			System.out.println("e.getError() --> " + e.getError());
			System.out.println("e.getError().getCode() --> " + e.getError().getCode());
			System.out.println("e.getMessage() --> " + e.getMessage());
			System.out.println("e.getLocalizedMessage() --> " + e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		PatternTest.testCatch(0);
		PatternTest.testCatch(1);

		PatternTest.testModuleCatch(0);
	}

}

package Calculator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyAction implements KeyListener {
	PanelCalculator PC;

	public KeyAction(PanelCalculator PC) {
		super();
		this.PC = PC;

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_1:
			PC.textArea.append("1");
			break;

		case KeyEvent.VK_2:
			PC.textArea.append("2");
			break;

		case KeyEvent.VK_3:
			PC.textArea.append("3");
			break;
		case KeyEvent.VK_4:
			PC.textArea.append("4");
			break;

		case KeyEvent.VK_5:
			PC.textArea.append("5");
			break;

		case KeyEvent.VK_6:
			PC.textArea.append("6");
			break;
		case KeyEvent.VK_7:
			PC.textArea.append("7");
			break;

		case KeyEvent.VK_8:
			PC.textArea.append("8");
			break;

		case KeyEvent.VK_9:
			PC.textArea.append("9");
			break;
		case KeyEvent.VK_0:
			PC.textArea.append("0");
			break;
		case KeyEvent.VK_PERIOD:
			PC.textArea.append(".");
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}

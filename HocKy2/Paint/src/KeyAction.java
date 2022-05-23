
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyAction implements KeyListener {
	PaintPanel pp;
	
	public KeyAction(PaintPanel pp) {
		super();
		this.pp = pp;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (!e.isShiftDown())
			return;
		switch(key) {
		case KeyEvent.VK_L:
			pp.flag = "Line";
			break;
		case KeyEvent.VK_R:
			pp.flag = "Rec";
			break;
		case KeyEvent.VK_P:
			pp.flag = "Pen";
			break;
		case KeyEvent.VK_C:
			pp.flag = "Circle";
			break;
		default:
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

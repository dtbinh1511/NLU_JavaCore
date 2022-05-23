
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyAction implements ActionListener{
	PaintPanel pp;
	
	public MyAction(PaintPanel pp) {
		super();
		this.pp = pp;
	}
	 public void actionPerformed(ActionEvent e) {
		 pp.flag = e.getActionCommand();
		 
		 switch (pp.flag) {
		case "Exit":
			System.exit(0);
			break;
		case "Black":
			pp.color = Color.BLACK;
			break;
		case "Blue":
			pp.color = Color.BLUE;
			break;
		case "Green":
			pp.color = Color.GREEN;
			break;
		case "Red":
			pp.color = Color.RED;
			break;
		default:
			break;
		}
	 }

}

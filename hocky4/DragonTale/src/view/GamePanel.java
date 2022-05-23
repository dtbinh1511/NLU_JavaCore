package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import controller.IContronller;
import model.state.GameStateManager;
import observer.DataTime;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {

	// dimensions
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;

	// game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

	// image
	private BufferedImage image;
	private Graphics2D g;

	// game state manager
	private GameStateManager gsm;

	// controller
	private IContronller ctrl;

	public GamePanel(DataTime dataTime) {
		super();
		gsm = new GameStateManager(dataTime);
		ctrl = gsm.getCtrlState();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}

	private void init() {

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		running = true;

	}

	public void run() {

		init();

		long start;
		long elapsed;
		long wait;

		// game loop
		while (running) {

			start = System.nanoTime();

			update();
			draw();
			drawToScreen();

			elapsed = System.nanoTime() - start;

			wait = targetTime - elapsed / 1000000;
			if (wait < 0)
				wait = 5;

			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void update() {
		ctrl.update();
		ctrl = gsm.getCtrlState();
	}

	private void draw() {
		ctrl.draw(g);
	}

	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
	}

	public void keyTyped(KeyEvent key) {
	}

	public void keyPressed(KeyEvent key) {

		int k = key.getKeyCode();
		if (k == KeyEvent.VK_DOWN)
			ctrl.down();
		if (k == KeyEvent.VK_UP)
			ctrl.up();
		if (k == KeyEvent.VK_ENTER)
			ctrl.select();
		if (k == KeyEvent.VK_LEFT)
			ctrl.left(true);
		if (k == KeyEvent.VK_RIGHT)
			ctrl.right(true);
		if (k == KeyEvent.VK_W)
			ctrl.w(true);
		if (k == KeyEvent.VK_E)
			ctrl.e(true);
		if (k == KeyEvent.VK_R)
			ctrl.r();
		if (k == KeyEvent.VK_F)
			ctrl.f();
	}

	public void keyReleased(KeyEvent key) {
		int k = key.getKeyCode();
		if (k == KeyEvent.VK_LEFT)
			ctrl.left(false);
		if (k == KeyEvent.VK_RIGHT)
			ctrl.right(false);
		if (k == KeyEvent.VK_W)
			ctrl.w(false);
		if (k == KeyEvent.VK_E)
			ctrl.e(false);
	}

}

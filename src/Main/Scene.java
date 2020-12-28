package Main;

import javax.swing.JFrame;


public class Scene extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 550;
	public static final int WIDTH = 500;

	public Content content = new Content();

	public Scene() {
		setTitle("Pacman");
		setContentPane(content);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(true);
		//setFocusable(true);
	}
}

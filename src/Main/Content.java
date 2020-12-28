package Main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.ImageIcon;
import javax.swing.JPanel;


import Keyboard.TAdapter;

public class Content extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image block; 
	Image bleu;
	Image violet;
	Image orange;
	Image vert;
	Image pacman;
	Image ghost;
	Image brick;
	Image jaune;
	Image ghostbleu;
	Image pacorange;
	Dimension d;
	
	int gh = 0; //0 - ghost normal 1 - ghostbleu
	
	boolean ingame = true;
	int life = 3;
	int score = 0;
	int die = 0; //0 life 1 die
	
	int ghostw = 3;
	int ghostb = 11;
	
	int pac = 2;
	int pacJaune = 9;
	int pacOrange = 10;
	
	
	
	
	// 1 - block 2-pacman 3-ghost 4-brick 5-bleu 6-violet 7-orange 8-vert 
	//9 - pacmanjaune 10 - pacorange 11 - ghostbleu
	
	public int [][] maze = {
			{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
			{4,1,1,1,1,1,6,5,5,5,5,5,5,5,5,5,5,5,6,1,1,1,1,1,4},
			{4,1,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,3,1,4},
			{4,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,4},
			{4,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,4},

			{4,1,5,5,5,5,5,1,5,5,5,5,5,5,5,5,5,1,5,5,5,5,5,1,4},
			{4,5,5,5,5,5,5,1,5,5,5,5,8,5,5,5,5,1,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4},
			
			{4,5,5,5,5,5,5,5,5,5,1,1,1,1,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,2,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,1,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,1,4},
			
			{4,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,4},
			{4,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,4},
			{4,1,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,3,1,4},
			{4,1,1,1,1,1,7,5,5,5,5,5,5,5,5,5,5,5,7,1,1,1,1,1,4},
			{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
			};
	
	public int [][] mazereset = {
			{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
			{4,1,1,1,1,1,6,5,5,5,5,5,5,5,5,5,5,5,6,1,1,1,1,1,4},
			{4,1,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,3,1,4},
			{4,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,4},
			{4,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,4},

			{4,1,5,5,5,5,5,1,5,5,5,5,5,5,5,5,5,1,5,5,5,5,5,1,4},
			{4,5,5,5,5,5,5,1,5,5,5,5,8,5,5,5,5,1,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4},
			
			{4,5,5,5,5,5,5,5,5,5,1,1,1,1,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,2,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,1,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,1,4},
			
			{4,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,4},
			{4,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,4},
			{4,1,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,3,1,4},
			{4,1,1,1,1,1,7,5,5,5,5,5,5,5,5,5,5,5,7,1,1,1,1,1,4},
			{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
			};
	

	
	public int [][] maze2 = {
			{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
			{4,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,4},
			{4,1,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,3,1,4},
			{4,5,5,1,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,5,5,4},
			{4,5,5,1,6,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,1,5,5,4},
			
			{4,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,4},
			
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
			{4,5,5,5,5,5,5,5,5,5,1,5,5,5,1,5,5,5,5,5,5,5,5,5,4},
		
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,5,5,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,5,5,5,5,4},
			{4,5,5,1,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,1,5,5,4},
			
			{4,5,5,1,7,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7,1,5,5,4},
			{4,5,5,1,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,5,5,4},
			{4,1,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,3,1,4},
			{4,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,4},
			{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
			};
	
	
	public Content() {
		loadImage();
		d = new Dimension(600, 600);
		setBackground(Color.BLACK);
		addKeyListener(new TAdapter(this));
        setFocusable(true);
 
       
      
       
        }
        
	
	void start() {
		ingame = true;
		score = 0;
		die = 0;
		life = 3;
		maze = mazereset;
	}
	

	private void loadImage() {
		block = new ImageIcon(getClass().getResource("/images/block.jpg")).getImage();
		bleu = new ImageIcon(getClass().getResource("/images/bleu.png")).getImage();
		violet = new ImageIcon(getClass().getResource("/images/violet.png")).getImage();
		orange = new ImageIcon(getClass().getResource("/images/orange.png")).getImage();
		vert = new ImageIcon(getClass().getResource("/images/vert.png")).getImage();
		pacman = new ImageIcon(getClass().getResource("/images/pacman.png")).getImage();
		ghost = new ImageIcon(getClass().getResource("/images/ghost.png")).getImage();
		brick = new ImageIcon(getClass().getResource("/images/brick.jpg")).getImage();
		jaune = new ImageIcon(getClass().getResource("/images/jaune.png")).getImage();
		ghostbleu = new ImageIcon(getClass().getResource("/images/ghostbleu.png")).getImage();
		pacorange = new ImageIcon(getClass().getResource("/images/pacorange.png")).getImage();
	}
	
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//drawMaze
		int i =0;
		int j = 0;
		int x =0;
		int y = 0;
		for ( i = 0; i<maze.length;i++) {
			for (j = 0; j<maze.length;j++) {
				if(maze[i][j] == 1) {
					g2d.drawImage(block, x,y, null);
				}
				x = x+20;
			}
			x= 0;
			y=y+20;
		}
		//drawPacgommeBleu
		int k,h;
		int z = 5;
		int t = 5;
		for (k = 0; k<maze.length;k++) {
			for (h = 0; h<maze.length;h++) {
				if(maze[k][h] == 5) {
					g2d.drawImage(bleu, z,t, null);
				}
				z = z+20;
			}
			z= 5;
			t=t+20;
		}
		
		//drawPacgommeViolet
			z = 5;
			t = 5;
				for (k = 0; k<maze.length;k++) {
					for (h = 0; h<maze.length;h++) {
						if(maze[k][h] == 6) {
							g2d.drawImage(violet, z,t, null);
						}
						z = z+20;
					}
					z= 5;
					t=t+20;
				}
	
	
	//drawPacgommeOrange
	z = 5;
	t = 5;
		for (k = 0; k<maze.length;k++) {
			for ( h = 0; h<maze.length;h++) {
				if(maze[k][h] == 7) {
					g2d.drawImage(orange, z,t, null);
				}
				z = z+20;
			}
			z= 5;
			t=t+20;
		}
		
		//drawPacgommeVert
		z = 5;
		t = 5;
			for (k = 0; k<maze.length;k++) {
				for (h = 0; h<maze.length;h++) {
					if(maze[k][h] == 8) {
						g2d.drawImage(vert, z,t, null);
					}
					z = z+20;
				}
				z= 5;
				t=t+20;
			}
			
			//Pacman
			z = 0;
			t = 0;
				for (k = 0; k<maze.length;k++) {
					for (h = 0; h<maze.length;h++) {
						if(maze[k][h] == 2) {
							g2d.drawImage(pacman, z,t, null);
						}
						z = z+20;
					}
					z= 0;
					t=t+20;
				}
				
				//PacmanJaune
				z = 0;
				t = 0;
					for (k = 0; k<maze.length;k++) {
						for (h = 0; h<maze.length;h++) {
							if(maze[k][h] == 9) {
								g2d.drawImage(jaune, z,t, null);
							}
							z = z+20;
						}
						z= 0;
						t=t+20;
					}
					
					//PacmanOrange
					z = 0;
					t = 0;
						for (k = 0; k<maze.length;k++) {
							for (h = 0; h<maze.length;h++) {
								if(maze[k][h] == 10) {
									g2d.drawImage(pacorange, z,t, null);
								}
								z = z+20;
							}
							z= 0;
							t=t+20;
						}
				
				//Ghost
				z = 0;
				t = 0;
					for (k = 0; k<maze.length;k++) {
						for (h = 0; h<maze.length;h++) {
							if(maze[k][h] == 3) {
								g2d.drawImage(ghost, z,t, null);
							}
							z = z+20;
						}
						z= 0;
						t=t+20;
					}
					
					//Ghostbleu
					z = 0;
					t = 0;
						for (k = 0; k<maze.length;k++) {
							for (h = 0; h<maze.length;h++) {
								if(maze[k][h] == 11) {
									g2d.drawImage(ghostbleu, z,t, null);
								}
								z = z+20;
							}
							z= 0;
							t=t+20;
						}
					
					//Brick
					z = 0;
					t = 0;
						for (k = 0; k<maze.length;k++) {
							for (h = 0; h<maze.length;h++) {
								if(maze[k][h] == 4) {
									g2d.drawImage(brick, z,t, null);
								}
								z = z+20;
							}
							z= 0;
							t=t+20;
						}
				
				//drawscore
				i = 0;
				x = 0;
			    String s1,s2;
			    g2d.setFont(Font.getFont("Veranda"));
			    g2d.setColor(Color.WHITE);
			    s1 = "Score: " + score;
			    g2d.drawString(s1,380,515);
			    s2 = "Life: " + life;
			    g2d.drawString(s2,20,515);
			    
			 
		}

	public void update(Graphics g) {
		paintComponents(g);
		
	}

	int time = 0;
	
//DI chuyen pacman	
	public void moveup() {

			for (int i =0; i<maze.length;i++) {
				for (int j = 0; j<maze.length;j++) {
					if(maze[i][j] == pac) {
						//settime
						time++;
					
						//cham tuong
						if (maze[i-1][j] == 4) {
							if (maze[maze.length-1][j] == 5) {
								score = score + 100;
							} 
							if (maze[maze.length-1][j] == 6) {
								score = score + 300;
								VioletPower();
							} 
							if (maze[maze.length-1][j] == 7) {
								score = score + 500;
								OrangePower();
							} 
							if (maze[maze.length-1][j] == 8) {
								score = score + 1000;
								VertPower();
							}
							maze[i][j] = 0;
							maze[maze.length-1][j] = pac;
						
				
						} 
						//gap ma
						else if (maze[i-1][j] == ghostw) { 
							seeGhost(pac, i-2, j, i, j,i-1,j);
						
						}
						//ko cham
						else 	 if (maze[i-1][j] != 1 && maze[i-1][j] != 4 && maze[i-1][j] != 3) {
							if (maze[i-1][j] == 5) {
								score = score + 100;
							} 
							if (maze[i-1][j] == 6) {
								score = score + 300;
								time = 0;
								VioletPower();
								
							} 
							if (maze[i-1][j] == 7) {
								score = score + 500;
								OrangePower();
							} 
							if (maze[i-1][j] == 8) {
								score = score + 1000;
								VertPower();
							}
							if (i == 24) {
								maze[i][j] = 4;
								maze[i-1][j] = pac;
							
							} else {
							maze[i][j] = 0;
							maze[i-1][j] = pac;
							
							}
					}
						
					}
				}
			}
			
			ScoreLife();
			repaint();
		
		}
	
	public void movedown() {
		
		for (int i =0; i<maze.length;i++) {
			for (int j = 0; j<maze.length;j++) {
				if(maze[i][j] == pac) {
					//settime
					time++;
					
					//cham tuong
					if (maze[i+1][j] == 4) {
						if (maze[maze.length-(maze.length-1)][j] == 5) {
							score = score + 100;
						} 
						if (maze[maze.length-(maze.length-1)][j] == 6) {
							score = score + 300;
							VioletPower();
						} 
						if (maze[maze.length-(maze.length-1)][j] == 7) {
							score = score + 500;
							OrangePower();
						} 
						if (maze[maze.length-(maze.length-1)][j] == 8) {
							score = score + 1000;
							VertPower();
						}
						maze[i][j] = 0;
						maze[maze.length-(maze.length-1)][j] = pac;
				
						
					}
					//gap ma
					else if (maze[i+1][j] == ghostw) {
						maze[i][j] = 0;
						seeGhost(pac, i+2, j, i, j,i+1,j);
					
					//	i=i+1;
					}
					//ko cham
					else 	 if (maze[i+1][j] != 1 && maze[i+1][j] != 4 && maze[i+1][j] != 3) {
						if (maze[i+1][j] == 5) {
							score = score + 100;
						} 
						if (maze[i+1][j] == 6) {
							score = score + 300;
							time = 0;
							VioletPower();
						} 
						if (maze[i+1][j] == 7) {
							score = score + 500;
							OrangePower();
						} 
						if (maze[i+1][j] == 8) {
							score = score + 1000;
							VertPower();
						}
						maze[i][j] = 0;
						maze[i+1][j] = pac;
						
						i=i+2;
				}
				}
			}
		}
		
		ScoreLife();
		repaint();
		
	}
	
public void moveleft() {
		
		for (int i =0; i<maze.length;i++) {
			for (int j = 0; j<maze.length;j++) {
				if(maze[i][j] == pac) {
					//settime
					time++;
					
					//cham tuong
					if (maze[i][j-1] == 4) {
						
						if (maze[i][maze.length-1] == 5) {
							score = score + 100;
						} 
						if (maze[i][maze.length-1] == 6) {
							score = score + 300;
							VioletPower();
						} 
						if (maze[i][maze.length-1] == 7) {
							score = score + 500;
							OrangePower();
						} 
						if (maze[i][maze.length-1] == 8) {
							score = score + 1000;
							VertPower();
						}
						maze[i][j] = 0;
						maze[i][maze.length-1] = pac;
				
			
						
					}
					//gap ma
						if (maze[i][j-1] == ghostw) {
						maze[i][j] = 0;
						seeGhost(pac, i, j-2, i, j,i,j-1);
					
					}
					//ko cham
					else	 if (maze[i][j-1] != 1 && maze[i][j-1] != 4 && maze[i][j-1] != 3) {
						if (maze[i][j-1] == 5) {
							score = score + 100;
						} 
						if (maze[i][j-1] == 6) {
							score = score + 300;
							time = 0;
							VioletPower();
						} 
						if (maze[i][j-1] == 7) {
							score = score + 500;
							OrangePower();
						} 
						if (maze[i][j-1] == 8) {
							score = score + 1000;
							VertPower();
						}
						if (j == 24) {
							maze[i][j] = 4;
							maze[i][j-1] = pac;
						
						} else {
							maze[i][j] = 0;
							maze[i][j-1] = pac;
						
						}
						
				}
				}
			}
		}
		
		ScoreLife();
		repaint();
		
	}

public void moveright() {
	
	for (int i =0; i<maze.length;i++) {
		for (int j = 0; j<maze.length;j++) {
			if(maze[i][j] == pac) {
				//settime
				time++;
				
				//cham tuong
				if (maze[i][j+1] == 4) {
					if (maze[i][maze.length-(maze.length-1)] == 5) {
						score = score + 100;
					} 
					if (maze[i][maze.length-(maze.length-1)] == 6) {
						score = score + 300;
						VioletPower();
					} 
					if (maze[i][maze.length-(maze.length-1)] == 7) {
						score = score + 500;
						OrangePower();
					} 
					if (maze[i][maze.length-(maze.length-1)] == 8) {
						score = score + 1000;
						VertPower();
					}
					maze[i][j] = 0;
					maze[i][maze.length-(maze.length-1)] = pac;
					
					
				}
				else	if (maze[i][j+1] == ghostw) {
				//	maze[i][j] = 0;
					seeGhost(pac, i, j+2, i, j,i,j+1);
				//j=j+1;
				}
				//ko cham
				else	if (maze[i][j+1] != 1 && maze[i][j+1] != 4 && maze[i][j+1] != 3) {
					if (maze[i][j+1] == 5) {
						score = score + 100;
					} 
					if (maze[i][j+1] == 6) {
						score = score + 300;
						time = 0;
						VioletPower();
					} 
					if (maze[i][j+1] == 7) {
						score = score + 500;
						OrangePower();
					} 
					if (maze[i][j+1] == 8) {
						score = score + 1000;
						VertPower();
					}
					maze[i][j] = 0;
					maze[i][j+1] = pac;
					j=j+2;
			}
			}
			
		}
	}
	
	ScoreLife();
	repaint();

}

void ScoreLife () {
	if (score >= 5000) {
		life = life + 1;
		score = score - 5000;
	}
	
}




void moveGhost() {
int t;
		int i,j;
		for (i = 0; i<maze.length;i++) {
			for (j = 0; j<maze.length;j++) {
				if (maze[i][j] == 3) {
					//go right
					if (maze[i-2][j] == 4 && maze[i][j+2] != 4) {
						if(maze[i][j+1] == 2) {
							maze[i][j+1] = 0;
							maze[maze.length/2][maze.length/2] = 2;
							life = life - 1; 
						} else {
							t = maze[i][j+1];
							maze[i][j+1] = maze[i][j];
							maze[i][j] = t;
							j=j+1;
						}
					}
					//go down
					else if (maze[i][j+2] == 4 && maze[i+2][j] != 4) {
						if(maze[i+1][j] == 2) {
							maze[i+1][j] = 0;
							maze[maze.length/2][maze.length/2] = 2;
							life = life - 1; 
						} else {
						t = maze[i+1][j];
						maze[i+1][j] = maze[i][j];
						maze[i][j] = t;
						i=i+1;
						}
					}
					//go left
					else	if (maze[i+2][j] == 4 && maze[i][j-2] != 4) {
						if(maze[i][j-1] == 2) {
							maze[i][j-1] = 0;
							maze[maze.length/2][maze.length/2] = 2;
							life = life - 1; 
						} else {
						t = maze[i][j-1];
						maze[i][j-1] = maze[i][j];
						maze[i][j] = t;
						}
					}
					//go up
					else	if (maze[i][j-2] == 4 && maze[i-2][j] != 4) {
						if(maze[1-1][j] == 2) {
							maze[i-1][j] = 0;
							maze[maze.length/2][maze.length/2] = 2;
							life = life - 1; 
						} else {
						t = maze[i-1][j];
						maze[i-1][j] = maze[i][j];
						maze[i][j] = t;
						}
					}
					//go special 1
					else if (maze[i][j+12] == 4 && maze[i+6][j] != 4) {
						if (maze[i+1][j] == 2) {
							maze[i+1][j] = 0;
							maze[maze.length/2][maze.length/2] = 2;
							life = life - 1; 
						} else {
						t = maze[i+1][j];
						maze[i+1][j] = maze[i][j];
						maze[i][j] = t;
						i=i+1;
						}
					}
					//go special 2
					else if (maze[i+6][j] == 4 && maze[i][j-6] != 4) {
						if (maze[i][j-1] == 2) {
							maze[i][j-1]=0;
							maze[maze.length/2][maze.length/2]=2;
							life = life - 1;
						} else {
						t = maze[i][j-1];
						maze[i][j-1] = maze[i][j];
						maze[i][j] = t;
					} 
					}
					//go special 3
					else if (maze[i][j-6] == 4 && maze[i-2][j] != 4) {
						if (maze[i-1][j] == 2) {
							maze[i-1][j]=0;
							maze[maze.length/2][maze.length/2]=2;
							life = life - 1;
						} else {
						t = maze[i-1][j];
						maze[i-1][j] = maze[i][j];
						maze[i][j] = t;
						}
					}
				}
			}
		
	
		}
		repaint();
	}


// cd  - ij , ab - avant+2 , ef avant+1
public void seeGhost(int pac, int a, int b,int c,int d, int e,int f) {
	//if ef = 3
	//back to center
if(pac == 2) {
	maze[c][d] = 0;
	maze[maze.length/2][maze.length/2] = 2;
	life = life - 1;  
}
if (pac == 9) {
	if(maze[a][b] != 1 && maze[a][b] != 4) {
		maze[a][b] = pac;
		maze[c][d] = 0;
		//t++;
	} else {
		maze[c][d] = pac;
	}
}
if(pac == 10) {
	maze[e][f] = pac;
	maze[c][d] = 0;
	maze[maze.length/2][maze.length/2] = 11;
}
}

int mark = 0;
long time1;
long time2;
public void VioletPower() {
	time1 = System.currentTimeMillis();
	mark = 1;
	pac = pacJaune;
	gh = 0;
	ghostw = 3;
	for(int i = 0; i < maze.length;i++) {
		for (int j = 0; j<maze.length;j++) {
			if(maze[i][j] == 11) {
				maze[i][j] = 3;
				
			}
		}
	}
}


public void VertPower() {
	mark = 2;
	normalstate();
	maze = maze2;
	
}

public void OrangePower() {
	time1 = System.currentTimeMillis();
	mark = 3;
	gh = 1;
	pac = pacOrange;
	ghostw = ghostb;
	for(int i = 0; i < maze.length;i++) {
		for (int j = 0; j<maze.length;j++) {
			if(maze[i][j] == 3) {
				maze[i][j] = 11;
				
			}
		}
	}
}

void moveGhostBleu() {
int t;
		int i,j;
		for (i = 0; i<maze.length;i++) {
			for (j = 0; j<maze.length;j++) {
				if (maze[i][j] == 11) {
					//go right
					if (maze[i-2][j] == 4 && maze[i][j+2] != 4) {
						if (maze[i][j+1] == 2 || maze[i][j+1] == 9 || maze[i][j+1] == 10) {
							maze[i][j]=0;
							maze[maze.length/2][maze.length/2]=11;
						} else {
							t = maze[i][j+1];
							maze[i][j+1] = maze[i][j];
							maze[i][j] = t;
							j=j+1;
						}
					}
					//go down
					else if (maze[i][j+2] == 4 && maze[i+2][j] != 4) {
						if (maze[i+1][j] == 2 || maze[i+1][j] == 9 || maze[i+1][j] == 10) {
							maze[i][j]=0;
							maze[maze.length/2][maze.length/2]=11;
						} else {
						t = maze[i+1][j];
						maze[i+1][j] = maze[i][j];
						maze[i][j] = t;
						i=i+1;
						}
					}
					//go left
					else	if (maze[i+2][j] == 4 && maze[i][j-2] != 4) {
						if (maze[i][j-1] == 2 || maze[i][j-1] == 9 || maze[i][j-1] == 10) {
							maze[i][j]=0;
							maze[maze.length/2][maze.length/2]=11;
						} else {
						t = maze[i][j-1];
						maze[i][j-1] = maze[i][j];
						maze[i][j] = t;
						}
					}
					//go up
					else	if (maze[i][j-2] == 4 && maze[i-2][j] != 4) {
						if (maze[i-1][j] == 2 || maze[i-1][j] == 9 || maze[i-1][j] == 10) {
							maze[i][j]=0;
							maze[maze.length/2][maze.length/2]=11;
						} else {
						t = maze[i-1][j];
						maze[i-1][j] = maze[i][j];
						maze[i][j] = t;
						}
					} 
					//go special 1
					else if (maze[i][j+12] == 4 && maze[i+6][j] != 4) {
						if (maze[i+1][j] == 2 || maze[i+1][j] == 9 || maze[i+1][j] == 10) {
							maze[i][j]=0;
							maze[maze.length/2][maze.length/2]=11;
						} else {
						t = maze[i+1][j];
						maze[i+1][j] = maze[i][j];
						maze[i][j] = t;
						i=i+1;
						}
					}
					//go special 2
					else if (maze[i+6][j] == 4 && maze[i][j-6] != 4) {
						if (maze[i][j-1] == 2 || maze[i][j-1] == 9 || maze[i][j-1] == 10) {
							maze[i][j]=0;
							maze[maze.length/2][maze.length/2]=11;
						} else {
						t = maze[i][j-1];
						maze[i][j-1] = maze[i][j];
						maze[i][j] = t;
					} 
					}
					//go special 3
					else if (maze[i][j-6] == 4 && maze[i-2][j] != 4) {
						if (maze[i-1][j] == 2 || maze[i-1][j] == 9 || maze[i-1][j] == 10) {
							maze[i][j]=0;
							maze[maze.length/2][maze.length/2]=11;
						} else {
						t = maze[i-1][j];
						maze[i-1][j] = maze[i][j];
						maze[i][j] = t;
						}
					}
				}
			}
		
	
		}
		repaint();
	}

void normalstate() {
	mark = 0;
	for(int i = 0; i < maze.length; i++) {
		for (int j = 0; j< maze.length ; j++) {
			if(maze[i][j] == 9 || maze[i][j] == 10) {
				pac = 2;
				maze[i][j] = 2;
			}
			if(maze[i][j] == 11) {
				ghostw = 3;
				gh = 0;
				maze[i][j] = 3;
			}
		}
	}
}

void end() {
	int sum = 0;
	if (life < 0) {
		ingame = false;
		die = 1;
		start();
		System.out.println("End Game! You Lose!");
	} else {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if(maze[i][j] == 5 || maze[i][j] == 6 || maze[i][j] == 7 || maze[i][j] == 8 ) {
					sum = sum + 1;
				} 
				
			}
		}
		if (sum == 0) {
			start();
			System.out.println("End Game! You Win!");
		}
	}
}

public class MyThread extends Thread {
	@Override 
	public void run() {
		
	
		while (ingame) {
			
		
			
		if(gh == 0) {
			moveGhost();
			try {
				MyThread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			moveGhostBleu();
			try {
				MyThread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	if (mark != 0) {
		//set TImer
		time2 = System.currentTimeMillis();
		if((time2 - time1) > 1998) {
			 normalstate();
		}
	       
	}
		
		end();
		
		}
}
 
}

MyThread mt = new MyThread();



}
	
	
	
	


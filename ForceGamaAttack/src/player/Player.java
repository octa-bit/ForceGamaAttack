package player;

import constants.Constants;
import entities.BulletManager;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;	

public class Player extends Sprite{
	private Player player;
	private int sentidoAnterior;
	private int sentido;
	
	public static BulletManager bulletmanager;
	 public String bulletimg = "src/graphics/img/bullet_player.png";
	
	public Player(double x, double  y) {
		super("src/graphics/img/spaceship.png", 10);
		this.x = x;
		this.y = y;
		sentido = Constants.RIGHT;
        sentidoAnterior = Constants.RIGHT;
	}
	
	public void move(Keyboard teclado) {
		
		//player.moveY(10.0);
		//player.moveX(10.0);
		 if ( teclado.keyDown(Keyboard.LEFT_KEY) && this.x > 1 )
         {
                 //Se antes o boneco se locomovia para a direita ou estava parado.
                 if (sentido != Constants.LEFT) 
                 {   
                     //setSequence(0, 13);
                     sentidoAnterior = Constants.LEFT;
                     sentido = Constants.LEFT;
                 }
                 this.x -= 2;

         }
         else
         {
                 //Faz o boneco se locomover para a direita.
                 if ( teclado.keyDown(Keyboard.RIGHT_KEY))
                     {
                             //Se antes o boneco se locomovia para a esquerda ou estava parado.
                             if (sentido != Constants.RIGHT)
                             {
                              //  setSequence(14, 27);
                                 sentidoAnterior = Constants.RIGHT;
                                 sentido = Constants.RIGHT;
                             }
                             this.x += 2;
                     }
                 else
                 {                     
                     //O boneco está parado.
                     sentido = Constants.STOP;

                     //Verifica se o sentido anterior do boneco e seta o frame correspondente
                     //a esse sentido.
                     if (sentidoAnterior == Constants.RIGHT)
                         setCurrFrame(17);
                     else
                     {
                         //Verifica se o sentido anterior do boneco e seta o frame correspondente
                         //a esse sentido.
                         if (sentidoAnterior == Constants.LEFT)
                             setCurrFrame(3);
                     }
                 }
         }

         //Se o boneco não está parado então pode rodar a animação
         if (sentido != Constants.STOP) {
         	update();
         }
	}
	
	public int getSentido()
    {
            return sentidoAnterior;
    }
	
}

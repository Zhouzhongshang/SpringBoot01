package cn.Test.manyThreadStudy;

import org.apache.log4j.Logger;

public class Hero {
	private static final Logger log=Logger.getLogger(Hero.class);
      public String name;
      public double hp;
      public int damage;
      
      public Hero(){
    	  log.info("无参构造");
      }
      public Hero(String name,double hp,int damage){
    	  this.name=name;
    	  this.hp=hp;
    	  this.damage=damage;
    	  log.info("全参构造");
      }
      /**
       * 攻击的方法
       * @param h
       */
      public void att(Hero h){
    	  //每次攻击需要1000ms的时间
    	  try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	  h.hp-=this.damage;
    	  log.info(this.name+"在攻击"+h.name+":"+h.name+"的血量为"+h.hp);
    	  if(h.hp<=0){
    		  log.info("已经死亡");
    	  }
      }
}
